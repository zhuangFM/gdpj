package indi.fimi.gdpj.base.web;


import com.google.common.collect.Maps;
import indi.fimi.gdpj.base.consts.ConfigConst;
import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping(value = "/register")
    public Map<String,Object> register(User user) {
        Map<String, Object> json = Maps.newHashMap();
        User checkUser = adminService.getUserByUname(user.getUname());
        if(null != checkUser){
            json.put("code",0);
            json.put("msg","this username already exist");
        }
        else{
            adminService.addUser(user);
            json.put("code",1);
            json.put("msg","register successfully!!");
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> checkLogin(User user, HttpServletRequest request) {
        Map<String, Object> json = Maps.newHashMap();
        User checkUser = adminService.getUserByUname(user.getUname());
        if (null != checkUser && checkUser.getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute(ConfigConst.SESSION_USER,user);
            json.put("code",1);
            json.put("user",user);
            json.put("msg","login successfully!");
        }
        else if(null == checkUser){
            json.put("code",0);
            json.put("msg","can not find this user!");
        }
        else{
            json.put("code",0);
            json.put("msg","password is incorrect!");
        }
        return json;
    }

    @RequestMapping(value = "/test")
    public void test() {
        System.out.println("--------------base-module--------------");
        for (User item : adminService.getAllUserList()) {
            System.out.println(item);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get_user")
    public Map<String,Object> getUserByUid(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        User user = adminService.getUserByUid(id);
        json.put("user",user);
        json.put("msg","successfully!");
        return json;
    }


}
