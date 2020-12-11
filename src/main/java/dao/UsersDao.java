package dao;

import models.Users;

import java.util.List;

public interface UsersDao {

    void addUsers(Users users);

    //read
    List<Users> getAllUsers();

    Users findById(int id);

    //update

    //delete

    void clearAllUsers();
}
