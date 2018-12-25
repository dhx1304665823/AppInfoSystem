package cn.app.service.appinfo.impl;

import cn.app.mapper.appinfo.AppInfoMapper;
import cn.app.pojo.AppInfo;
import cn.app.service.appinfo.AppInfoService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Appinfo> findPageAll(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer pageNo, Integer pageSize) {
        return appInfoMapper.findPageAll(softwareName,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3,pageNo,pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public int getCount(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.findCount(softwareName,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
    }

    @Override
    @Transactional(readOnly = true)
    public AppInfo getByAPKName(String APKName) {
        return appInfoMapper.findByAPKName(APKName);
    }

    @Override
    public int add(AppInfo appInfo) {
        return appInfoMapper.add(appInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public AppInfo getById(int id) {
        return appInfoMapper.findById(id);
    }

    @Override
    public int delLog(int id) {
        return appInfoMapper.delLog(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AppInfo getAppInfo(int id, String APKName) {
        return appInfoMapper.getAppInfo(id,APKName);
    }

    @Override
    public int modify(AppInfo appInfo) {
        return appInfoMapper.modify(appInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appinfo> adminlist(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer pageNo, Integer pageSize) {
        return appInfoMapper.adminList(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3,pageNo,pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public int getadminCount(String softwareName, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.adminCount(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
    }

    @Override
    public int updVersion(Integer versionId, Integer id) {
        return appInfoMapper.updVersion(versionId,id);
    }
}
