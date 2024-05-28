package kaya.knot.kayaKnot.house.service.impl;

import kaya.knot.kayaKnot.house.entity.HousePhoto;
import kaya.knot.kayaKnot.house.repo.HousePhotoRepo;
import kaya.knot.kayaKnot.house.service.HousePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousePhotoServiceImpl implements HousePhotoService {
    @Autowired
    private HousePhotoRepo housePhotoRepo;
    @Override
    public HousePhoto createHousePhoto(HousePhoto housePhoto) {
        return housePhotoRepo.save(housePhoto);
    }

    @Override
    public int deleteHousePhoto(String id) {
        return housePhotoRepo.deleteHousePhoto(id);
    }

    @Override
    public List<HousePhoto> getHousePhotoByHouse(String house_id) {
        return housePhotoRepo.selectPhotoByHouse(house_id);
    }
}
