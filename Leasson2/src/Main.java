import server.AuthService;
import server.DatabaseConnection;
import server.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }
    public static List<User> findAll(){

        Connection connection = DatabaseConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            List<User> users = new ArrayList<>();

            while (rs.next()){
                users.add(
                        new User(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("login"),
                                rs.getString("password")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            DatabaseConnection.connectionClose(connection);
        }

        return Collections.emptyList();
    }

    public static Optional<User> findById(long id){
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                return Optional.of(
                        new User(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("login"),
                                rs.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.getConnection();
        }
        return Optional.empty();
    }
}
