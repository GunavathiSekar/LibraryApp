package com.kg.boook.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.kg.boook.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Serializable> {

// @Query("Select * from Book")
// public List<Book> select();
}