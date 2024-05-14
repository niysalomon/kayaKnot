package kaya.knot.kayaKnot.house.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kaya.knot.kayaKnot.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
    public class House {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private long id;
        private String houseName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "land_lord", nullable = false)
    @JsonManagedReference
        private Users landLordId;
        private String province;
        private String district;
        private String sector;
        private String cell;
        private String village;
        private Boolean isAvailable;
        private String description;
        private String location;
        private String longitude;
        private String latitude;
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
    }

