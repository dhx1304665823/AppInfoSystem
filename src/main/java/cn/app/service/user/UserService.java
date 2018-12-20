package cn.app.service.user;

import cn.app.pojo.User;

public interface UserService {
    User login( String userCode,  String userPassword);
}
