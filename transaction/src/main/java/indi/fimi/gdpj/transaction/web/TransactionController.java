package indi.fimi.gdpj.transaction.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import indi.fimi.gdpj.transaction.domain.*;
import indi.fimi.gdpj.transaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private static Logger log = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping("/save_transaction_order")
    @ResponseBody
    public Map<String, Object> saveTransactionOrder(@RequestBody TransactionOrder transactionOrder) {
        Map<String, Object> json = Maps.newHashMap();
        if (null == transactionOrder.getId()) {
            transactionService.addTransactionOrder(transactionOrder);
            json.put("msg", "add one record successfully!");
        } else {
            transactionService.modifyTransactionOrder(transactionOrder);
            json.put("msg", "modify one record successfully!");
        }
        json.put("result", transactionOrder);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/get_all_transaction_order")
    @ResponseBody
    public Map<String, Object> getAllTransactionOrderList(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {
        log.info("Access the api /get_all_transaction_order");
        log.info("pageSize {} currentPage {}", pageSize, currentPage);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<TransactionOrder> transactionOrderList = transactionService.getAllTransactionOrderList();
        PageInfo<TransactionOrder> transactionOrderPage = new PageInfo<TransactionOrder>(transactionOrderList);
        json.put("transactionOrderList", transactionOrderPage);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/get_transaction_orders_by_buyer_id")
    @ResponseBody
    public Map<String, Object> getTransactionOrdersByBuyerId(@RequestParam("buyerId") Integer buyerId) {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrder> transactionOrderList = transactionService.getTransactionOrdersByBuyerId(buyerId);
        json.put("transactionOrderList", transactionOrderList);
        json.put("buyerId", buyerId);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/delete_transaction_order_by_id")
    @ResponseBody
    public Map<String, Object> deleteTransactionOrdersByBuyerId(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        transactionService.deleteTransactionOrderById(id);
        json.put("msg", String.format("delete transactionOrder where id = %d", id));
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/save_transaction_order_detail")
    @ResponseBody
    public Map<String, Object> saveTransactionOrderDetail(@RequestBody List<TransactionOrderDetailTransfer> transactionOrderDetailTransferList) {
        Map<String, Object> json = Maps.newHashMap();
        List<Integer> shoppingCartDetailIdList = new ArrayList<Integer>();
        for (TransactionOrderDetailTransfer item : transactionOrderDetailTransferList) {
            if (null == item.getId()) {
                transactionService.addTransactionOrderDetail(item);
                shoppingCartDetailIdList.add(item.getShoppingCartDetailId());
                json.put("msg", "add one record successfully!");
            } else {
                transactionService.modifyTransactionOrderDetail(item);
                json.put("msg", "modify one record successfully!");
            }
        }
        json.put("code", 1);
        json.put("shoppingCartDetailIdList",shoppingCartDetailIdList );
        return json;
    }

    @RequestMapping("/get_all_transaction_order_detail")
    @ResponseBody
    public Map<String, Object> getAllTransactionOrderDetailList() {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrderDetail> transactionOrderDetailList = transactionService.getAllTransactionOrderDetailList();
        json.put("transactionOrderDetailList", transactionOrderDetailList);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/get_transaction_order_detail_by_toid")
    @ResponseBody
    public Map<String, Object> getTransactionOrderDetailByTOId(@RequestParam("toid") Integer toid) {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrderDetailInfo> transactionOrderDetailInfoList = transactionService.getTransactionOrderDetailsInfoByTOId(toid);
        json.put("transactionOrderDetailList", transactionOrderDetailInfoList);
        json.put("toid", toid);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/delete_transaction_order_detail_by_toid")
    @ResponseBody
    public Map<String, Object> deleteTransactionOrderDetailsByTOId(@RequestParam("toid") Integer toid) {
        Map<String, Object> json = Maps.newHashMap();
        transactionService.deleteTransactionOrderDetailsByTOId(toid);
        json.put("msg", String.format("delete transactionOrderDetail where toid = %d", toid));
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/save_payment_record")
    public Map<String, Object> savePaymentRecord(@RequestBody PaymentRecord paymentRecord) {
        Map<String, Object> json = Maps.newHashMap();
        if (null == paymentRecord.getId()) {
            transactionService.addPaymentRecord(paymentRecord);
            json.put("msg", "add one record successfully!");
        } else {
            transactionService.modifyPaymentRecord(paymentRecord);
            json.put("msg", "modify one record successfully!");
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_all_payment_record")
    public Map<String, Object> getAllPaymentRecordList(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage) {
        log.info("Access the api /get_all_payment_record");
        log.info("pageSize {} currentPage {}", pageSize, currentPage);
        Map<String, Object> json = Maps.newHashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<PaymentRecord> paymentRecordList = transactionService.getAllPaymentList();
        PageInfo<PaymentRecord> paymentRecordPage = new PageInfo<PaymentRecord>(paymentRecordList);
        json.put("paymentRecordList", paymentRecordPage);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_payment_record_by_toid")
    public Map<String, Object> getPaymentRecordByTOId(@RequestParam("toid") Integer toid) {
        Map<String, Object> json = Maps.newHashMap();
        PaymentRecord paymentRecord = transactionService.getPaymentRecordByTOId(toid);
        json.put("paymentRecord", paymentRecord);
        json.put("toid", toid);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_payment_record_by_id")
    public Map<String, Object> getPaymentRecordById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        PaymentRecord paymentRecord = transactionService.getPaymentRecordById(id);
        json.put("paymentRecord", paymentRecord);
        json.put("id", id);
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/delete_payment_record_by_id")
    public Map<String, Object> deletePaymentRecordById(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        transactionService.deletePaymentRecordById(id);
        json.put("msg", String.format("delete one record where id = %d", id));
        json.put("code", 1);
        return json;
    }


}
