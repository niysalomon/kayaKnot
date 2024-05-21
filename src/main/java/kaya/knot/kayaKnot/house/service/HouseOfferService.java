package kaya.knot.kayaKnot.house.service;

import kaya.knot.kayaKnot.house.entity.HouseOffers;

import java.util.List;

public interface HouseOfferService {
    HouseOffers createNewHouseOffer(HouseOffers houseOffers);
    HouseOffers updateHouseOffer(HouseOffers houseOffers);
    List<HouseOffers> fetchByOffersId( String offer_id);
    List<HouseOffers> fetchByHousesId( String house_id);

}
