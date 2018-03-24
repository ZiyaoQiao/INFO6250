package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Books {
    private String isbn;
    private String title;
    private String authors;
    private Double price;

    @Id
    @Column(name = "isbn", nullable = false, length = 12)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 60)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "authors", nullable = true, length = 60)
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(isbn, books.isbn) &&
                Objects.equals(title, books.title) &&
                Objects.equals(authors, books.authors) &&
                Objects.equals(price, books.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbn, title, authors, price);
    }
}
