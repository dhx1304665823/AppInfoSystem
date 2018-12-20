package cn.app.service.CategoryService;

import cn.app.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getById(Integer id);
}
