package kaya.knot.kayaKnot.house.service.impl;

import kaya.knot.kayaKnot.house.entity.HouseSingleUnity;
import kaya.knot.kayaKnot.house.repo.HouseSingleUnityRepo;
import kaya.knot.kayaKnot.house.service.HouseSingleUnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseSingleUnityServiceImpl implements HouseSingleUnityService {
    @Autowired
    private HouseSingleUnityRepo houseSingleUnityRepo;
    @Override
    public HouseSingleUnity createNewUnity(HouseSingleUnity houseSingleUnity) {
        return houseSingleUnityRepo.save(houseSingleUnity);
    }

    @Override
    public HouseSingleUnity updateHouseUnity(HouseSingleUnity houseSingleUnity) {
        return houseSingleUnityRepo.save(houseSingleUnity);
    }

    @Override
    public HouseSingleUnity fetchUnityHouseById(String id) {
        return houseSingleUnityRepo.findHouseUnityById(id);
    }

    @Override
    public List<HouseSingleUnity> getAllUnityByHouse(String house_id) {
        return houseSingleUnityRepo.findAllHouseUnityByHouse(house_id);
    }
}
