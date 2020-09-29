package services;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServices {
    @Autowired
    UserDAO userDAO;

    public Iterable<User> listAllUsers() {
        Iterable<User> findAll = this.userDAO.findAll();
        return findAll;
    }


}
