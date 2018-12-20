package cn.app.service.devuser;

import cn.app.pojo.DevUser;

public interface DevUserService {
    DevUser getCode(String devCode);
    DevUser getPaw(String devCode,String devPassword);
}
