package indi.fimi.gdpj.shoppingcart.domain;

public class ShoppingCartDetailInfo extends ShoppingCartDetail{
    private String uname;
    private String foodstuffName;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFoodstuffName() {
        return foodstuffName;
    }

    public void setFoodstuffName(String foodstuffName) {
        this.foodstuffName = foodstuffName;
    }

    @Override
    public String toString() {
        return "ShoppingCartDetailInfo{" +
                "uname='" + uname + '\'' +
                ", foodstuffName='" + foodstuffName + '\'' +
                '}';
    }
}
