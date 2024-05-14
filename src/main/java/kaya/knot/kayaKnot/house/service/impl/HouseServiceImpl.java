package kaya.knot.kayaKnot.house.service.impl;

import kaya.knot.kayaKnot.house.entity.House;
import kaya.knot.kayaKnot.house.repo.HouseRepo;
import kaya.knot.kayaKnot.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepo houseRepo;
    @Override
    public void createNewHouse(House house) {
        houseRepo.save(house);
    }

    @Override
    public List<House> fetchingAllHouse() {
        return houseRepo.findAll();
    }
}
