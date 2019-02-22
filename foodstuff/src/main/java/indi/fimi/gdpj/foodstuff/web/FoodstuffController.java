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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class FoodstuffController {

    @Autowired
    private FoodstuffService foodstuffService;

    @Value("${image.upload.basePath}")
    private String basePath;

    @Value("${image.upload.basePathForMac}")
    private String basePathForMac;

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
        log.info("foodstufflist {} ", foodstuffList);
        for (Foodstuff item : foodstuffList) {
            if (null == item.getId()) {
                foodstuffService.addFoodstuff(item);
                foodstuffService.feignBaseModuleAddSystemLog("add a foodstuff", "info", "add");
            } else {
                foodstuffService.modifyFoodstuffById(item);
                foodstuffService.feignBaseModuleAddSystemLog(String.format("update a foodstuff where id is %d", item.getId()), "info", "update");
            }
        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "successfully! handle record counts : " + foodstuffList.size());
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_foodstuff")
    public Map<String, Object> getAllFoodstuffList(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {
        log.info("Access the api /get_all_foodstuff");
        log.info("pageSize {} currentPage {}", pageSize, currentPage);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<Foodstuff> foodstuffList = foodstuffService.getAllFoodstuffList();
        PageInfo<Foodstuff> foodstuffPage = new PageInfo<Foodstuff>(foodstuffList);
        json.put("foodstuffList", foodstuffPage);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_by_name")
    public Map<String, Object> getFoodstuffListByName(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                      @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                                                      @RequestParam(name = "foodstuffName", defaultValue = "") String foodstuffName,
                                                      @RequestParam(name = "orderBy",defaultValue = "inventory")String orderBy) {
        log.info("Access the api /get_foodstuff_by_name");
        log.info("pageSize {} currentPage {} foodstuffName {} orderBy {}", pageSize, currentPage, foodstuffName,orderBy);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        PageHelper.orderBy(orderBy+" ASC");
        List<Foodstuff> foodstuffList = foodstuffService.getFoodstuffListByName(foodstuffName);
        PageInfo<Foodstuff> foodstuffPage = new PageInfo<Foodstuff>(foodstuffList);
        json.put("msg", "successfully!");
        json.put("foodstuffList", foodstuffPage);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_by_origin")
    public Map<String, Object> getFoodstuffListByOrigin(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                      @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                                                      @RequestParam(name = "origin",defaultValue = "")String origin) {
        log.info("Access the api /get_foodstuff_by_origin");
        log.info("pageSize {} currentPage {} origin {}", pageSize, currentPage, origin);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<Foodstuff> foodstuffList = foodstuffService.getFoodstuffListByOrigin(origin);
        PageInfo<Foodstuff> foodstuffPage = new PageInfo<Foodstuff>(foodstuffList);
        json.put("msg", "successfully!");
        json.put("foodstuffList", foodstuffPage);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_by_id")
    public Map<String, Object> getFoodstuffById(@RequestParam("id") Integer id) {
        log.info("access api /get_foodstuff_by_id where id is {}",id);
        Map<String, Object> json = Maps.newHashMap();
        Foodstuff foodstuff = foodstuffService.getFoodstuffById(id);
        json.put("foodstuff", foodstuff);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/get_foodstuff_images_by_id")
    public Map<String, Object> getFoodstuffImagesById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        String imagePath = foodstuffService.getFoodstuffImagePathById(id);
        json.put("imagePath", imagePath);
        json.put("msg", "successfully!");
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete_foodstuff_by_id")
    public Map<String, Object> deleteFoodstuffById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        foodstuffService.deleteFoodstuffById(id);
        foodstuffService.feignBaseModuleAddSystemLog(String.format("delete foodstuff where id = %d", id), "info", "delete");
        json.put("msg", "successfully! delete foodstuff where id = " + id);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/upload_foodstuff_images")
    public Map<String, Object> uploadFoodstuffImages(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Foodstuff foodstuff = foodstuffService.getFoodstuffById(id);
        log.info("access api /upload_foodstuff_images where id is {}", id);

        String folderPath1 = this.basePath.split("&")[0] + id;
        String folderPath2 = this.basePath.split("&")[1] + id;
        File folder1 = new File(folderPath1);
        File folder2 = new File(folderPath2);
        if (!folder1.exists()) {
            folder1.mkdir();
        }
        if (!folder2.exists()) {
            folder2.mkdir();
        }

        String path1 = folderPath1 + "/" + file.getOriginalFilename();
        String path2 = folderPath2 + "/" + file.getOriginalFilename();

        FileOutputStream out = new FileOutputStream(path1);
        out.write(file.getBytes());
        out.flush();
        out.close();
        out = new FileOutputStream(path2);
        out.write(file.getBytes());
        out.flush();
        out.close();

        //update foodstuff
        if (null == foodstuff.getImagePath() || "".equals(foodstuff.getImagePath())) {
            foodstuff.setImagePath(file.getOriginalFilename());
        } else {
            foodstuff.setImagePath(foodstuff.getImagePath() + "," + file.getOriginalFilename());
        }
        foodstuffService.modifyFoodstuffById(foodstuff);
        foodstuffService.feignBaseModuleAddSystemLog(String.format("upload foodstuff image where path1 = %s", path1), "info", "upload");
        foodstuffService.feignBaseModuleAddSystemLog(String.format("upload foodstuff image where path2 = %s", path2), "info", "upload");
        log.info("uploaded a image where path1 is {} ||||path2 is {}", path1, path2);

        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "successfully! upload foodstuff where id = " + id);
        return json;
    }


    @ResponseBody
    @RequestMapping(value = "/save_foodstuff_kind")
    public Map<String, Object> saveFoodStuffKind(@RequestBody List<FoodstuffKind> foodstuffKindList) {
        log.info("Access the api /save_foodstuff");
        log.info("foodstuffKindlist {} ", foodstuffKindList);
        for (FoodstuffKind item : foodstuffKindList) {
            if (null == item.getId()) {
                foodstuffService.addFoodstuffKind(item);
                foodstuffService.feignBaseModuleAddSystemLog("add a foodstuffKind", "info", "add");
            } else {
                foodstuffService.modifyFoodstuffKindById(item);
                foodstuffService.feignBaseModuleAddSystemLog(String.format("update a foodstuffKind where id is %d", item.getId()), "info", "update");
            }
        }
        Map<String, Object> json = Maps.newHashMap();
        json.put("msg", "successfully!handle record counts : " + foodstuffKindList.size());
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
        log.info("Access the api /get_foodstuff_kind_by_id where id is {}", id);
        Map<String, Object> json = Maps.newHashMap();
        foodstuffService.deleteFoodstuffKindById(id);
        foodstuffService.feignBaseModuleAddSystemLog(String.format("delete a foodstuffKind where id is %d", id), "info", "delete");
        json.put("msg", "successfully! delete foodstuffKind where id = " + id);
        return json;
    }
}
