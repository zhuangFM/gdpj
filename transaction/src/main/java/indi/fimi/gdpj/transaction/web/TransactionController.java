package indi.fimi.gdpj.transaction.web;

import com.google.common.collect.Maps;
import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import indi.fimi.gdpj.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

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
        json.put("code",1);
        return json;
    }

    @RequestMapping("/get_all_transaction_order")
    @ResponseBody
    public Map<String, Object> getAllTransactionOrderList() {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrder> transactionOrderList = transactionService.getAllTransactionOrderList();
        json.put("transactionOrderList",transactionOrderList);
        json.put("code",1);
        return json;
    }

    @RequestMapping("/get_transaction_orders_by_buyer_id")
    @ResponseBody
    public Map<String, Object> getTransactionOrdersByBuyerId(@RequestParam("buyerId") Integer buyerId) {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrder> transactionOrderList = transactionService.getTransactionOrdersByBuyerId(buyerId);
        json.put("transactionOrderList",transactionOrderList);
        json.put("buyerId",buyerId);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/delete_transaction_order_by_id")
    @ResponseBody
    public Map<String, Object> deleteTransactionOrdersByBuyerId(@RequestParam("id") Integer id) {
        Map<String, Object> json = Maps.newHashMap();
        transactionService.deleteTransactionOrderById(id);
        json.put("msg",String.format("delete transactionOrder where id = %d",id));
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/save_transaction_order_detail")
    @ResponseBody
    public Map<String, Object> saveTransactionOrderDetail(@RequestBody TransactionOrderDetail transactionOrderDetail) {
        Map<String, Object> json = Maps.newHashMap();
        if (null == transactionOrderDetail.getId()) {
            transactionService.addTransactionOrderDetail(transactionOrderDetail);
            json.put("msg", "add one record successfully!");
        } else {
            transactionService.modifyTransactionOrderDetail(transactionOrderDetail);
            json.put("msg", "modify one record successfully!");
        }
        json.put("code",1);
        return json;
    }

    @RequestMapping("/get_all_transaction_order_detail")
    @ResponseBody
    public Map<String, Object> getAllTransactionOrderDetailList() {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrderDetail> transactionOrderDetailList = transactionService.getAllTransactionOrderDetailList();
        json.put("transactionOrderDetailList",transactionOrderDetailList);
        json.put("code",1);
        return json;
    }

    @RequestMapping("/get_transaction_order_detail_by_toid")
    @ResponseBody
    public Map<String, Object> getTransactionOrderDetailByTOId(@RequestParam("toid") Integer toid) {
        Map<String, Object> json = Maps.newHashMap();
        List<TransactionOrderDetail> transactionOrderDetailList = transactionService.getTransactionOrderDetailsByTOId(toid);
        json.put("transactionOrderDetailList",transactionOrderDetailList);
        json.put("toid",toid);
        json.put("code", 1);
        return json;
    }

    @RequestMapping("/delete_transaction_order_detail_by_toid")
    @ResponseBody
    public Map<String, Object> deleteTransactionOrderDetailsByTOId(@RequestParam("toid") Integer toid) {
        Map<String, Object> json = Maps.newHashMap();
        transactionService.deleteTransactionOrderDetailsByTOId(toid);
        json.put("msg",String.format("delete transactionOrderDetail where toid = %d",toid));
        json.put("code", 1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/save_payment_record")
    public Map<String,Object> savePaymentRecord(@RequestBody PaymentRecord paymentRecord){
        Map<String,Object> json = Maps.newHashMap();
        if(null == paymentRecord.getId()){
            transactionService.addPaymentRecord(paymentRecord);
            json.put("msg","add one record successfully!");
        }
        else{
            transactionService.modifyPaymentRecord(paymentRecord);
            json.put("msg","modify one record successfully!");
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_all_payment_record")
    public Map<String,Object> getAllPaymentRecordList(){
        Map<String,Object> json = Maps.newHashMap();
        List<PaymentRecord> paymentRecordList = transactionService.getAllPaymentList();
        json.put("paymentRecordList",paymentRecordList);
        json.put("code",1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_payment_record_by_toid")
    public Map<String,Object> getPaymentRecordByTOId(@RequestParam("toid") Integer toid){
        Map<String,Object> json = Maps.newHashMap();
        PaymentRecord paymentRecord= transactionService.getPaymentRecordByTOId(toid);
        json.put("paymentRecord",paymentRecord);
        json.put("toid",toid);
        json.put("code",1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/get_payment_record_by_id")
    public Map<String,Object> getPaymentRecordById(@RequestParam("id") Integer id){
        Map<String,Object> json = Maps.newHashMap();
        PaymentRecord paymentRecord= transactionService.getPaymentRecordById(id);
        json.put("paymentRecord",paymentRecord);
        json.put("id",id);
        json.put("code",1);
        return json;
    }

    @ResponseBody
    @RequestMapping("/delete_payment_record_by_id")
    public Map<String,Object> deletePaymentRecordById(@RequestParam("id") Integer id){
        Map<String,Object> json = Maps.newHashMap();
        transactionService.deletePaymentRecordById(id);
        json.put("msg",String.format("delete one record where id = %d",id));
        json.put("code",1);
        return json;
    }





}
