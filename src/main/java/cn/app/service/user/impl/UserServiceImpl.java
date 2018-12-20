package cn.app.service.user.impl;

import cn.app.mapper.user.UserMapper;
import cn.app.pojo.User;
import cn.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional(readOnly = true)
    public User login(String userCode, String userPassword) {
        return userMapper.login(userCode,userPassword);
    }
}
