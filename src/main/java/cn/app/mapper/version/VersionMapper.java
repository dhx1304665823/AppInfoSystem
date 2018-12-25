package cn.app.mapper.version;

import cn.app.pojo.Version;

import java.util.List;

public interface VersionMapper {
    List<Version> findByIdlist(int id);
    int add(Version version);
    Version findById(int id);
    int delAKP(int id);
    int updateVersion(Version version);
}
