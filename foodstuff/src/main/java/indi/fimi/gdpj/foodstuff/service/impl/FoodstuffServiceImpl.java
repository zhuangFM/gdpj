package indi.fimi.gdpj.foodstuff.service.impl;

import com.google.common.collect.Maps;
import indi.fimi.gdpj.common.utils.TimeGetter;
import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import indi.fimi.gdpj.foodstuff.repository.FoodstuffMapper;
import indi.fimi.gdpj.foodstuff.rpc.BaseModuleApi;
import indi.fimi.gdpj.foodstuff.service.FoodstuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("foodstuffServer")
public class FoodstuffServiceImpl implements FoodstuffService {

    @Autowired
    private FoodstuffMapper foodstuffMapper;

    @Autowired
    private BaseModuleApi baseModuleApi;


    @Override
    public List<Foodstuff> getAllFoodstuffList() {
        return foodstuffMapper.getAllFoodstuffList();
    }

    @Override
    public List<Foodstuff> getFoodstuffListByName(String name) {
        return foodstuffMapper.getFoodstuffListByName(name);
    }

    @Override
    public List<Foodstuff> getFoodstuffListByOrigin(String origin) {
        return foodstuffMapper.getFoodstuffListByOrigin(origin);
    }

    @Override
    public Foodstuff getFoodstuffById(Integer id) {
        return foodstuffMapper.getFoodstuffById(id);
    }

    @Override
    public String getFoodstuffImagePathById(Integer id) {
        return foodstuffMapper.getFoodstuffImagePathById(id);
    }

    @Override
    public void addFoodstuff(Foodstuff foodstuff) {
        foodstuff.setCreateTime(TimeGetter.getCurrentTimeStr());
        foodstuff.setCreator("fimi.zhuang");
        foodstuff.setModifyTime(TimeGetter.getCurrentTimeStr());
        foodstuff.setModifier("fimi.zhuang");
        foodstuffMapper.addFoodstuff(foodstuff);
    }

    @Override
    public void modifyFoodstuffById(Foodstuff foodstuff) {
        foodstuff.setModifyTime(TimeGetter.getCurrentTimeStr());
        foodstuffMapper.modifyFoodstuffById(foodstuff);
    }

    @Override
    public void deleteFoodstuffById(Integer id) {
        foodstuffMapper.deleteFoodstuffById(id);
    }

    @Override
    public List<FoodstuffKind> getAllFoodstuffKindList() {
        return foodstuffMapper.getAllFoodstuffKindList();
    }

    @Override
    public FoodstuffKind getFoodstuffKindById(Integer id) {
        return foodstuffMapper.getFoodstuffKindById(id);
    }

    @Override
    public void addFoodstuffKind(FoodstuffKind foodstuffKind) {
        foodstuffKind.setCreateTime(TimeGetter.getCurrentTimeStr());
        foodstuffKind.setCreator("fimi.zhuang");
        foodstuffKind.setModifyTime(TimeGetter.getCurrentTimeStr());
        foodstuffKind.setModifier("fimi.zhuang");
        foodstuffMapper.addFoodstuffKind(foodstuffKind);
    }

    @Override
    public void modifyFoodstuffKindById(FoodstuffKind foodstuffKind) {
        foodstuffKind.setModifyTime(TimeGetter.getCurrentTimeStr());
        foodstuffMapper.modifyFoodstuffKindById(foodstuffKind);
    }

    @Override
    public void deleteFoodstuffKindById(Integer id) {
        foodstuffMapper.deleteFoodstuffKindById(id);
    }

    @Override
    public Map<String, Object> feignBaseModuleAddSystemLog(String content, String level, String action) {
        Map<String,String> logMap = Maps.newHashMap();
        logMap.put("content",content);
        logMap.put("level",level);
        logMap.put("action",action);
        return baseModuleApi.feignBaseModuleAddSystemLog(logMap);
    }

}
