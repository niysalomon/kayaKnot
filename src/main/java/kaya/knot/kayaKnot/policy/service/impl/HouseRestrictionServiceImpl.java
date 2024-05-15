package kaya.knot.kayaKnot.policy.service.impl;

import kaya.knot.kayaKnot.policy.entity.HouseRestriction;
import kaya.knot.kayaKnot.policy.repo.HouseRestrictionRepo;
import kaya.knot.kayaKnot.policy.service.HouseRestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseRestrictionServiceImpl implements HouseRestrictionService {
    @Autowired
    private HouseRestrictionRepo houseRestrictionRepo;
    @Override
    public HouseRestriction createNewHouseRestriction(HouseRestriction houseRestriction) {
        return houseRestrictionRepo.save(houseRestriction);
    }

    @Override
    public HouseRestriction updateHouseRestriction(HouseRestriction houseRestriction) {
        return houseRestrictionRepo.save(houseRestriction);
    }

    @Override
    public Optional<HouseRestriction> fetchHouseRestrictionById(final String id) {
        return houseRestrictionRepo.findById(id);
    }

    @Override
    public List<HouseRestriction> fetchAllHouseRestrictions() {
        return houseRestrictionRepo.findAll();
    }

    @Override
    public List<HouseRestriction> fetchRestrictionByHouse(String house_id) {
        return null;
    }
}
