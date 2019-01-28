package indi.fimi.gdpj.shoppingcart.service;

import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    List<ShoppingCartDetail> getAllShoppingCartDetailList();

    Map<String,Object> getUserInfoByUid(Integer id);
}
