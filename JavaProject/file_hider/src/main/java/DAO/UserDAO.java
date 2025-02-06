package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.MyConnection;
import Model.User;

public class UserDAO {
    public static boolean isUserExists(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select email from users");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String emailAddress = resultSet.getString(1);
            if (emailAddress.equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static int saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(default ? ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmailAddress());
        return preparedStatement.executeUpdate();
    }
}
