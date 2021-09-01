package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.result.Result;
import com.evan.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;
//    @CrossOrigin
    @GetMapping("/api/books")
    public Result listBooks() {
        List<Book> books =  bookService.list();
        Result result = new Result(200);
        result.setMessage("成功！");
        result.setResult(books);
        return result;
    }
    @PostMapping("/api/add")
    public Book addOrUpdate(@RequestBody Book book)throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }
    @PostMapping
    public void delete(@RequestBody Book book)throws Exception{
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid")int cid)throws Exception{
        if(0 != cid){
            return bookService.listByCategory(cid);
        }else {
            return bookService.list();
        }
    }
}

