package indi.fimi.gdpj.transaction.repository;

import indi.fimi.gdpj.transaction.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionMapper {

    void addTransactionOrder(TransactionOrder transactionOrder);

    void modifyTransactionOrder(TransactionOrder transactionOrder);

    TransactionOrder getTransactionOrderById(@Param("id") Integer id);

    List<TransactionOrder> getTransactionOrderListByBuyerId(@Param("buyerId") Integer buyerId);

    List<TransactionOrder> getAllTransactionOrderList();

    List<TransactionOrderInfo> getTransactionOrderInfoListByBuyerId(@Param("buyerId") Integer buyerId);

    void deleteTransactionOrderById(@Param("id") Integer id);

    void addTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    void modifyTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail);

    TransactionOrderDetail getTransactionOrderDetailById(@Param("id") Integer id);

    TransactionOrderDetailInfo getTransactionOrderDetailInfoById(@Param("id") Integer id);

    List<TransactionOrderDetail> getAllTransactionOrderDetailList();

    List<TransactionOrderDetailInfo> getAllTransactionOrderDetailInfoList();

    List<TransactionOrderDetail> getTransactionOrderDetailsByTOId(@Param("toid") Integer toid);

    List<TransactionOrderDetailInfo> getTransactionOrderDetailsInfoByTOId(@Param("toid") Integer toid);

    void deleteTransactionOrderDetailById(@Param("id") Integer id);

    void deleteTransactionOrderDetailsByTOId(@Param("toid") Integer toid);

    void addPaymentRecord(PaymentRecord paymentRecord);

    void modifyPaymentRecord(PaymentRecord paymentRecord);

    PaymentRecord getPaymentRecordById(@Param("id") Integer id);

    PaymentRecord getPaymentRecordByTOId(@Param("toid") Integer toid);

    List<PaymentRecord> getAllPaymentList();

    void deletePaymentRecordById(@Param("id") Integer id);

}
