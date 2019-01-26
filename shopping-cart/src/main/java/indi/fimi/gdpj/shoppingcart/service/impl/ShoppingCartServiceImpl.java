package indi.fimi.gdpj.shoppingcart.service.impl;

import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.repository.ShoppingCartMapper;
import indi.fimi.gdpj.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoppingCartDetail> getAllShoppingCartDetailList() {
        return shoppingCartMapper.getAllShoppingCartDetailList();
    }
}
