package indi.fimi.gdpj.transaction.repository;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {
    List<TransactionOrder> getAllTransactionOrderList();

    List<TransactionOrderDetail> getAllTransactionOrderDetailList();

    List<PaymentRecord> getAllPaymentList();

}
