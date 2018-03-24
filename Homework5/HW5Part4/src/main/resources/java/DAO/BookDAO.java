package DAO;

import POJO.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("BookDAO")
public class BookDAO {
    Session session;
    public List<Books> getBooks() {
        session = MainDAO.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM POJO.Books");
        List<Books> list = query.list();

        tx.commit();
        session.close();
        return list;
    }

    public boolean addBook(ArrayList<Books> Book) throws SQLException {
        session = MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        for(Books book:Book){
            session.save(book);
        }
        tx.commit();
        session.close();
        return true;
    }

}
