package cn.app.service.appinfo;

import cn.app.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import java.util.List;

public interface AppInfoService {
    List<Appinfo> findPageAll(String softwareName,Integer status,
                              Integer flatformId, Integer categoryLevel1,
                              Integer categoryLevel2,Integer categoryLevel3, Integer pageNo, Integer pageSize);
    int getCount(String softwareName,Integer status,
                 Integer flatformId, Integer categoryLevel1,
                 Integer categoryLevel2,Integer categoryLevel3);
    AppInfo getByAPKName(String APKName);
    int add(AppInfo appInfo);
    AppInfo getById(int id);
    int delLog(int id);
    AppInfo getAppInfo(int id, String APKName);
    int modify(AppInfo appInfo);
    List<Appinfo> adminlist(String softwareName,
                              Integer flatformId, Integer categoryLevel1,
                              Integer categoryLevel2,Integer categoryLevel3, Integer pageNo, Integer pageSize);
    int getadminCount(String softwareName,
                 Integer flatformId, Integer categoryLevel1,
                 Integer categoryLevel2,Integer categoryLevel3);
    int updVersion(Integer versionId,Integer id);
}
