package indi.fimi.gdpj.foodstuff.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import indi.fimi.gdpj.foodstuff.service.FoodstuffService;
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
public class FoodstuffController {

    @Autowired
    private FoodstuffService foodstuffService;

    private static Logger log = LoggerFactory.getLogger(FoodstuffController.class);

    @RequestMapping(value = "/test")
    public void test() {
        System.out.println("--------------foodstuff-module--------------");
        for (Foodstuff item : foodstuffService.getAllFoodstuffList()) {
            System.out.println(item);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/save_foodstuff")
    public Map<String, Object> saveFoodStuff(@RequestBody List<Foodstuff> foodstuffList) {
        log.info("Access the api /save_foodstuff");
        log.info("foodstufflist {} ",foodstuffList);
        for (Foodstuff item : foodstuffList) {
            if (null == item.getId()) {
                foodstuffService.addFoodstuff(item);
            } else {
                foodstuffService.modifyFoodstuffById(item);
            }
        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "successfully! handle record counts : "+foodstuffList.size());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_foodstuff")
    public Map<String, Object> getAllFoodstuffList(@RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
                                                   @RequestParam(name = "currentPage",defaultValue = "1")Integer currentPage) {
        log.info("Access the api /get_all_foodstuff");
        log.info("pageSize {} currentPage {}",pageSize,currentPage);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage,pageSize);
        List<Foodstuff> foodstuffList = foodstuffService.getAllFoodstuffList();
        PageInfo<Foodstuff> foodstuffPage = new PageInfo<Foodstuff>(foodstuffList);
        json.put("foodstuffList", foodstuffPage);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_by_id")
    public Map<String, Object> getFoodstuffById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        Foodstuff foodstuff = foodstuffService.getFoodstuffById(id);
        json.put("foodstuff", foodstuff);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete_foodstuff_by_id")
    public Map<String, Object> deleteFoodstuffById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        foodstuffService.deleteFoodstuffById(id);
        json.put("msg", "successfully! delete foodstuff where id = " + id);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/save_foodstuff_kind")
    public Map<String, Object> saveFoodStuffKind(@RequestBody List<FoodstuffKind> foodstuffKindList) {
        log.info("Access the api /save_foodstuff");
        log.info("foodstuffKindlist {} ",foodstuffKindList);
        for (FoodstuffKind item : foodstuffKindList) {
            if (null == item.getId()) {
                foodstuffService.addFoodstuffKind(item);
            } else {
                foodstuffService.modifyFoodstuffKindById(item);
            }
        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "successfully!handle record counts : "+foodstuffKindList.size());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_foodstuff_kind")
    public Map<String, Object> getAllFoodstuffKindList() {
        log.info("Access the api /get_all_foodstuff_kind");
        Map<String, Object> json = Maps.newHashMap();
        List<FoodstuffKind> foodstuffKindList = foodstuffService.getAllFoodstuffKindList();
        json.put("foodstuffKindList", foodstuffKindList);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_kind_by_id")
    public Map<String, Object> getFoodstuffKindById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        FoodstuffKind foodstuffKind = foodstuffService.getFoodstuffKindById(id);
        json.put("foodstuffKind", foodstuffKind);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete_foodstuff_kind_by_id")
    public Map<String, Object> deleteFoodstuffKindById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        foodstuffService.deleteFoodstuffKindById(id);
        json.put("msg", "successfully! delete foodstuffKind where id = "+ id);
        return json;
    }
}
