package com.bonc.oa.login.service;

import com.bonc.oa.login.bean.Permission;
import com.bonc.oa.login.bean.Role;
import com.bonc.oa.login.bean.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    Role findRoleByUserId(Integer id);

    List<Permission> findPermissionByRoleId(Integer id);

    List<Role> getRole();

    int addUser(User record);

    int editPwd(Integer id);

    int deleteUser(Integer id);

    User findUserLockById(Integer id);

    int editUser(User record);

    int setUserLock(Integer id, Integer login);

    int editPassword(User user);

    List<User> getAllUser();

    boolean IsOrNotExist(User user);
}
