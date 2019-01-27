package indi.fimi.gdpj.base.service.impl;

import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.repository.AdminMapper;
import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<User> getAllUserList() {
        return adminMapper.getAllUserList();
    }

    @Override
    public User getUserByUname(String uname) {
        return adminMapper.getUserByUname(uname);
    }

    @Override
    public void addUser(User user) {
        adminMapper.addUser(user);
    }

    @Override
    public void modifyUserByUid(User user) {
        adminMapper.modifyUserByUid(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        adminMapper.deleteUserById(id);
    }

    @Override
    public List<AuthRule> getAllAuthRuleList() {
        return adminMapper.getAllAuthRuleList();
    }

    @Override
    public void addAuthRule(AuthRule authRule) {
        adminMapper.addAuthRule(authRule);
    }

    @Override
    public void modifyAuthRuleById(AuthRule authRule) {
        adminMapper.modifyAuthRuleById(authRule);
    }

    @Override
    public void deleteAuthRuleById(Integer id) {
        adminMapper.deleteAuthRuleById(id);
    }

    @Override
    public List<UserAuth> getUserAuthListByUid(Integer uid) {
        return adminMapper.getUserAuthListByUid(uid);
    }

    @Override
    public void addUserAuth(UserAuth userAuth) {
        adminMapper.addUserAuth(userAuth);
    }

    @Override
    public void deleteUserAuthById(Integer id) {
        adminMapper.deleteUserAuthById(id);
    }

    @Override
    public List<SystemLog> getAllSystemLogList() {
        return adminMapper.getAllSystemLogList();
    }
}
