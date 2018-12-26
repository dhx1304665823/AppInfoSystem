package cn.app.service.version.impl;

import cn.app.mapper.version.VersionMapper;
import cn.app.pojo.Version;
import cn.app.service.version.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("versionService")
@Transactional
public class VersionServiceImpl implements VersionService {
    @Autowired
    private VersionMapper versionMapper;



    @Override
    @Transactional(readOnly = true)
    public List<Version> findByIdlist(int id) {
        return versionMapper.findByIdlist(id);
    }

    @Override
    public int add(Version version) {
        return versionMapper.add(version);
    }

    @Override
    @Transactional(readOnly = true)
    public Version getById(int id) {
        return versionMapper.findById(id);
    }

    @Override
    public int delAKP(int id) {
        return versionMapper.delAKP(id);
    }

    @Override
    public int updateVersion(Version version) {
        return versionMapper.updateVersion(version);
    }

    @Override
    public int delApp(int appId) {
        return versionMapper.delApp(appId);
    }

    @Override
    public int updStatus(int id, int sid) {
        return versionMapper.updStatus(id,sid);
    }
}
