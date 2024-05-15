package kaya.knot.kayaKnot.user.service;

import kaya.knot.kayaKnot.user.entity.UserType;

import java.util.List;

public interface UserTypeService {
    UserType getUserTypeById(final String id);
    UserType createNewUserType(UserType userType);
    List<UserType> fetchUserTypes();
}
