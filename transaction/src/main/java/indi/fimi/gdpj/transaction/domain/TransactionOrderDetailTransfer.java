package indi.fimi.gdpj.transaction.domain;

/**
 * 用于controller中接收shoppingCartDetailId参数
 */
public class TransactionOrderDetailTransfer extends TransactionOrderDetail{
    private Integer shoppingCartDetailId;

    public Integer getShoppingCartDetailId() {
        return shoppingCartDetailId;
    }

    public void setShoppingCartDetailId(Integer shoppingCartDetailId) {
        this.shoppingCartDetailId = shoppingCartDetailId;
    }

    @Override
    public String toString() {
        return "TransactionOrderDetailService{" +
                "shoppingCartDetailId=" + shoppingCartDetailId +
                '}';
    }
}
