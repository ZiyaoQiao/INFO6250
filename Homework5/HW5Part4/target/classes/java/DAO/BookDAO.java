package DAO;

import POJO.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
@Component("BookDAO")
public class BookDAO {
    java.sql.Connection connection = null;
    Statement statement = null;

    public void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "86557060");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDB() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBooks() {
        connectDB();

        String query = "SELECT * FROM books";
        ArrayList<Book> result = new ArrayList<>();
        try {
            ResultSet re = statement.executeQuery(query);
            while (re.next()) {
                Book Book = new Book();
                Book.setAuthors(re.getString("authors"));
                Book.setIsbn(re.getString("isbn"));
                Book.setTitle(re.getString("title"));
                Book.setPrice(re.getFloat("price"));
                result.add(Book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return result;
    }

    public boolean addBook(ArrayList<Book> Book) throws SQLException {
        connectDB();

        String query = "INSERT INTO books (isbn, title, authors, price) VALUE (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        for(Book book:Book){
            ps.setString(1,book.getIsbn());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getAuthors());
            ps.setFloat(4,book.getPrice());
            ps.executeUpdate();
        }
        closeDB();
        return true;
    }

}
