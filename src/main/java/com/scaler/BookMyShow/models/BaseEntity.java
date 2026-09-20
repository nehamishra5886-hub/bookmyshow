package com.scaler.BookMyShow.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Temporal;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import javax.persistence.Temporal;
import java.util.Date;


@Setter
@Getter
@MappedSuperclass
@EntityListeners( AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1,2,3...
    private int id;

    @CreatedDate
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date updatedAt;
}
