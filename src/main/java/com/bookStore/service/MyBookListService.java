package com.bookStore.service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    MyBookListRepository myBookListRepository;
    public void saveMyBook(MyBookList b)
    {
        myBookListRepository.save(b);
    }

    public List<MyBookList> getAllMyBooks(){
        List<MyBookList> list=myBookListRepository.findAll();
        return list;
    }

    public void deletebyId(int id){
        myBookListRepository.deleteAllById(Collections.singleton(id));
    }
}
