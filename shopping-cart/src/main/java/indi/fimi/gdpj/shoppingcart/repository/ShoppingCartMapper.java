package indi.fimi.gdpj.shoppingcart.repository;

import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    List<ShoppingCartDetail> getAllShoppingCartDetailList();
}
