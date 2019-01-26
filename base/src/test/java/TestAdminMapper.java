import indi.fimi.gdpj.base.BackendApplication;
import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.repository.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class TestAdminMapper {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testGetAllUser(){
        List<User> userList = adminMapper.getAllUserList();
        List<AuthRule> authRuleList = adminMapper.getAllAuthRuleList();
        List<UserAuth> userAuthList= adminMapper.getUserAuthListByUid(1);
        List<SystemLog> systemLogList = adminMapper.getAllSystemLogList();
        for(User item : userList){
            System.out.println(item);
        }
        for(AuthRule item : authRuleList){
            System.out.println(item);
        }
        for(SystemLog item : systemLogList){
            System.out.println(item);
        }
        for(UserAuth item : userAuthList){
            System.out.println(item);
        }
    }

}
