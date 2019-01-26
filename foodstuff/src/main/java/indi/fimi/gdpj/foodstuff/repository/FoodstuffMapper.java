package indi.fimi.gdpj.foodstuff.repository;

import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodstuffMapper {

    List<Foodstuff> getAllFoodstuffList();

    List<FoodstuffKind> getAllFoodstuffKindList();

}
