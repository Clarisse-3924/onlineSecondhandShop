package dao;

import java.util.List;
import models.Clothes;

public interface clothesdao {


    void addClothes(Clothes clothes);

    //read
    List<Clothes> getAllClothes();

    Clothes findById(int id);

    //update

    //delete

    void clearAllClothes();
}
