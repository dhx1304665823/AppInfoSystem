package cn.app.service.CategoryService.impl;

import cn.app.mapper.category.CategoryMapper;
import cn.app.pojo.Category;
import cn.app.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> getById(Integer id) {
        return categoryMapper.findById(id);
    }
}
