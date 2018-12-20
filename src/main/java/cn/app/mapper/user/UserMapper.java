package cn.app.mapper.user;

import cn.app.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
}
