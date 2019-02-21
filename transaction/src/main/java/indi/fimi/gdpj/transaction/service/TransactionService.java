package indi.fimi.gdpj.transaction.service;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetailInfo;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    void addTransactionOrder(TransactionOrder transactionOrder);

    void modifyTransactionOrder(TransactionOrder transactionOrder);

    TransactionOrder getTransactionOrderById(Integer id);

    List<TransactionOrder> getTransactionOrdersByBuyerId(Integer buyerId);

    List<TransactionOrder> getAllTransactionOrderList();

    void deleteTransactionOrderById(Integer id);

    void addTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    void modifyTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    TransactionOrderDetail getTransactionOrderDetailById(Integer id);

    TransactionOrderDetailInfo getTransactionOrderDetailInfoById(Integer id);

    List<TransactionOrderDetail> getAllTransactionOrderDetailList();

    List<TransactionOrderDetailInfo> getAllTransactionOrderDetailInfoList();

    List<TransactionOrderDetail> getTransactionOrderDetailsByTOId(Integer toid);

    List<TransactionOrderDetailInfo> getTransactionOrderDetailsInfoByTOId(Integer toid);

    void deleteTransactionOrderDetailById(Integer id);

    void deleteTransactionOrderDetailsByTOId(Integer toid);

    void addPaymentRecord(PaymentRecord paymentRecord);

    void modifyPaymentRecord(PaymentRecord paymentRecord);

    PaymentRecord getPaymentRecordById(Integer id);

    PaymentRecord getPaymentRecordByTOId(Integer toid);

    List<PaymentRecord> getAllPaymentList();

    void deletePaymentRecordById(Integer id);

    Map<String,Object> getFoodstuffInfoById(Integer id);
}
