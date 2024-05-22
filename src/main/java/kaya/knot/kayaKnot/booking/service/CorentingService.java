package kaya.knot.kayaKnot.booking.service;

import kaya.knot.kayaKnot.booking.entity.Corenting;

import java.util.List;

public interface CorentingService {
    Corenting createNewCorenting(Corenting corenting);
    List<Corenting> fetchCorentingByHouse(String house_id);

}
