package DAO;

import POJO.Movie;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDao {
    java.sql.Connection connection = null;
    Statement statement = null;

    public void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "86557060");
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

    public ArrayList<Movie> getMovies() {
        connectDB();

        String query = "SELECT * FROM movie";
        ArrayList<Movie> result = new ArrayList<>();
        try {
            ResultSet re = statement.executeQuery(query);
            while (re.next()) {
                Movie movie = new Movie();
                movie.setTitle(re.getString("title"));
                movie.setActor(re.getString("actor"));
                movie.setActress(re.getString("actress"));
                movie.setGenre(re.getString("genre"));
                movie.setYear(re.getInt("year"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return result;
    }

    public boolean addMovie(Movie movie) {
        connectDB();

        String query = "INSERT INTO movie (title, actor, actress, genre, year)" + " VALUES ('" + movie.getTitle() + "','" + movie.getActor() + "','" + movie.getActress() + "','" + movie.getGenre() + "','" + movie.getYear() + "')";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return true;
    }

    public ArrayList<Movie> getMoviesBy(String value, String keyword){
        connectDB();
        ArrayList<Movie> result = new ArrayList<>();
        String query = "SELECT * FROM movie WHERE "+value+"='"+keyword+"'";
        try {
            ResultSet re = statement.executeQuery(query);
            while(re.next()){
                Movie movie = new Movie();
                movie.setTitle(re.getString("title"));
                movie.setActor(re.getString("actor"));
                movie.setActress(re.getString("actress"));
                movie.setGenre(re.getString("genre"));
                movie.setYear(re.getInt("year"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
