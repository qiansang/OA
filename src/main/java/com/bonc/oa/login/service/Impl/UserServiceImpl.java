package com.bonc.oa.login.service.Impl;

import com.bonc.oa.login.bean.Permission;
import com.bonc.oa.login.bean.Role;
import com.bonc.oa.login.bean.User;
import com.bonc.oa.login.bean.UserExample;
import com.bonc.oa.login.dao.PermissionMapper;
import com.bonc.oa.login.dao.RoleMapper;
import com.bonc.oa.login.dao.UserMapper;
import com.bonc.oa.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger("oa");

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public Role findRoleByUserId(Integer id) {
        return roleMapper.selectByUserId(id);
    }

    @Override
    public List<Permission> findPermissionByRoleId(Integer id) {
        return null;
    }

    @Override
    public List<Role> getRole() {
        return roleMapper.selectAll();
    }

    @Override
    public int addUser(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int editPwd(Integer id) {
        return userMapper.updatePwdById(id, "e10adc3949ba59abbe56e057f20f883e");
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findUserLockById(Integer id) {
        return userMapper.selectUserLockByPrimaryKey(id);
    }

    @Override
    public int editUser(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int setUserLock(Integer id, Integer login) {
        User record = new User();
        record.setId(id);
        record.setLogin(login);
        return userMapper.updateUserLoginStatus(record);
    }

    @Override
    public int editPassword(User user) {
        return userMapper.updatePwdById(user.getId(), user.getPassword());
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUserIdAndUsername();
    }

    @Override
    public boolean IsOrNotExist(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.getUsername().trim().length() > 0){
            criteria.andUsernameEqualTo(user.getUsername());
        }
        example.or(criteria);
        try {
            List<User> users = userMapper.selectByExample(example);
            if(users.size() > 0){
                return true;
            }else{
                if(user.getName().trim().length() > 0 && userMapper.selelctByName(user.getName()) != null){
                    return true;
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }

}
