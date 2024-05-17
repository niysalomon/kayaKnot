package kaya.knot.kayaKnot.policy.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserRestrictionDTO {
    private String id;
    private String pet;
    private String cat;
    private String noise;
    private String smoke;
    private String userId;
}
