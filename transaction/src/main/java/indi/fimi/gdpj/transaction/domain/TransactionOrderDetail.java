package indi.fimi.gdpj.transaction.domain;

public class TransactionOrderDetail {
    private Integer id;
    private Integer transactionOrderId;
    private Integer foodstuffId;
    private Integer amount;

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

    public Integer getFoodstuffId() {
        return foodstuffId;
    }

    public void setFoodstuffId(Integer foodstuffId) {
        this.foodstuffId = foodstuffId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionOrderDetail{" +
                "id=" + id +
                ", transactionOrderId=" + transactionOrderId +
                ", foodstuffId=" + foodstuffId +
                ", amount=" + amount +
                '}';
    }
}
