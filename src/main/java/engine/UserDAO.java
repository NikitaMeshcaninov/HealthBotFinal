package engine;

import entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nikita on 30.08.2016.
 */
public interface UserDAO {

        void addUser(User user) throws SQLException;

        void delUser(User user) throws SQLException;

        User getUserById(Long id) throws SQLException;

        List getAllUser() throws SQLException;

        void upDateUser(User user) throws SQLException;

    }

