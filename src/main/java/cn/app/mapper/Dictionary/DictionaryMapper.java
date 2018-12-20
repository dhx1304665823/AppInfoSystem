package cn.app.mapper.Dictionary;

import cn.app.pojo.Dictionary;

import java.util.List;

public interface DictionaryMapper {
    List<Dictionary> findAll();
    List<Dictionary> findfla();
}
