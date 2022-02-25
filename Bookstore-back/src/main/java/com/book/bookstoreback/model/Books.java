package com.book.bookstoreback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Books {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;

    @Column(name = "Year_Published")
    private Long yearPublished;

    @Column(name = "Title")
    private String title;

    @Column(name = "In_Stock")
    private Integer inStock;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Authors authors;


    public Books() {
    }

    public Books(Long ISBN, Long yearPublished, String title, Integer inStock) {
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
        this.title = title;
        this.inStock = inStock;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Long getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Long yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {

        this.inStock = inStock;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Books{" +
                "ISBN=" + ISBN +
                ", yearPublished=" + yearPublished +
                ", title='" + title + '\'' +
                ", inStock=" + inStock +
                '}';


    }
}

