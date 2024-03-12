package com.bookStore.repository;

import com.bookStore.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookListRepository extends JpaRepository<MyBookList,Integer> {
}
