package DAO;

import POJO.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component("MovieDao")
public class MovieDao {
    Session session;

    public List<Movie> getMovies() {
        session = DAO.MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        Query query =session.createQuery("from POJO.Movie ");
        List<Movie> list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    public boolean addMovie(Movie movie) {
        session = DAO.MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        session.save(movie);
        tx.commit();
        session.close();
        return true;
    }

    public List<Movie> getMoviesBy(String value, String keyword){
        session = DAO.MainDAO.getSession();

        String qy = "FROM POJO.Movie as movie WHERE movie."+value+"="+keyword;
        Query query = session.createQuery(qy);
        List<Movie> list = query.list();
        return list;
    }
}
