package com.evan.wj.dao;

import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByTitleLikeOrAuthorLike(String keyWord1,String keyWord2);
    List<Book> findAllByCategory(Category category);
}