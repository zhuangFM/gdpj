package indi.fimi.gdpj.transaction.domain;

public class TransactionOrderDetailInfo extends TransactionOrderDetail {
    private String foodstuffName;
    private String imagePath;

    public String getFoodstuffName() {
        return foodstuffName;
    }

    public void setFoodstuffName(String foodstuffName) {
        this.foodstuffName = foodstuffName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "TransactionOrderDetailInfo{" +
                "foodstuffName='" + foodstuffName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
