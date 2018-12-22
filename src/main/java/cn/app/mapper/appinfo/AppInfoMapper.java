package cn.app.mapper.appinfo;

import cn.app.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    List<Appinfo> findPageAll(@Param("softwareName") String softwareName,@Param("status") Integer status,
                              @Param("flatformId") Integer flatformId,@Param("categoryLevel1") Integer categoryLevel1,
                              @Param("categoryLevel2") Integer categoryLevel2,@Param("categoryLevel3") Integer categoryLevel3,
                              @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    int findCount(@Param("softwareName") String softwareName,@Param("status") Integer status,
    @Param("flatformId") Integer flatformId,@Param("categoryLevel1") Integer categoryLevel1,
    @Param("categoryLevel2") Integer categoryLevel2,@Param("categoryLevel3") Integer categoryLevel3);

    int add(AppInfo appInfo);

    AppInfo findByAPKName(String APKName);
    AppInfo findById(int id);
}
