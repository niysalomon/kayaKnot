package kaya.knot.kayaKnot.booking.service.Impl;

import kaya.knot.kayaKnot.booking.entity.Corenting;
import kaya.knot.kayaKnot.booking.repo.CorentingRepo;
import kaya.knot.kayaKnot.booking.service.CorentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorentingServiceImpl implements CorentingService {
    @Autowired
    private CorentingRepo corentingRepo;
    @Override
    public Corenting createNewCorenting(Corenting corenting) {
        return corentingRepo.save(corenting);
    }

    @Override
    public List<Corenting> fetchCorentingByHouse(String house_id) {
        return corentingRepo.findCorentingHouse(house_id);
    }
}
