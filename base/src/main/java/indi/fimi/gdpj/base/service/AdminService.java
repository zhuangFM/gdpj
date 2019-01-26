package indi.fimi.gdpj.base.service;

import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {

    List<User> getAllUserList();

    List<AuthRule> getAllAuthRuleList();

    List<UserAuth> getUserAuthListByUid(Integer uid);

    List<SystemLog> getAllSystemLogList();



}
