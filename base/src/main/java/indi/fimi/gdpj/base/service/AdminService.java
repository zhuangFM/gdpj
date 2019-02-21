package indi.fimi.gdpj.base.service;

import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {

    void addSystemLog(SystemLog systemLog);

    List<SystemLog> getAllSystemLogList();

    void deleteSystemLogById(Integer id);

    List<User> getAllUserList();

    void addUser(User user);

    User getUserByUname(String uname);

    User getUserByUid(Integer id);

    User getUserByPhone(String phone);

    boolean checkUserExistByPhone(String phone);

    void modifyUserByUid(User user);

    void deleteUserById(Integer id);

    List<AuthRule> getAllAuthRuleList();

    void addAuthRule(AuthRule authRule);

    void modifyAuthRuleById(AuthRule authRule);

    void deleteAuthRuleById(Integer id);

    List<UserAuth> getUserAuthListByUid(Integer uid);

    void addUserAuth(UserAuth userAuth);

    void deleteUserAuthById(Integer id);
}
