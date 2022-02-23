package com.book.bookstoreback;

import com.book.bookstoreback.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Authors findByIdAndAuthorName(Long id, String authorName);
    Optional<Authors> findById(Long id);
}
