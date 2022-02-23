package com.book.bookstoreback.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Authors {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="authorsName")
    private String authorName;

    @OneToMany(mappedBy = "authors", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Books> booksList;

    public Authors() {
    }

    public Authors(Long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Books> getBookList() {
        return booksList;
    }

    public void setRecipeList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
