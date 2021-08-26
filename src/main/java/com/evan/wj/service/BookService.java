package com.evan.wj.service;

import com.evan.wj.dao.BookDao;
import com.evan.wj.dao.CategoryDao;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    public BookDao bookDao;



    @Autowired
    public CategoryService categoryService;

    public List<Book> list(){
        String key = "booklist";
        List<Book> list = bookDao.findAll();
        return list;
    }
    public void  addOrUpdate(Book book){
        bookDao.save(book);
    }
    public  void deleteById(int id){
        bookDao.deleteById(id);
    }
    public List<Book> listByCategory(int cid){

        Category category = categoryService.get(cid);
        List<Book> list = bookDao.findAllByCategory(category);
        return list;
    }
}
