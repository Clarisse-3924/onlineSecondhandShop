package dao;

import models.Telephone;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2ophones implements phonesdao{

    private final Sql2o sql2o;


    public sql2ophones(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addPhones(Telephone telephone) {
        try (Connection con=sql2o.open()){
            String sql ="INSERT INTO phones (name,description,price,image) VALUES (:name,:description,:price,:image)";

            int id=(int) con.createQuery(sql,true)
                    .bind(telephone)
                    .executeUpdate()
                    .getKey();
            telephone.setP_id(id);


        }catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public List<Telephone> getAll() {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM phones");
            return con.createQuery(sql)
                    .executeAndFetch(Telephone.class);
        }
    }


    @Override
    public Telephone findById(int id) {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM phones WHERE p_id=:id");
            return con.createQuery(sql)
                    .addParameter("p_id",id)
                    .executeAndFetchFirst(Telephone.class);
        }
    }


    @Override
    public void clearAllTelephone() {

        try (Connection con=sql2o.open()){
            String sql ="DELETE FROM phones ";
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }
}
