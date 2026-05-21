package com.livrotech.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livrotech.entity.Book;
import com.livrotech.service.BookService;

@RestController
@RequestMapping("/Books")
public class BookController { 

    private final BookService livroService;

    public BookController(BookService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Book> listar() {
        return livroService.listar();
    }

    @PostMapping
    public Book salvar(@RequestBody Book livro) {
    	
        return livroService.salvar(livro);
    }
}