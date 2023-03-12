package com.sha.springbootbootseller.repository;

import com.sha.springbootbootseller.model.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository <book, Long> {
}
