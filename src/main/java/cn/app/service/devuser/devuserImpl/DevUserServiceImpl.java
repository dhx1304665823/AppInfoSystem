package cn.app.service.devuser.devuserImpl;

import cn.app.mapper.devuser.DevUserMapper;
import cn.app.pojo.DevUser;
import cn.app.service.devuser.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("devUserService")
@Transactional
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    @Transactional(readOnly = true)
    public DevUser getCode(String devCode) {
        return devUserMapper.findCodes(devCode);
    }

    @Override
    public DevUser getPaw(String devCode, String devPassword) {
        return devUserMapper.findPaw(devCode,devPassword);
    }
}
