package dao;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsers implements UsersDao {

    private final Sql2o sql2o;

    public Sql2oUsers(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addUsers(Users user) {
        try (Connection con=sql2o.open()){
            String sql ="INSERT INTO users (name,phone_number) VALUES (:name,:phone_number)";

            int id=(int) con.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);


        }catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public List<Users> getAllUsers() {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM users");
            return con.createQuery(sql)
                    .executeAndFetch(Users.class);
        }
    }


    @Override
    public Users findById(int id) {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM users WHERE id=:id");
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Users.class);
        }
    }


    @Override
    public void clearAllUsers() {

        try (Connection con=sql2o.open()){
            String sql ="DELETE FROM users ";
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }


    }

}
