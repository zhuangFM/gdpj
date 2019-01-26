package indi.fimi.gdpj.base.web;


import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public void checkLogin(User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("--------------base-module--------------");
        for(User item :  adminService.getAllUserList()){
            System.out.println(item);
        }
    }


}
