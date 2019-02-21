package indi.fimi.gdpj.base.domain;

import java.util.Date;

public class UserAuth {
    private Integer id;
    private Integer uid;
    private Integer authId;
    private String createTime;
    private String creator;

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

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
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

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", uid=" + uid +
                ", authId=" + authId +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                '}';
    }
}
