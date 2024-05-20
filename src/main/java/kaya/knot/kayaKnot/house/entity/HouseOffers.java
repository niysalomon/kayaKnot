package kaya.knot.kayaKnot.house.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kaya.knot.kayaKnot.user.entity.Users;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class HouseOffers {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house", nullable = false)
    @JsonManagedReference
    private House house;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer", nullable = false)
    @JsonManagedReference
    private Offers offers;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
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
}