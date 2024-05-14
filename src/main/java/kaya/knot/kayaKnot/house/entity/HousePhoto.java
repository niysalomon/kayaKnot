package kaya.knot.kayaKnot.house.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Blob;
import java.sql.Timestamp;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class HousePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
@ManyToOne(fetch = FetchType.LAZY)
    private House houseId;
    private Blob housePhoto;
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
