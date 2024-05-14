package kaya.knot.kayaKnot.user.service;

import kaya.knot.kayaKnot.user.entity.Users;
import kaya.knot.kayaKnot.user.entity.userDTO.UsersDTO;

public interface UsersService {
    Users createNewUser(Users users);
}
