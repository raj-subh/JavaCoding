package Service;

import java.sql.SQLException;

import DAO.UserDAO;
import Model.User;

public class UserService {
    public static Integer saveUser(User user) {
        try {
            if (UserDAO.isUserExists(user.getEmailAddress())) {
                return 0;
            } else {
                return UserDAO.saveUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
