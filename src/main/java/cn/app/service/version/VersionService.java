package cn.app.service.version;

import cn.app.pojo.Version;

import java.util.List;

public interface VersionService {
    List<Version> findByIdlist(int id);
    int add(Version version);
    Version getById(int id);
    int delAKP(int id);
    int updateVersion(Version version);
    int delApp(int appId);
    int updStatus( int id,  int sid);
}
