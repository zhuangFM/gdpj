package indi.fimi.gdpj.foodstuff.web;


import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.service.FoodstuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodstuffController {

    @Autowired
    private FoodstuffService foodstuffService;

    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("--------------foodstuff-module--------------");
        for(Foodstuff item :  foodstuffService.getAllFoodstuffList()){
            System.out.println(item);
        }
    }


}
