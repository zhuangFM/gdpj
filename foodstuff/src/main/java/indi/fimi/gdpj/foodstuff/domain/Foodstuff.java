package indi.fimi.gdpj.foodstuff.domain;

import java.util.Date;

public class Foodstuff {
    private Integer id;
    private String name;
    private String desc;
    private Integer typeid;
    private Date createTime;
    private String creator;
    private Date modifyTime;
    private String modifier;
    private String origin;
    private Integer price;
    private String unit;
    private Integer isDiscount;
    private Integer inventory;
    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Foodstuff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", typeid=" + typeid +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifier='" + modifier + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", isDiscount=" + isDiscount +
                ", inventory=" + inventory +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
