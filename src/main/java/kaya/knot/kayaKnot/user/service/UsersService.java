package kaya.knot.kayaKnot.user.service;

import kaya.knot.kayaKnot.user.entity.Users;

import java.util.List;

public interface UsersService {
    Users createNewUser(final Users users);
    Users updateUser(final Users users);
    List<Users> fetchAllUsers();
    Users fetchUserById(final String id);

}
