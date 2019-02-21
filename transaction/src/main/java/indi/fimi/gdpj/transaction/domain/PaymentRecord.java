package indi.fimi.gdpj.transaction.domain;

import java.util.Date;

public class PaymentRecord {
    private Integer id;
    private Integer transactionOrderId;
    private String createTime;
    private String creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransactionOrderId() {
        return transactionOrderId;
    }

    public void setTransactionOrderId(Integer transactionOrderId) {
        this.transactionOrderId = transactionOrderId;
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
        return "PaymentRecord{" +
                "id=" + id +
                ", transactionOrderId=" + transactionOrderId +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                '}';
    }
}
