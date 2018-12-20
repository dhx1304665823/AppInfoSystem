package cn.app.service.Dictionary.impl;

import cn.app.mapper.Dictionary.DictionaryMapper;
import cn.app.pojo.Dictionary;
import cn.app.service.Dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("dictionatyService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    @Transactional(readOnly = true)
    public List<cn.app.pojo.Dictionary> getAll() {
        return dictionaryMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dictionary> getfla() {
        return dictionaryMapper.findfla();
    }
}
