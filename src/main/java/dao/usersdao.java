package dao;

import models.Clothes;
import models.Users;

import java.util.List;

public interface usersdao {

    void addUsers(Users users);

    //read
    List<Users> getAll();

    Users findById(int id);

    //update

    //delete

    void clearAllUsers();
}
