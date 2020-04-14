package com.example.house.Controller;

import com.example.house.Entity.*;
import com.example.house.Service.DistrictService;
import com.example.house.Service.HouseService;
import com.example.house.Service.HouseTypeService;
import com.example.house.Service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainLoginController {

    @Autowired
    private HouseTypeService houseTypeServiceImpl;

    @Autowired
    private StreetService streetServiceImpl;

    @Autowired
    private DistrictService districtServiceImpl;


    @Autowired
    private HouseService houseServiceImpl;

    @RequestMapping("/queryHouseType")
    @ResponseBody
    public List<HouseType> queryHouseType(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<HouseType> houseTypes = houseTypeServiceImpl.queryHouseType();
        return houseTypes;
    }

    @RequestMapping("/queryDistrict")
    @ResponseBody
    public List<District> queryDistrict(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<District> districtList = districtServiceImpl.queryDistrictAll();
        return districtList;
    }

    @RequestMapping("/queryStreet")
    @ResponseBody
    public List<Street> queryStreet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String dId = request.getParameter("districtId");
        List<Street> streetList = streetServiceImpl.queryStreet(dId);
        return streetList;
    }

    @RequestMapping("/queryHouseByPrice")
    @ResponseBody
    public List<House> queryHouseByPrice(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<House> HouseByPriceList = houseServiceImpl.queryHouseByPrice();
        return HouseByPriceList;
    }


    @RequestMapping("/queryHouseByFloorage")
    @ResponseBody
    public List<House> queryHouseByFloorage() {
        List<House> houseList = houseServiceImpl.queryHouseByFloorage();
        return houseList;
    }

    @RequestMapping("/queryHouse")
    @ResponseBody
    public Map<Object, Object> queryHouse(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String admin = request.getParameter("admin");
        String rownum = request.getParameter("rownum");
        String price = request.getParameter("price");
        String floorage = request.getParameter("floorage");
        String houseType = request.getParameter("houseType");
        String district = request.getParameter("District");
        String street = request.getParameter("Street");
        String title = request.getParameter("title");
        int rownNumber = 0;
        int priceNumber = 0;
        int floorageNumber = 0;
        int houseTypeNumber = 0;
        int streetNumber = 0;
        int districtNumber = 0;
        int userNumber = 0;
        //获取分页
        if (rownum != null && !"".equals(rownum)) {
            rownNumber = Integer.parseInt(rownum);
        }
        if (houseType != null && !"".equals(houseType)) {
            houseTypeNumber = Integer.parseInt(houseType);
        }
        if (price != null && !"".equals(price)) {
            priceNumber = Integer.parseInt(price);
        }
        if (floorage != null && !"".equals(floorage)) {
            floorageNumber = Integer.parseInt(floorage);
        }
        if (district != null && !"".equals(district)) {
            districtNumber = Integer.parseInt(district);
        }
        if (street!=null&&!"".equals(street)){
            streetNumber= Integer.parseInt(street);
        }
        Object userid;
        if (admin!=null&&!"".equals(admin)){
            userid =  session.getAttribute("userid");
            userNumber = (int) userid;
        }
        List<HouseVoAllTable> houseList = houseServiceImpl.queryHouseConAllTable(rownNumber, priceNumber, userNumber, title, streetNumber, districtNumber, houseTypeNumber, floorageNumber);
        int count = houseServiceImpl.countHouseNumber(priceNumber, userNumber, title, streetNumber, districtNumber, houseTypeNumber, floorageNumber);
        Map<Object, Object> retumap = new HashMap<>();
        retumap.put("count", count);
        retumap.put("houselist", houseList);
        return retumap;
    }

}
