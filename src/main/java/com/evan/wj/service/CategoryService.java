package com.evan.wj.service;

import com.evan.wj.dao.CategoryDao;
import com.evan.wj.pojo.Category;
import io.lettuce.core.GeoArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll();
    }
    public Category get(int id){
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
