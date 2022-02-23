package com.book.bookstoreback.model;

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
    private Integer inSock;


    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Authors authors;

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Books() {
    }

    public Books(Long ISBN, Long yearPublished, String title, Integer inSock) {
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
        this.title = title;
        this.inSock = inSock;
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

    public Integer getInSock() {
        return inSock;
    }

    public void setInSock(Integer inSock) {
        this.inSock = inSock;
    }

    @Override
    public String toString() {
        return "Books{" +
                "ISBN=" + ISBN +
                ", yearPublished=" + yearPublished +
                ", title='" + title + '\'' +
                ", inSock=" + inSock +
                '}';
    }
}
