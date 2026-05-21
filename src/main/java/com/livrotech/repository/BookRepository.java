package com.livrotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.livrotech.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}