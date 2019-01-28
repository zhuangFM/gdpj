package indi.fimi.gdpj.shoppingcart.service.impl;

import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.repository.ShoppingCartMapper;
import indi.fimi.gdpj.shoppingcart.rpc.BaseModuleApi;
import indi.fimi.gdpj.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private BaseModuleApi baseModuleApi;

    @Override
    public List<ShoppingCartDetail> getAllShoppingCartDetailList() {
        return shoppingCartMapper.getAllShoppingCartDetailList();
    }

    @Override
    public Map<String, Object> getUserInfoByUid(Integer id) {
        return baseModuleApi.getUserInfoByUid(id);
    }
}
