package indi.fimi.gdpj.foodstuff.repository;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodstuffMapper {

    List<Foodstuff> getAllFoodstuffList();

    Foodstuff getFoodstuffById(@Param("id") Integer id);

    void addFoodstuff(Foodstuff foodstuff);

    void modifyFoodstuffById(Foodstuff foodstuff);

    void deleteFoodstuffById(@Param("id")Integer id);

    List<FoodstuffKind> getAllFoodstuffKindList();

    FoodstuffKind getFoodstuffKindById(@Param("id")Integer id);

    void addFoodstuffKind(FoodstuffKind foodstuffKind);

    void modifyFoodstuffKindById(FoodstuffKind foodstuffKind);

    void deleteFoodstuffKindById(@Param("id")Integer id);
}
