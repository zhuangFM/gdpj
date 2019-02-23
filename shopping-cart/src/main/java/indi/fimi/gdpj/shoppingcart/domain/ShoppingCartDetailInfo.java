package indi.fimi.gdpj.shoppingcart.domain;

public class ShoppingCartDetailInfo extends ShoppingCartDetail{
    private String uname;
    private String foodstuffName;
    private String imagePath;
    private Integer singlePrice;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Integer singlePrice) {
        this.singlePrice = singlePrice;
    }

    @Override
    public String toString() {
        return "ShoppingCartDetailInfo{" +
                "uname='" + uname + '\'' +
                ", foodstuffName='" + foodstuffName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", singlePrice=" + singlePrice +
                '}';
    }
}
