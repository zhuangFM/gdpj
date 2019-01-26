import indi.fimi.gdpj.shoppingcart.BackendApplication;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.repository.ShoppingCartMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class TestShoppingCartMapper {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    public void test(){
        List<ShoppingCartDetail> shoppingCartDetailList = shoppingCartMapper.getAllShoppingCartDetailList();
        for(ShoppingCartDetail item : shoppingCartDetailList){
            System.out.println(item);
        }
    }

}
