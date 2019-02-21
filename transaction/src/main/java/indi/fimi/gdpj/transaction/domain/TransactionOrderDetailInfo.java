package indi.fimi.gdpj.transaction.domain;

public class TransactionOrderDetailInfo extends TransactionOrderDetail {
    private String foodstuffName;

    public String getFoodstuffName() {
        return foodstuffName;
    }

    public void setFoodstuffName(String foodstuffName) {
        this.foodstuffName = foodstuffName;
    }

    @Override
    public String toString() {
        return "TransactionOrderDetailInfo{" +
                "foodstuffName='" + foodstuffName + '\'' +
                '}';
    }
}
