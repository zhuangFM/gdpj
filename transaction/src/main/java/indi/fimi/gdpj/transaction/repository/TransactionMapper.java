package indi.fimi.gdpj.transaction.repository;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionMapper {

    void addTransactionOrder(TransactionOrder transactionOrder);

    void modifyTransactionOrder(TransactionOrder transactionOrder);

    TransactionOrder getTransactionOrderById(@Param("id") Integer id);

    List<TransactionOrder> getTransactionOrdersByBuyerId(@Param("buyerId") Integer buyerId);

    List<TransactionOrder> getAllTransactionOrderList();

    void deleteTransactionOrderById(@Param("id") Integer id);

    void addTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    void modifyTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    TransactionOrderDetail getTransactionOrderDetailById(@Param("id") Integer id);

    List<TransactionOrderDetail> getAllTransactionOrderDetailList();

    List<TransactionOrderDetail> getTransactionOrderDetailsByTOId(@Param("toid") Integer toid);

    void deleteTransactionOrderDetailById(@Param("id") Integer id);

    void deleteTransactionOrderDetailsByTOId(@Param("toid") Integer toid);

    void addPaymentRecord(PaymentRecord paymentRecord);

    void modifyPaymentRecord(PaymentRecord paymentRecord);

    PaymentRecord getPaymentRecordById(@Param("id") Integer id);

    PaymentRecord getPaymentRecordByTOId(@Param("toid") Integer toid);

    List<PaymentRecord> getAllPaymentList();

    void deletePaymentRecordById(@Param("id") Integer id);

}
