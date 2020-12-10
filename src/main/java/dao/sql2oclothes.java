package dao;

import models.Clothes;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oclothes implements clothesdao {

    private final Sql2o sql2o;


    public sql2oclothes(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addClothes(Clothes clothes) {
        try (Connection con=sql2o.open()){
            String sql ="INSERT INTO clothes (name,description,price,image) VALUES (:name,:description,:price,:image)";

            int id=(int) con.createQuery(sql,true)
                    .bind(clothes)
                    .executeUpdate()
                    .getKey();
            clothes.setId(id);


        }catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public List<Clothes> getAll() {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM clothes");
            return con.createQuery(sql)
                    .executeAndFetch(Clothes.class);
        }
    }


    @Override
    public Clothes findById(int id) {
        try (Connection con=sql2o.open()){
            String sql=("SELECT * FROM clothes WHERE c_id=:id");
            return con.createQuery(sql)
                    .addParameter("c_id",id)
                    .executeAndFetchFirst(Clothes.class);
        }
    }


    @Override
    public void clearAllClothes() {

        try (Connection con=sql2o.open()){
            String sql ="DELETE FROM clothes ";
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }

    }
}
