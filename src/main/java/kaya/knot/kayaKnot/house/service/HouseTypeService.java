package kaya.knot.kayaKnot.house.service;

import kaya.knot.kayaKnot.house.entity.HouseType;

import java.util.List;

public interface HouseTypeService {
HouseType createNewHouseType(HouseType houseType);
HouseType updateHouseType(HouseType houseType);
HouseType fetchHouseById(String id);
List<HouseType> fetchAllHouseTypes();
}
