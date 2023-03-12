package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.book;
import com.sha.springbootbootseller.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public book saveBook(book book) {
        book.setCreateTime(LocalDateTime.now());
        return  bookRepository.save(book);


    }
    @Override

    public void deleteBook( long id) {
        bookRepository.deleteById(id);
    }
    @Override

    public List<book> findAllBooks(){
        return bookRepository.findAll();
    }
}
