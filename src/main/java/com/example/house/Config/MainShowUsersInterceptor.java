package com.example.house.Config;

import com.example.house.Entity.House;
import com.example.house.Service.HouseService;
import com.example.house.Service.ServiceImpl.HouseServiceImpl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainShowUsersInterceptor implements HandlerInterceptor {
    /**取出用户名判断是否有值进行登录拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userName = request.getSession().getAttribute("userid");
        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            //根据房屋id查询得到用户id
            HouseService houseService = new HouseServiceImpl();
            House house = houseService.queryHouseId(Integer.parseInt(id));
            if (house != null) {
                if (house.getUserId()!=Integer.valueOf(id)) {
                    request.getRequestDispatcher("/main.html").forward(request, response);
                    return false;
                } else {
                    return true;
                }
            }
        }
        request.getRequestDispatcher("/main.html").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
