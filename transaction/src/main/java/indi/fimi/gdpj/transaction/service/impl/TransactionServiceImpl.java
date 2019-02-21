package indi.fimi.gdpj.transaction.service.impl;

import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import indi.fimi.gdpj.transaction.repository.TransactionMapper;
import indi.fimi.gdpj.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public void addTransactionOrder(TransactionOrder transactionOrder) {
        transactionMapper.addTransactionOrder(transactionOrder);
    }

    @Override
    public void modifyTransactionOrder(TransactionOrder transactionOrder) {
        transactionMapper.modifyTransactionOrder(transactionOrder);
    }

    @Override
    public TransactionOrder getTransactionOrderById(Integer id) {
        return transactionMapper.getTransactionOrderById(id);
    }

    @Override
    public List<TransactionOrder> getTransactionOrdersByBuyerId(Integer buyerId) {
        return transactionMapper.getTransactionOrdersByBuyerId(buyerId);
    }

    @Override
    public List<TransactionOrder> getAllTransactionOrderList() {
        return transactionMapper.getAllTransactionOrderList();
    }

    @Override
    public void deleteTransactionOrderById(Integer id) {
        transactionMapper.deleteTransactionOrderById(id);
    }

    @Override
    public void addTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail) {
        transactionMapper.addTransactionOrderDetail(transactionOrderDetail);
    }

    @Override
    public void modifyTransactionOrderDetail(TransactionOrderDetail transactionOrderDetail) {
        transactionMapper.modifyTransactionOrderDetail(transactionOrderDetail);
    }

    @Override
    public TransactionOrderDetail getTransactionOrderDetailById(Integer id) {
        return transactionMapper.getTransactionOrderDetailById(id);
    }

    @Override
    public List<TransactionOrderDetail> getAllTransactionOrderDetailList() {
        return transactionMapper.getAllTransactionOrderDetailList();
    }

    @Override
    public List<TransactionOrderDetail> getTransactionOrderDetailsByTOId(Integer toid) {
        return transactionMapper.getTransactionOrderDetailsByTOId(toid);
    }

    @Override
    public void deleteTransactionOrderDetailById(Integer id) {
        transactionMapper.deleteTransactionOrderDetailById(id);
    }

    @Override
    public void deleteTransactionOrderDetailsByTOId(Integer toid) {
        transactionMapper.deleteTransactionOrderDetailsByTOId(toid);
    }

    @Override
    public void addPaymentRecord(PaymentRecord paymentRecord) {
        transactionMapper.addPaymentRecord(paymentRecord);
    }

    @Override
    public void modifyPaymentRecord(PaymentRecord paymentRecord) {
        transactionMapper.modifyPaymentRecord(paymentRecord);
    }

    @Override
    public PaymentRecord getPaymentRecordById(Integer id) {
        return transactionMapper.getPaymentRecordById(id);
    }

    @Override
    public PaymentRecord getPaymentRecordByTOId(Integer toid) {
        return transactionMapper.getPaymentRecordByTOId(toid);
    }

    @Override
    public List<PaymentRecord> getAllPaymentList() {
        return transactionMapper.getAllPaymentList();
    }

    @Override
    public void deletePaymentRecordById(Integer id) {
        transactionMapper.deletePaymentRecordById(id);
    }
}
