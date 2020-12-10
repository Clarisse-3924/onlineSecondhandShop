package dao;

import models.Telephone;

import java.util.List;

public interface phonesdao {

    void addPhones(Telephone telephone);

    //read
    List<Telephone> getAll();

    Telephone findById(int id);

    //update

    //delete

    void clearAllTelephone();
}
