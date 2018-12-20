package cn.app.mapper.category;

import cn.app.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> findById(Integer id);
}
