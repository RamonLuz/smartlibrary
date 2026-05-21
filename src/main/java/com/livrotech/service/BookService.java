package com.livrotech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.livrotech.entity.Book;
import com.livrotech.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository livroRepository;

    public BookService(BookRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Book> listar() {
        return livroRepository.findAll();
    }

    public Book salvar(Book livro) {
    	
        return livroRepository.save(livro);
    }
}