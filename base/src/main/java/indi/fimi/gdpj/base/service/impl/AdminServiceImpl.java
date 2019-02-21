package indi.fimi.gdpj.base.service.impl;

import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.repository.AdminMapper;
import indi.fimi.gdpj.base.domain.User;
import indi.fimi.gdpj.base.service.AdminService;
import indi.fimi.gdpj.common.utils.TimeGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
    public User getUserByUid(Integer id) {
        return adminMapper.getUserByUid(id);
    }

    @Override
    public User getUserByPhone(String phone) {
        return adminMapper.getUserByPhone(phone);
    }

    @Override
    public boolean checkUserExistByPhone(String phone) {
        return adminMapper.getUserByPhone(phone) != null;
    }

    @Override
    public void addUser(User user) {
        user.setCreateTime(TimeGetter.getCurrentTimeStr());
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
        authRule.setCreateTime(TimeGetter.getCurrentTimeStr());
        authRule.setCreator("fimi.zhuang");
        authRule.setModifyTime(TimeGetter.getCurrentTimeStr());
        authRule.setModifier("fimi.zhuang");
        adminMapper.addAuthRule(authRule);
    }

    @Override
    public void modifyAuthRuleById(AuthRule authRule) {
        authRule.setModifier("fimi.zhuang");
        authRule.setModifyTime(TimeGetter.getCurrentTimeStr());
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
        userAuth.setCreateTime(TimeGetter.getCurrentTimeStr());
        userAuth.setCreator("fimi.zhuang");
        adminMapper.addUserAuth(userAuth);
    }

    @Override
    public void deleteUserAuthById(Integer id) {
        adminMapper.deleteUserAuthById(id);
    }

    @Override
    public void addSystemLog(SystemLog systemLog) {
        systemLog.setCreateTime(TimeGetter.getCurrentTimeStr());
        systemLog.setCreator("fimi.zhuang");
        adminMapper.addSystemLog(systemLog);
    }

    @Override
    public List<SystemLog> getAllSystemLogList() {
        return adminMapper.getAllSystemLogList();
    }

    @Override
    public void deleteSystemLogById(Integer id) {
        adminMapper.deleteSystemLogById(id);
    }
}
