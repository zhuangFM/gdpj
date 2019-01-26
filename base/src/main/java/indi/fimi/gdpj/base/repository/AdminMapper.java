package indi.fimi.gdpj.base.repository;

import indi.fimi.gdpj.base.domain.AuthRule;
import indi.fimi.gdpj.base.domain.SystemLog;
import indi.fimi.gdpj.base.domain.UserAuth;
import indi.fimi.gdpj.base.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<User> getAllUserList();

    @ResultMap("admin-auth-rule-query")
    @Select("SELECT * FROM auth_rule")
    List<AuthRule> getAllAuthRuleList();

    @ResultMap("admin-user-auth-query")
    @Select("SELECT * FROM user_auth WHERE uid=#{uid} ")
    List<UserAuth> getUserAuthListByUid(@Param("uid") Integer uid);

    List<SystemLog> getAllSystemLogList();

    void addUser(User user);





}
