package indi.fimi.gdpj.shoppingcart.web;

import com.google.common.collect.Maps;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetailInfo;
import indi.fimi.gdpj.shoppingcart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    private static Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

    @RequestMapping(value = "/get_user")
    @ResponseBody
    public Map<String, Object> getUserInfo(@RequestParam("uid") Integer uid) {
        Map<String, Object> json = Maps.newHashMap();
        json.put("user", shoppingCartService.getUserInfoByUid(uid));
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/save_shopping_cart_detail")
    @ResponseBody
    public Map<String, Object> saveShoppingCartDetail(@RequestBody ShoppingCartDetail shoppingCartDetail) {
        log.info("access api /save_shopping_cart_detail where shoppingCartDetail is {}", shoppingCartDetail);
        Map<String, Object> json = Maps.newHashMap();
        if (null == shoppingCartDetail.getId()) {
            shoppingCartService.addShoppingCartDetail(shoppingCartDetail);
            shoppingCartService.feignBaseModuleAddSystemLog(String.format("add a shoppingCartDetail where uid id is %d", shoppingCartDetail.getId()), "info", "add");
            json.put("msg", "add one record");
        } else {
            shoppingCartService.modifyShoppingCartDetailById(shoppingCartDetail);
            shoppingCartService.feignBaseModuleAddSystemLog(String.format("update a shoppingCartDetail where uid id is %d", shoppingCartDetail.getId()), "info", "update");
            json.put("msg", "modify one record");
        }
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/get_shopping_cart_detail_list_by_uid")
    @ResponseBody
    public Map<String, Object> getShoppingCartDetailListByUid(@RequestParam("uid") Integer uid) {
        List<ShoppingCartDetail> shoppingCartDetailList = shoppingCartService.getAllShoppingCartDetailListByUid(uid);
        Map<String, Object> json = Maps.newHashMap();
        json.put("list", shoppingCartDetailList);
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/get_shopping_cart_detail_info_by_id")
    @ResponseBody
    public Map<String, Object> getShoppingCartDetailInfoById(@RequestParam("id") Integer id) {
        ShoppingCartDetailInfo shoppingCartDetailInfo = shoppingCartService.getShoppingCartDetailInfoById(id);
        Map<String, Object> json = Maps.newHashMap();
        json.put("shoppingCartDetailInfo", shoppingCartDetailInfo);
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/get_shopping_cart_detail_info_list_by_uid")
    @ResponseBody
    public Map<String, Object> getShoppingCartDetailInfoListByUid(@RequestParam("uid") Integer uid) {
        List<ShoppingCartDetailInfo> shoppingCartDetailInfoList = shoppingCartService.getAllShoppingCartDetailInfoListByUid(uid);
        Map<String, Object> json = Maps.newHashMap();
        json.put("list", shoppingCartDetailInfoList);
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/delete_shopping_cart_detail_by_id")
    @ResponseBody
    public Map<String, Object> deleteShoppingCartDetailById(@RequestParam("id") Integer id) {
        shoppingCartService.deleteShoppingCartDetailById(id);
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "delete one record where id = " + id);
        json.put("code", 1);
        return json;
    }

    @RequestMapping(value = "/delete_shopping_cart_detail_by_uid")
    @ResponseBody
    public Map<String, Object> deleteShoppingCartDetailsByUid(@RequestParam("uid") Integer uid) {
        shoppingCartService.deleteAllShoppingCartDetailsByUid(uid);
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "empty user's shoppingCart where uid = " + uid);
        json.put("code", 1);
        return json;
    }
}
