package com.book.bookstoreback.service;

import com.book.bookstoreback.exceptions.InformationExistException;
import com.book.bookstoreback.exceptions.InformationNotFoundException;
import com.book.bookstoreback.model.Books;
import com.book.bookstoreback.repository.AuthorRepository;
import com.book.bookstoreback.model.Authors;
import com.book.bookstoreback.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.*;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class AuthorService {


    private AuthorRepository authorRepository;
    private BooksRepository booksRepository;


    @Autowired
    public void setAuthorRepository (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setBooksRepository (BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Authors> getAuthors(){
        return authorRepository.findAll();
    }

    public Optional getAuthor(Long id){
        Optional authors = authorRepository.findById(id);
        if(authors.isPresent()){
            return authors;
        } else {
            throw new InformationNotFoundException("not found");
        }
    }

    public Authors createAuthor(Authors authorObject){
        Authors authors = authorRepository.findByAuthorName(authorObject.getAuthorName());
        if(authors != null){
            throw new InformationExistException(authors.getAuthorName());
        } else{
            return authorRepository.save(authorObject);
        }
    }

    public Authors updateAuthor(Long id, Authors authorObject){
        Optional<Authors> authors = authorRepository.findById(id);
        if(authors.isPresent()){
            if(authorObject.getAuthorName().equals(authors.get().getAuthorName())){
            throw new InformationExistException(authors.get().getAuthorName());
        } else {
                Authors updateAuthor = authorRepository.findById(id).get();
                updateAuthor.setAuthorName(authorObject.getAuthorName());
//            updateAuthor.setBookList(authorObject.getBookList());
//                updateAuthor.setId(authorObject.getId());
                return authorRepository.save(updateAuthor);
            }
        } else{
                throw new InformationNotFoundException("not even close");
            }
    }

    public Optional<Authors> deleteAuthor(Long id){
        Optional<Authors> authors = authorRepository.findById(id);
        if(authors.isPresent()){
            authorRepository.deleteById(id);
            return authors;
        }else{
            throw new InformationNotFoundException("that author aint here " + id);
        }
    }


    public Books createBook(Long id, Books bookObject){
        try{
            Optional authors = authorRepository.findById(id);
            bookObject.setAuthors((Authors) authors.get());
            return booksRepository.save(bookObject);
        } catch(NoSuchElementException e){
            throw new InformationNotFoundException(id + " not here");
        }
    }

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }


    public List<Books> getBooks(Long id){
        Optional <Authors> authors = authorRepository.findById(id);
        if(authors.isPresent()){
            return authors.get().getBookList();
        } else{
            throw new InformationNotFoundException("That is not here");
        }
    }

    public Optional getBookById(Long ISBN){
        Optional books = booksRepository.findByISBN(ISBN);
        if(books.isPresent()){
            return books;
        } else {
            throw new InformationNotFoundException("Not even close.");
        }
    }

    public Books getBook(Long id, Long ISBN){
        Optional<Authors> authors = authorRepository.findById(id);
        if(authors.isPresent()){
            Optional<Books> books = booksRepository.findById(id).stream().filter(
                    p -> p.getISBN().equals(ISBN)).findFirst();
            if(books.isEmpty()){
                throw new InformationNotFoundException("not here");
            }else{
                return books.get();
            }
        }else{
            throw new InformationNotFoundException("still not here");
        }
    }


    public Books updateBook( Long ISBN, Books bookObject){
        try {
            Books books = (booksRepository.findByISBN(
                    ISBN).stream().filter(p -> p.getISBN().equals(ISBN)).findFirst()).get();
            books.setTitle(bookObject.getTitle());
//            books.setAuthors(bookObject.getAuthors());
            books.setYearPublished(bookObject.getYearPublished());
            books.setInStock(bookObject.getInStock());
//            books.setISBN(bookObject.getISBN());
            return booksRepository.save(books);
        } catch (NoSuchElementException e){
            throw new InformationNotFoundException("Nope");
        }
    }

    public void deleteBook( Long ISBN){
        try{
            Books books = (booksRepository.findByISBN(ISBN).stream().filter(p -> p.getISBN().equals(ISBN)).findFirst()).get();
            booksRepository.deleteById(books.getISBN());
        } catch (NoSuchElementException e){
            throw new InformationNotFoundException("Can't delete whats not there.");
        }
    }




}
