package indi.fimi.gdpj.base.domain;

import java.util.Date;

public class SystemLog {
    private Integer id;
    private String level;
    private String content;
    private Date createTime;
    private String creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                '}';
    }
}
