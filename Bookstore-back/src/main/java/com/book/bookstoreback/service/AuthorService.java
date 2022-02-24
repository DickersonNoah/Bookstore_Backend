package com.book.bookstoreback.service;

import com.book.bookstoreback.repository.AuthorRepository;
import com.book.bookstoreback.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {


    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    public Authors saveAuthors(Authors authors) {
        return authorRepository.save(authors);
    }

    public List<Authors> saveAuthors(List<Authors> authors){
        return authorRepository.saveAll(authors);
    }

    public List<Authors> getAuthors(){
        return authorRepository.findAll();
    }


    public Authors getAuthorById(Long id){
       return authorRepository.findById(id).orElse(null);
    }
//
//    public Authors getAuthorByName(String authorName){
//        return authorRepository.findByAuthorName(authorName);
//    }

    public Authors updateAuthor(Authors authors){
        Authors existingAuthor = authorRepository.findById(authors.getId()).orElse(null);
        existingAuthor.setAuthorName(authors.getAuthorName());
        return authorRepository.save(existingAuthor);
    }



}
