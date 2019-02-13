package indi.fimi.gdpj.shoppingcart.service;

import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    void addShoppingCartDetail(ShoppingCartDetail shoppingCartDetail);

    void modifyShoppingCartDetailById(ShoppingCartDetail shoppingCartDetail);

    ShoppingCartDetail getShoppingCartDetailById(Integer id);

    List<ShoppingCartDetail> getAllShoppingCartDetailListByUid(Integer uid);

    void deleteShoppingCartDetailById(Integer id);

    void deleteAllShoppingCartDetailsByUid(Integer uid);

    Map<String,Object> getUserInfoByUid(Integer id);
}
