package kaya.knot.kayaKnot.house.service;

import kaya.knot.kayaKnot.house.entity.House;

import java.util.List;

public interface HouseService {
    void createNewHouse(House house);
    List<House> fetchingAllHouse();


}
