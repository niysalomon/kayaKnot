package kaya.knot.kayaKnot.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
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
    @Lob
    private String profilePicture;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type", nullable = false)
    @JsonManagedReference
    private UserType userType;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(name = "createdDate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(name = "lastUpdatedBy")
    @LastModifiedBy
    private String lastUpdatedBy;

    @Column(name = "lastLogin")
    private Timestamp lastLogin;

    @Column(name = "lastlogout")
    private Timestamp lastlogout;


}
