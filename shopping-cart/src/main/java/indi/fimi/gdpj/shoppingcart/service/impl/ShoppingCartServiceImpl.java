package indi.fimi.gdpj.shoppingcart.service.impl;

import com.google.common.collect.Maps;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetailInfo;
import indi.fimi.gdpj.shoppingcart.repository.ShoppingCartMapper;
import indi.fimi.gdpj.shoppingcart.rpc.BaseModuleApi;
import indi.fimi.gdpj.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private BaseModuleApi baseModuleApi;

    @Override
    public void addShoppingCartDetail(ShoppingCartDetail shoppingCartDetail) {
        shoppingCartMapper.addShoppingCartDetail(shoppingCartDetail);
    }

    @Override
    public void modifyShoppingCartDetailById(ShoppingCartDetail shoppingCartDetail) {
        shoppingCartMapper.modifyShoppingCartDetailById(shoppingCartDetail);
    }

    @Override
    public ShoppingCartDetail getShoppingCartDetailById(Integer id) {
        return shoppingCartMapper.getShoppingCartDetailById(id);
    }

    @Override
    public ShoppingCartDetailInfo getShoppingCartDetailInfoById(Integer id) {
        return shoppingCartMapper.getShoppingCartDetailInfoById(id);
    }

    @Override
    public List<ShoppingCartDetail> getAllShoppingCartDetailListByUid(Integer uid) {
        return shoppingCartMapper.getAllShoppingCartDetailListByUid(uid);
    }

    @Override
    public List<ShoppingCartDetailInfo> getAllShoppingCartDetailInfoListByUid(Integer uid) {
        return shoppingCartMapper.getAllShoppingCartDetailInfoListByUid(uid);
    }

    @Override
    public void deleteShoppingCartDetailById(Integer id) {
        shoppingCartMapper.deleteShoppingCartDetailById(id);
    }

    @Override
    public void deleteAllShoppingCartDetailsByUid(Integer uid) {
        shoppingCartMapper.deleteAllShoppingCartDetailsByUid(uid);
    }

    @Override
    public Map<String, Object> getUserInfoByUid(Integer id) {
        return baseModuleApi.getUserInfoByUid(id);
    }

    @Override
    public Map<String, Object> feignBaseModuleAddSystemLog(String content, String level, String action) {
        Map<String,String> logMap = Maps.newHashMap();
        logMap.put("content",content);
        logMap.put("action",action);
        logMap.put("level",level);
        return baseModuleApi.feignBaseModuleAddSystemLog(logMap);
    }
}
