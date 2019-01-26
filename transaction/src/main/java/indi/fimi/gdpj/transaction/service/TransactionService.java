package indi.fimi.gdpj.transaction.service;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;

import java.util.List;

public interface TransactionService {
    List<TransactionOrder> getAllTransactionOrderList();

    List<TransactionOrderDetail> getAllTransactionOrderDetailList();

    List<PaymentRecord> getAllPaymentList();
}
