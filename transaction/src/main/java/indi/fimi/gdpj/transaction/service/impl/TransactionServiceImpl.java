package indi.fimi.gdpj.transaction.service.impl;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import indi.fimi.gdpj.transaction.repository.TransactionMapper;
import indi.fimi.gdpj.transaction.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    private TransactionMapper transactionMapper;

    @Override
    public List<TransactionOrder> getAllTransactionOrderList() {
        return transactionMapper.getAllTransactionOrderList();
    }

    @Override
    public List<TransactionOrderDetail> getAllTransactionOrderDetailList() {
        return transactionMapper.getAllTransactionOrderDetailList();
    }

    @Override
    public List<PaymentRecord> getAllPaymentList() {
        return transactionMapper.getAllPaymentList();
    }
}
