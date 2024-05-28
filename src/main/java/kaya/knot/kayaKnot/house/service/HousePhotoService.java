package kaya.knot.kayaKnot.house.service;

import kaya.knot.kayaKnot.house.entity.HousePhoto;

import java.util.List;

public interface HousePhotoService {
    HousePhoto createHousePhoto(HousePhoto housePhoto);
    int deleteHousePhoto(String id);
    List<HousePhoto> getHousePhotoByHouse(String house_id);
}
