package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.book;

import java.util.List;

public interface IBookService {
    book saveBook(book book);

    void deleteBook(long id);

    List<book> findAllBooks();
}
