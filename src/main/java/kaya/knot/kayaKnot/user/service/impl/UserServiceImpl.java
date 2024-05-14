package kaya.knot.kayaKnot.user.service.impl;

import kaya.knot.kayaKnot.user.entity.Users;
import kaya.knot.kayaKnot.user.entity.userDTO.UsersDTO;
import kaya.knot.kayaKnot.user.repo.UserRepo;
import kaya.knot.kayaKnot.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Users createNewUser(Users users) {
        return userRepo.save(users);
    }
}
