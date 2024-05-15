package kaya.knot.kayaKnot.user.entity.userDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kaya.knot.kayaKnot.user.entity.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class UsersDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private String martialStatus;
    private String phone;
    private String email;
    private String nationality;
    private String nidPassport;
    private boolean isLandLord;
    private String password;
    private String profilePicture;

    private String userType;
}
