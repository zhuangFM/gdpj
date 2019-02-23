package indi.fimi.gdpj.shoppingcart.domain;

public class Address {
    private Integer id;
    private String consignee;
    private String province;
    private String city;
    private String postcode;
    private String createTime;
    private String creator;
    private String modifyTime;
    private String modifier;
    private String phone;
    private Integer uid;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", consignee='" + consignee + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creator='" + creator + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifier='" + modifier + '\'' +
                ", phone='" + phone + '\'' +
                ", uid=" + uid +
                ", address='" + address + '\'' +
                '}';
    }
}
