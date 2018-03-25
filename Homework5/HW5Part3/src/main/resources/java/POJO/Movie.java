package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

public class Movie {
    private String title;
    private String actor;
    private String actress;
    private String genre;
    private Integer year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(actor, movie.actor) &&
                Objects.equals(actress, movie.actress) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(year, movie.year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, actor, actress, genre, year);
    }
}
