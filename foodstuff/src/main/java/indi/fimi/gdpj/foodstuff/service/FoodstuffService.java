package indi.fimi.gdpj.foodstuff.service;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;

import java.util.List;

public interface FoodstuffService {
    
    List<Foodstuff> getAllFoodstuffList();

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

}
