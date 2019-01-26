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
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<User> getAllUserList() {
        return adminMapper.getAllUserList();
    }

    @Override
    public List<AuthRule> getAllAuthRuleList() {
        return adminMapper.getAllAuthRuleList();
    }

    @Override
    public List<UserAuth> getUserAuthListByUid(Integer uid) {
        return adminMapper.getUserAuthListByUid(uid);
    }

    @Override
    public List<SystemLog> getAllSystemLogList() {
        return adminMapper.getAllSystemLogList();
    }
}
