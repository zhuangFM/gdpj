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
    /**
     * system_log table
     */
    void addSystemLog(SystemLog systemLog);

    List<SystemLog> getAllSystemLogList();

    void deleteSystemLogById(@Param("id") Integer id);

    /**
     * gdpj_user table
     */
    List<User> getAllUserList();

    void addUser(User user);

    User getUserByUname(@Param("uname") String uname);

    User getUserByPhone(@Param("phone") String phone);

    User getUserByUid(@Param("id") Integer id);

    void modifyUserByUid(User user);

    void deleteUserById(@Param("id") Integer id);

    /**
     * auth_rule table
     */
    @ResultMap("admin-auth-rule-query")
    @Select("SELECT * FROM auth_rule")
    List<AuthRule> getAllAuthRuleList();

    void addAuthRule(AuthRule authRule);

    void modifyAuthRuleById(AuthRule authRule);

    void deleteAuthRuleById(@Param("id") Integer id);

    /**
     * user_auth table
     */
    @ResultMap("admin-user-auth-query")
    @Select("SELECT * FROM user_auth WHERE uid=#{uid} ")
    List<UserAuth> getUserAuthListByUid(@Param("uid") Integer uid);

    void addUserAuth(UserAuth userAuth);

    void deleteUserAuthById(@Param("id") Integer id);


}
