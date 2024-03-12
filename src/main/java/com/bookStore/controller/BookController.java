package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController{
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;


    @GetMapping("/")
    public String home()
    {
     return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks()
    {
        List<Book> list=bookService.getAllBooks();
//        ModelAndView m=new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book",list);
         return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {
        bookService.save(b);
        return "redirect:/available_books";
    }

//    @GetMapping("/my_books")
//    public String getMyBooks(){
//        return "myBooks";
//    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=bookService.getBookById(id);
        MyBookList m=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBook(m);
        return "redirect:/my_books";
    }

    @GetMapping("my_books")
    public String getAllMyBooks(Model model){
        List<MyBookList> list=myBookListService.getAllMyBooks();
        model.addAttribute("mybooks",list);
        return "myBooks";
    }

    @RequestMapping("/mybooklist/{id}")
    public String deletebyId(@PathVariable("id") int id){
        myBookListService.deletebyId(id);
        return "redirect:/my_books";
    }

}
