package kaya.knot.kayaKnot.booking.service;

import kaya.knot.kayaKnot.booking.entity.Corenting;
import kaya.knot.kayaKnot.booking.entity.dto.CorentingUserHouseDTO;

import java.util.List;

public interface CorentingService {
    Corenting createNewCorenting(Corenting corenting);
    List<CorentingUserHouseDTO> fetchCorentingByHouseStatusId(String house_id);
    CorentingUserHouseDTO fetchCorentingDetailsByHouse(String house_id);

}
