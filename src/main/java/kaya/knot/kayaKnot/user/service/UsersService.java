package kaya.knot.kayaKnot.user.service;

import kaya.knot.kayaKnot.user.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users createNewUser(final Users users);
    Users updateUser(final Users users);
    List<Users> fetchAllUsers();
    Optional<Users> fetchUserById(final String id);

}
