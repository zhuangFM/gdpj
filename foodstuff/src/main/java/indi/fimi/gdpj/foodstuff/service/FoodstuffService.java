package indi.fimi.gdpj.foodstuff.service;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;

import java.util.List;
import java.util.Map;

public interface FoodstuffService {

    List<Foodstuff> getAllFoodstuffList();

    List<Foodstuff> getFoodstuffListByName(String name);

    List<Foodstuff> getFoodstuffListByOrigin(String origin);

    Foodstuff getFoodstuffById(Integer id);

    String getFoodstuffImagePathById(Integer id);

    void addFoodstuff(Foodstuff foodstuff);

    void modifyFoodstuffById(Foodstuff foodstuff);

    void deleteFoodstuffById(Integer id);

    List<FoodstuffKind> getAllFoodstuffKindList();

    FoodstuffKind getFoodstuffKindById(Integer id);

    void addFoodstuffKind(FoodstuffKind foodstuffKind);

    void modifyFoodstuffKindById(FoodstuffKind foodstuffKind);

    void deleteFoodstuffKindById(Integer id);

    Map<String, Object> feignBaseModuleAddSystemLog(String content, String level, String action);

}
