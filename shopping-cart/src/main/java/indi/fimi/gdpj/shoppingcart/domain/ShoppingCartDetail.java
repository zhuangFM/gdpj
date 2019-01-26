package indi.fimi.gdpj.shoppingcart.domain;

public class ShoppingCartDetail {
    private Integer id;
    private Integer uid;
    private Integer foodstuffId;
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFoodstuffId() {
        return foodstuffId;
    }

    public void setFoodstuffId(Integer foodstuffId) {
        this.foodstuffId = foodstuffId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingCartDetail{" +
                "id=" + id +
                ", uid=" + uid +
                ", foodstuffId=" + foodstuffId +
                ", amount=" + amount +
                '}';
    }
}
