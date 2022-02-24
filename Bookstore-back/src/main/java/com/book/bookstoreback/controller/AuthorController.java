package com.book.bookstoreback.controller;

import com.book.bookstoreback.service.AuthorService;
import com.book.bookstoreback.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AuthorController {


    private AuthorService authorService;
    @Autowired
    public void setAuthorService(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public Authors addAuthor(@RequestBody Authors author){
        return authorService.saveAuthors(author);
    }

    @PostMapping("/addAuthors")
    public List<Authors> addAuthors(@RequestBody List<Authors> authors){
        return authorService.saveAuthors(authors);
    }

    @GetMapping("/authors")
    public List<Authors> getAuthors(){
        return authorService.getAuthors();
    }


    @GetMapping("/authors/{id}")
    public Authors getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

//    @GetMapping("/authors/{authorName}")
//    public Authors findAuthorByName(@PathVariable String authorName){
//        return authorService.getAuthorByName(authorName);
//    }

    @PutMapping("/updateAuthor")
    public Authors updateAuthor(@RequestBody Authors authors){
        return authorService.updateAuthor(authors);
    }



}
