package com.book.bookstoreback.repository;

import com.book.bookstoreback.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Authors findByAuthorName(String authorName);
}
