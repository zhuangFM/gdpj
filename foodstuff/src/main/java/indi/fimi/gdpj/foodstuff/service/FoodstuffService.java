package indi.fimi.gdpj.foodstuff.service;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;

import java.util.List;

public interface FoodstuffService {
    
    List<Foodstuff> getAllFoodstuffList();

    List<FoodstuffKind> getAllFoodstuffKindList();
}
