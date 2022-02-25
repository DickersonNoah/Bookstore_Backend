package com.book.bookstoreback.controller;

import com.book.bookstoreback.model.Books;
import com.book.bookstoreback.service.AuthorService;
import com.book.bookstoreback.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class AuthorController {


    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Authors> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping(path = "/authors/{id}")
    public Optional getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    @PostMapping("/authors")
    public Authors createAuthor(@RequestBody Authors authorObject){
        return authorService.createAuthor(authorObject);
    }

    @PutMapping("/authors/{id}")
    public Authors updateAuthor(@PathVariable(value = "id") Long id, @RequestBody Authors authorObject){
        return authorService.updateAuthor(id, authorObject);
    }

    @DeleteMapping("/authors/{id}")
    public Optional<Authors> deleteAuthor(@PathVariable(value = "id") Long id){
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return authorService.getAllBooks();
    }

    @PostMapping("/authors/{id}/books")
    public Books createBook( @PathVariable(value = "id") Long id, @RequestBody Books bookObject){
        return authorService.createBook(id, bookObject);
    }

    @GetMapping("/authors/{id}/books")
    public List<Books> getBooks(@PathVariable(value="id") Long id){
        return authorService.getBooks(id);
    }

    @GetMapping("/authors/{id}/books/{ISBN}")
    public Books getBook(@PathVariable(value = "id") Long id, @PathVariable(value = "ISBN") Long ISBN){
        return authorService.getBook(id, ISBN);
    }

    @GetMapping("/books/{ISBN}")
    public Optional getBookById(@PathVariable Long ISBN){
        return authorService.getBookById(ISBN);
    }

    @PutMapping("/books/{ISBN}")
    public Books updateBook(
                            @PathVariable(value = "ISBN") Long ISBN,
                            @RequestBody Books bookObject){
        return authorService.updateBook( ISBN, bookObject);
    }

    @DeleteMapping("/books/{ISBN}")
    public ResponseEntity<HashMap> deleteBook(
                                              @PathVariable(value = "ISBN") Long ISBN){
        authorService.deleteBook( ISBN);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "book with id: " + ISBN + "Has been destroyed.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }



}
//    @PathVariable(value = "id") Long id,
//@PathVariable(value = "id") Long id,