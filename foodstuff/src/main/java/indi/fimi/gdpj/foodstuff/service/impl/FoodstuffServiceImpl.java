package indi.fimi.gdpj.foodstuff.service.impl;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import indi.fimi.gdpj.foodstuff.repository.FoodstuffMapper;
import indi.fimi.gdpj.foodstuff.service.FoodstuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("foodstuffServer")
public class FoodstuffServiceImpl implements FoodstuffService {

    @Autowired
    private FoodstuffMapper foodstuffMapper;


    @Override
    public List<Foodstuff> getAllFoodstuffList() {
        return foodstuffMapper.getAllFoodstuffList();
    }

    @Override
    public List<FoodstuffKind> getAllFoodstuffKindList() {
        return foodstuffMapper.getAllFoodstuffKindList();
    }
}
