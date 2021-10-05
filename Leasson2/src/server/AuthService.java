package server;

import java.sql.*;
import java.util.*;

public class AuthService {

    public Optional<User> findUserByLoginAndPassword(String login, String pass){

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password  = ?");
            statement.setString(1, login);
            statement.setString(2,pass);

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
            throw new RuntimeException(e);
        } finally {
            DatabaseConnection.connectionClose(connection);
        }
        return Optional.empty();
    }

    public boolean isCreated(String nick){
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE name = ?");
            statement.setString(1, nick);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void rename(long id, String newNick ){
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ? ");
            statement.setString(1, newNick);
            statement.setLong(2, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseConnection.connectionClose(connection);
        }
    }

}
