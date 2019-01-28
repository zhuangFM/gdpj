package indi.fimi.gdpj.shoppingcart.web;

import com.google.common.collect.Maps;
import indi.fimi.gdpj.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/get_user")
    @ResponseBody
    public Map<String, Object> getUserInfo(@RequestParam("uid") Integer uid) {
        Map<String, Object> json = Maps.newHashMap();
        json.put("user", shoppingCartService.getUserInfoByUid(uid));
        json.put("code", 1);
        return json;
    }
}
