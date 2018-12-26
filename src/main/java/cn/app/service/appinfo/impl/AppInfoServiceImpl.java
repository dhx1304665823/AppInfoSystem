package cn.app.service.appinfo.impl;

import cn.app.mapper.appinfo.AppInfoMapper;
import cn.app.pojo.AppInfo;
import cn.app.service.appinfo.AppInfoService;
import cn.app.service.version.VersionService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private VersionService versionService;

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

    @Override
    public int del(int id) {
        int result=versionService.delApp(id);
        int result2=0;
        if (result>0){
            result2=appInfoMapper.del(id);
        }else{
            result=-1;
        }
        return result2;
    }

    @Override
    public int appUpdStatus(AppInfo appInfo) {
        AppInfo appInfo1=appInfoMapper.getAppInfo(appInfo.getId(),null);
        if (appInfo1==null){
            return 0;
        }else{
            switch (appInfo1.getStatus()){
                case 2:
                    AppInfo appInfo2 = new AppInfo();
                    appInfo2.setId(appInfo1.getId());
                    appInfo2.setStatus(4);
                    appInfo2.setModifyBy(appInfo.getModifyBy());
                    appInfo2.setModifyDate(new Date());
                 appInfoMapper.appUpdStatus(appInfo2);
                 versionService.updStatus(appInfo1.getVersionId(),2);
                    break;
                case 5:
                    AppInfo appInfo3 = new AppInfo();
                    appInfo3.setId(appInfo1.getId());
                    appInfo3.setStatus(4);
                    appInfo3.setModifyBy(appInfo.getModifyBy());
                    appInfo3.setModifyDate(new Date());
                    appInfoMapper.appUpdStatus(appInfo3);
                    break;
                case 4:
                    AppInfo appInfo4 = new AppInfo();
                    appInfo4.setId(appInfo1.getId());
                    appInfo4.setStatus(5);
                    appInfo4.setModifyBy(appInfo.getModifyBy());
                    appInfo4.setModifyDate(new Date());
                    appInfoMapper.appUpdStatus(appInfo4);
                    break;
                default:
                    return 0;
            }
        }
        return 1;
    }
}
