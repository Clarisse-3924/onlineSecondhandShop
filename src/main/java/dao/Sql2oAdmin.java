package dao;

import models.Admin;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oAdmin implements AdminDao{

    private final Sql2o sql2o;

    public Sql2oAdmin(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Admin findAdmin(String username, String password) {
        try (Connection con = sql2o.open()) {
            String sql = ("select * from admin where username=:username AND password=:password");
            return con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeAndFetchFirst(Admin.class);
        }

    }
}
