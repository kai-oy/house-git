package com.example.house.Controller;

import com.example.house.Entity.House;
import com.example.house.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReleaseController {

    @Autowired
    private HouseService houseServiceImpl;

    @RequestMapping("/queryHouseById")
    @ResponseBody
    public House House(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            return null;
        } else {
            try {
                House house = houseServiceImpl.queryHouseId(Integer.parseInt(id));
                if (house != null) {
                    return house;
                }
                return null;
            } catch (ClassCastException e) {
                return null;
            }
        }
    }

    @RequestMapping("/daleteHouse")
    @ResponseBody
    public String daleteHouse(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {
        String id = request.getParameter("id");
        if (id!=null&&!"".equals(id)){
            int i = houseServiceImpl.daleteHouse(id);
            if (i==1){
                return "删除成功";
            }else {
                return "删除失败";
            }
        }
        return "删除失败";
    }

    @RequestMapping("/addHouse")
    @ResponseBody
    public Map<String, Object> addHouse(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String houseType = request.getParameter("houseType");
        String floorage = request.getParameter("floorage");
        String price = request.getParameter("price");
        String pubdate = request.getParameter("pubdate");
        String district = request.getParameter("District");
        String street = request.getParameter("Street");
        String contact = request.getParameter("contact");
        String description = request.getParameter("description");
        Map<String, Object> retuMap = new HashMap<>();
        boolean b = true;
        if (description == null || "".equals(description)) {
            retuMap.put("msg", "请输入详细信息");
            b = false;
        }
        if (contact == null || "".equals(contact)) {
            retuMap.put("msg", "请输入联系方式");
            b = false;
        }
        if (street == null || "".equals(street)) {
            retuMap.put("msg", "请选择街道位置");
            b = false;
        }
        if (district == null || "".equals(district)) {
            retuMap.put("msg", "请选择区域位置");
            b = false;
        }
        if (pubdate == null || "".equals(pubdate)) {
            retuMap.put("msg", "请输入房产证日期");
            b = false;
        }
        if (price == null || "".equals(price)) {
            retuMap.put("msg", "请输入价格");
            b = false;
        }
        if (floorage == null || "".equals(floorage)) {
            retuMap.put("msg", "请输入面积");
            b = false;
        }
        if (houseType == null || "".equals(houseType)) {

            retuMap.put("msg", "请输入户型");
            b = false;
        }
        if (title == null || "".equals(title)) {
            retuMap.put("msg", "请输入标题");
            b = false;
        }
        if (b) {
            House hs = new House();
            hs.setContact(contact);
            hs.setDescription(description);
            hs.setFloorage(Integer.parseInt(floorage));
            hs.setPrice(price);
            hs.setTypeId(Integer.parseInt(houseType));
            hs.setStreetId(Integer.parseInt(street));
            hs.setTitle(title);
            hs.setUserId((Integer) session.getAttribute("userid"));
            hs.setPubDate(new SimpleDateFormat("yyyy-MM-dd").parse(pubdate));
            int i;
            if (id == null || "".equals(id)) {
                i = houseServiceImpl.addHouse(hs);
                retuMap.put("msg", "已发布新房屋信息");
            } else {
                hs.setId(Integer.parseInt(id));
                i = houseServiceImpl.updateHouse(hs);
                retuMap.put("msg", "修改房屋信息成功");
            }
            if (i != 1) {
                retuMap.put("msg", "发布新房屋信息失败");
            }
        }
        retuMap.put("isnotIs", b);
        return retuMap;
    }
}
