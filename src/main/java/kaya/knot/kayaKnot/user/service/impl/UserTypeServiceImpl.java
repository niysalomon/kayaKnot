package kaya.knot.kayaKnot.user.service.impl;

import kaya.knot.kayaKnot.user.entity.UserType;
import kaya.knot.kayaKnot.user.repo.UserTypeRepo;
import kaya.knot.kayaKnot.user.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class UserTypeServiceImpl implements UserTypeService {
@Autowired
    private UserTypeRepo userTypeRepo;


    @Override
    public UserType getUserTypeById(long id) {
        return userTypeRepo.fetchUserType(id);
    }
}
