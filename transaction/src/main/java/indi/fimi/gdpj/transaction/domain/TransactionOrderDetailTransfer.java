package indi.fimi.gdpj.transaction.domain;

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
