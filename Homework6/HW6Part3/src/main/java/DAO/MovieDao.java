package DAO;

import POJO.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

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

    public List<Movie> getMoviesBy(String values, String keyword){
        session = DAO.MainDAO.getSession();

        String qy = "FROM POJO.Movie as movie WHERE movie."+values+"="+keyword;
        //Query query = session.createQuery(qy);
        Query query = session.createQuery("FROM POJO.Movie as movie WHERE movie."+values+" LIKE :keyword");
        //query2 = query2.setParameter("values", values);
        query.setParameter("keyword", "%"+keyword+"%");
        List<Movie> list = query.list();
        session.close();
        return list;
    }
}
