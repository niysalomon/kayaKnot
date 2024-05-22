package kaya.knot.kayaKnot.booking.entity.impl;

import kaya.knot.kayaKnot.house.entity.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HouseStatusDTO {
    private String id;
    private String  houseId;
    private String landLordConfirmation;
    private String bookingStatus;
    private Long price;
    private String currency;
}
