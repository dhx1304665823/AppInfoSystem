package cn.app.mapper.devuser;

import cn.app.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {

    DevUser findCodes(String devCode);
    DevUser findPaw(@Param("devCode") String devCode,@Param("devPassword") String devPassword);

}
