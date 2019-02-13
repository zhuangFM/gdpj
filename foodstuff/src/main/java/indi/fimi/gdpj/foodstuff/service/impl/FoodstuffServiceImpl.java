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
    public Foodstuff getFoodstuffById(Integer id) {
        return foodstuffMapper.getFoodstuffById(id);
    }

    @Override
    public void addFoodstuff(Foodstuff foodstuff) {
        foodstuffMapper.addFoodstuff(foodstuff);
    }

    @Override
    public void modifyFoodstuffById(Foodstuff foodstuff) {
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
        foodstuffMapper.addFoodstuffKind(foodstuffKind);
    }

    @Override
    public void modifyFoodstuffKindById(FoodstuffKind foodstuffKind) {
        foodstuffMapper.modifyFoodstuffKindById(foodstuffKind);
    }

    @Override
    public void deleteFoodstuffKindById(Integer id) {
        foodstuffMapper.deleteFoodstuffKindById(id);
    }
}
