package com.book.bookstoreback.repository;

import com.book.bookstoreback.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {

   Books findByTitle(String title);

   Optional<Books> findByISBN (Long ISBN);
   Optional<Books> findById(Long id);
}
