package indi.fimi.gdpj.shoppingcart.web;

import com.google.common.collect.Maps;
import com.sun.corba.se.spi.ior.ObjectKey;
import indi.fimi.gdpj.shoppingcart.domain.Address;
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
        json.put("result", shoppingCartService.getShoppingCartDetailInfoById(shoppingCartDetail.getId()));
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
    public Map<String, Object> deleteShoppingCartDetailById(@RequestBody List<Integer> idList) {
        for (Integer id : idList) {
            shoppingCartService.deleteShoppingCartDetailById(id);
        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", String.format("delete %d records",idList.size()));
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

    @ResponseBody
    @RequestMapping(value = "/save_address")
    public Map<String, Object> saveAddress(@RequestBody Address address) {
        log.info("access api /save_address where address is {}", address);
        if (null == address.getId()) {
            shoppingCartService.addAddress(address);
            log.info("add a address");
            shoppingCartService.feignBaseModuleAddSystemLog("add a address", "info", "add");
        } else {
            shoppingCartService.modifyAddressById(address);
            log.info("update a address");
            shoppingCartService.feignBaseModuleAddSystemLog("update a address", "info", "update");

        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("result", address);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_address_by_id")
    public Map<String, Object> getAddressById(@RequestParam("id") Integer id) {
        log.info("access api /get_address_by_id where id is {}", id);
        Address address = shoppingCartService.getAddressById(id);
        Map<String, Object> json = Maps.newHashMap();
        json.put("address", address);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_address_list_by_uid")
    public Map<String, Object> getAddressListByUid(@RequestParam("uid") Integer uid) {
        log.info("access api /get_address_list_by_uid where uid is {}", uid);
        List<Address> addressList = shoppingCartService.getAddressListByUid(uid);
        Map<String, Object> json = Maps.newHashMap();
        json.put("addressList", addressList);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete_address_by_id")
    public Map<String, Object> deleteAddressById(@RequestParam("id") Integer id) {
        log.info("access api /delete_address_by_id where id is {}", id);
        shoppingCartService.deleteAddressById(id);
        shoppingCartService.feignBaseModuleAddSystemLog(String.format("delete an address where id is %d", id), "info", "delete");
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", String.format("delete an address where id is %d", id));
        json.put("code", 1);
        return json;
    }
}
