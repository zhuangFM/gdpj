package indi.fimi.gdpj.transaction.domain;

import java.util.ArrayList;
import java.util.List;

public class TransactionOrderInfo extends TransactionOrder {
    private String address;
    private String consignee;
    private List<TransactionOrderDetailInfo> detailList;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public List<TransactionOrderDetailInfo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TransactionOrderDetailInfo> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "TransactionOrderInfo{" +
                "address='" + address + '\'' +
                ", consignee='" + consignee + '\'' +
                ", detailList=" + detailList +
                '}';
    }
}
