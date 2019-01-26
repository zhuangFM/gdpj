import indi.fimi.gdpj.foodstuff.BackendApplication;
import indi.fimi.gdpj.foodstuff.domain.Foodstuff;
import indi.fimi.gdpj.foodstuff.domain.FoodstuffKind;
import indi.fimi.gdpj.foodstuff.repository.FoodstuffMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class TestFoodstuffMapper {

    @Autowired
    private FoodstuffMapper foodstuffMapper;

    @Test
    public void test(){
        List<Foodstuff> foodstuffList = foodstuffMapper.getAllFoodstuffList();
        List<FoodstuffKind> foodstuffKindList = foodstuffMapper.getAllFoodstuffKindList();
        for(Foodstuff item : foodstuffList){
            System.out.println(item);
        }
        for(FoodstuffKind item : foodstuffKindList){
            System.out.println(item);
        }
    }

}
