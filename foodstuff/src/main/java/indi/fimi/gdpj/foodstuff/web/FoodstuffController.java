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
                foodstuffService.feignBaseModuleAddSystemLog("add a foodstuff","info","add");
            } else {
                foodstuffService.modifyFoodstuffById(item);
                foodstuffService.feignBaseModuleAddSystemLog(String.format("update a foodstuff where id is %d",item.getId()),"info","update");
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
    @RequestMapping(value = "/get_foodstuff_by_id")
    public Map<String, Object> getFoodstuffById(@RequestParam("id") Integer id) {
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
        foodstuffService.feignBaseModuleAddSystemLog(String.format("delete foodstuff where id = %d",id),"info","delete");
        json.put("msg", "successfully! delete foodstuff where id = " + id);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/upload_foodstuff_images")
    public Map<String, Object> uploadFoodstuffImages(HttpServletRequest request) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Foodstuff foodstuff = foodstuffService.getFoodstuffById(id);
        log.info("access api /upload_foodstuff_images where id is {}", id);
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
            String folderPath = this.basePath + id;
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = folderPath + "/" + file.getOriginalFilename();
                    log.info("the real upload path is {}",path);
                    //上传
                    file.transferTo(new File(path));
                    //update foodstuff
                    if (null == foodstuff.getImagePath() || "".equals(foodstuff.getImagePath())) {
                        foodstuff.setImagePath(file.getOriginalFilename());
                    } else {
                        foodstuff.setImagePath(foodstuff.getImagePath() + "," + file.getOriginalFilename());
                    }
                    foodstuffService.modifyFoodstuffById(foodstuff);
                    foodstuffService.feignBaseModuleAddSystemLog(String.format("upload foodstuff image where path = %s",path),"info","upload");
                    log.info("uploaded a image where path is {}", path);
                }
            }
        }
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
                foodstuffService.feignBaseModuleAddSystemLog("add a foodstuffKind","info","add");
            } else {
                foodstuffService.modifyFoodstuffKindById(item);
                foodstuffService.feignBaseModuleAddSystemLog(String.format("update a foodstuffKind where id is %d",item.getId()),"info","update");
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
        foodstuffService.feignBaseModuleAddSystemLog(String.format("delete a foodstuffKind where id is %d",id),"info","delete");
        json.put("msg", "successfully! delete foodstuffKind where id = " + id);
        return json;
    }
}
