import indi.fimi.gdpj.transaction.BackendApplication;
import indi.fimi.gdpj.transaction.domain.PaymentRecord;
import indi.fimi.gdpj.transaction.domain.TransactionOrder;
import indi.fimi.gdpj.transaction.domain.TransactionOrderDetail;
import indi.fimi.gdpj.transaction.repository.TransactionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class TestTransactionMapper {

    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void test(){
        List<TransactionOrder> transactionOrderList = transactionMapper.getAllTransactionOrderList();
        List<TransactionOrderDetail> transactionOrderDetailList = transactionMapper.getAllTransactionOrderDetailList();
        List<PaymentRecord> paymentRecordList = transactionMapper.getAllPaymentList();
        for(TransactionOrder item : transactionOrderList){
            System.out.println(item);
        }
        for(TransactionOrderDetail item : transactionOrderDetailList){
            System.out.println(item);
        }
        for(PaymentRecord item : paymentRecordList){
            System.out.println(item);
        }
    }

}
