package dao;

import models.Admin;

public interface AdminDao {

    Admin findAdmin(String username, String password);
}
