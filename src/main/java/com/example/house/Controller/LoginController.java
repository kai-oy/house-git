package com.example.house.Controller;

import com.example.house.Entity.Users;
import com.example.house.Service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    UsersService usersService;

    /**
     * 登录检查 检查是否存在此账号，密码是否有误
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/loginUsers")
    @ResponseBody
    public Map<String, Object> loginUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:" + password);
        Map<String, Object> loginMap = new HashMap<>();
        if (name != null && !"".equals(name) && password != null && !"".equals(password)) {
            Users users = usersService.queryNameUsers(name, password);
            if (users != null) {//确认登录无误
                session.setAttribute("userid", users.getId());
                session.setAttribute("userName", name);
                loginMap.put("isLogin", true);
                loginMap.put("msg", "登录成功");
            } else {//登录密码错误
                loginMap.put("isLogin", false);
                loginMap.put("msg", "密码输入错误");
            }
        } else {//账号密码有一个为空
            loginMap.put("isLogin", false);
            loginMap.put("msg", "请输入密码");
        }
        return loginMap;
    }

    @RequestMapping("/addUsers")
    @ResponseBody
    public Map<String, Object> addUsers(HttpServletResponse response, HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("Name");
        String usersName = request.getParameter("userName");
        String pwd = request.getParameter("PassWord");
        String telephone = request.getParameter("telephone");
        Map<String, Object> returnMap = new HashMap<>();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        if (parameterMap.size() != 0) {
        if (name == null || "".equals(name)) {
            returnMap.put("msg", "昵称不能为空");
        } else if (usersName == null || "".equals(usersName)) {
            returnMap.put("msg", "账号不能为空");
        } else if (pwd == null || "".equals(pwd)) {
            returnMap.put("msg", "密码不能为空");
        } else if (telephone == null || "".equals(telephone)) {
            returnMap.put("msg", "手机号不能为空");
        } else {
            Users user = new Users();
            user.setName(name);
            user.setUserName(usersName);
            user.setPassword(pwd);
            user.setTelePhine(telephone);
            user.setIsAdmin("0");
            int i = usersService.addUsers(user);
            if (i==1){
                returnMap.put("msg","已注册成功");
                returnMap.put("ifUser",true);
            }else{
                returnMap.put("msg","注册失败，请重新注册");
                returnMap.put("ifUser",false);
            }
        }
        return returnMap;
    }

    @RequestMapping("/checkUsersName")
    @ResponseBody
    public Map<String, Object> checkUsersName(HttpServletResponse response, HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("userName");
        Map<String, Object> checkMap = new HashMap<>();
        if (name == null) {
            checkMap.put("msg", "账号不能为空");
        } else if (name.length() < 6) {
            checkMap.put("msg", "账号需6位以上");
        } else {
            Boolean aBoolean = usersService.queryNameUser(name);
            if (!aBoolean) {
                //账号可用
                checkMap.put("ifUser", true);
                checkMap.put("msg", "账号可以注册");
            } else {
                //账号不可用
                checkMap.put("msg", "该账号已注册");
            }
        }
        return checkMap;
    }

    @RequestMapping("/checkTel")
    @ResponseBody
    public Map<String, Object> checkTel(HttpServletResponse response, HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String tel = request.getParameter("telephone");
        Map<String, Object> checkMap = new HashMap<>();
        if (tel == null) {
            checkMap.put("msg", "手机号不能为空");
        } else if (tel.length() < 11) {
            checkMap.put("msg", "手机号需6位以上");
        } else {
            Boolean aBoolean = usersService.queryTelUser(tel);
            if (!aBoolean) {
                //账号可用
                checkMap.put("ifUser", true);
                checkMap.put("msg", "该手机号可以注册");
            } else {
                //账号不可用
                checkMap.put("msg", "该手机号已注册");
            }
        }
        return checkMap;
    }

    @RequestMapping("/quit")
    @ResponseBody
    public void quit(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:index.html";
    }
}
