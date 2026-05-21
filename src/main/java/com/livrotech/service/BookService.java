package com.livrotech.service;

import java.util.List;
import java.util.Optional;

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
    
    public Optional<Book> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }
    
    public Optional<Book> atualizar(Long id, Book livroAtualizado) {

        Optional<Book> livroExistente = livroRepository.findById(id);

        if (livroExistente.isPresent()) {

        	Book livro = livroExistente.get();

            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setPreco(livroAtualizado.getPreco());

            livroRepository.save(livro);

            return Optional.of(livro);
        }

        return Optional.empty();
    }
    
    public boolean deletar(Long id) {

        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }

        return false;
    }
}