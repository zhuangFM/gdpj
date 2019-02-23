package indi.fimi.gdpj.shoppingcart.repository;

import indi.fimi.gdpj.shoppingcart.domain.Address;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetail;
import indi.fimi.gdpj.shoppingcart.domain.ShoppingCartDetailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    void addShoppingCartDetail(ShoppingCartDetail shoppingCartDetail);

    void modifyShoppingCartDetailById(ShoppingCartDetail shoppingCartDetail);

    ShoppingCartDetail getShoppingCartDetailById(@Param("id") Integer id);

    ShoppingCartDetailInfo getShoppingCartDetailInfoById(@Param("id") Integer id);

    List<ShoppingCartDetail> getAllShoppingCartDetailListByUid(@Param("uid") Integer uid);

    List<ShoppingCartDetailInfo> getAllShoppingCartDetailInfoListByUid(@Param("uid") Integer uid);

    void deleteShoppingCartDetailById(@Param("id") Integer id);

    void deleteAllShoppingCartDetailsByUid(@Param("uid") Integer uid);

    void addAddress(Address address);

    void modifyAddressById(Address address);

    Address getAddressById(@Param("id") Integer id);

    List<Address> getAddressListByUid(@Param("uid") Integer uid);

    void deleteAddressById(@Param("id") Integer id);
}
