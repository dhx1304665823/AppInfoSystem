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
}
