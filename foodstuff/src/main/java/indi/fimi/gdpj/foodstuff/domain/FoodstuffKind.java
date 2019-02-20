package indi.fimi.gdpj.foodstuff.domain;

import indi.fimi.gdpj.common.utils.TimeGetter;

import java.util.Date;

public class FoodstuffKind {
    private Integer id;
    private String name;
    private String desc;
    private String createTime;
    private String creator;
    private String modifyTime;
    private String modifier;

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

    @Override
    public String toString() {
        return "FoodstuffKind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
