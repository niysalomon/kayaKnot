package kaya.knot.kayaKnot.policy.service;

import kaya.knot.kayaKnot.policy.entity.UserRestriction;

import java.util.List;

public interface UserRestrictionService {
    UserRestriction createNewUserRestriction(UserRestriction userRestriction);
    UserRestriction updateUserRestriction(UserRestriction userRestriction);
    UserRestriction fetchSingleUserRestrictionById(String id);
    List<UserRestriction> fetchRestrictionsByUser(String user_id);
}
