package indi.fimi.gdpj.base.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.service.AdminService;
import indi.fimi.gdpj.base.util.MD5Helper;
import indi.fimi.gdpj.common.consts.ConfigConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @ResponseBody
    @RequestMapping(value = "/checkPhoneExist")
    public Map<String, Object> checkPhoneExist(@RequestParam("phone") String phone) {
        log.info("access api /checkPhoneExist where phone is {}", phone);
        Map<String, Object> json = Maps.newHashMap();
        boolean isExist = adminService.checkUserExistByPhone(phone);
        Random random = new Random();
        json.put("isExist", isExist);
        json.put("checkNum", "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public Map<String, Object> register(@RequestBody User user) {
        log.info("access api /register user is {}",user);
        SystemLog systemLog = new SystemLog();
        systemLog.setAction("register");
        systemLog.setLevel("info");
        systemLog.setContent(String.format("register user where phone is ",user.getPhone()));
        adminService.addSystemLog(systemLog);
        Map<String, Object> json = Maps.newHashMap();
        adminService.addUser(user);
        json.put("code", 1);
        json.put("msg", "register successfully!!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> checkLogin(@RequestBody User user, HttpServletRequest request) {
        log.info("access api /login where user is {}",user);
        Map<String, Object> json = Maps.newHashMap();
        User checkUser = adminService.getUserByPhone(user.getPhone());
        if (null != checkUser && MD5Helper.checkMD5Str(checkUser.getPassword(),user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute(ConfigConst.SESSION_USER, user);
            json.put("code", 1);
            json.put("user", checkUser);
            json.put("msg", "login successfully!");
        } else if (null == checkUser) {
            json.put("code", 0);
            json.put("msg", "can not find this user!");
        } else {
            json.put("code", 0);
            json.put("msg", "password is incorrect!");
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
    public Map<String, Object> getUserByUid(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        User user = adminService.getUserByUid(id);
        json.put("user", user);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_system_log")
    public Map<String, Object> getAllSystemLog(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                               @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {
        log.info("Access the api /get_all_system_log");
        log.info("pageSize {} currentPage {}", pageSize, currentPage);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<SystemLog> systemLogList = adminService.getAllSystemLogList();
        PageInfo<SystemLog> systemLogPage = new PageInfo<SystemLog>(systemLogList);
        json.put("systemLogList", systemLogPage);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete_system_log_by_id")
    public Map<String, Object> deleteSystemLogById(@RequestParam("id") Integer id) {
        log.info("Access the api /delete_system_log_by_id where id is {}", id);
        Map<String, Object> json = Maps.newHashMap();
        adminService.deleteSystemLogById(id);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/add_system_log")
    public Map<String, Object> addSystemLog(@RequestBody Map<String, String> systemLog) {
        log.info("Access the api /add_system_log where log is {}", systemLog);
        Map<String, Object> json = Maps.newHashMap();
        SystemLog log = new SystemLog();
        log.setContent(systemLog.get("content"));
        log.setLevel(systemLog.get("level"));
        log.setAction(systemLog.get("action"));
        adminService.addSystemLog(log);
        json.put("msg", "successfully!");
        return json;
    }


}
