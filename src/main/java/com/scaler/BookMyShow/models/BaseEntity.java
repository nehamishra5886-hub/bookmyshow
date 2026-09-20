package com.scaler.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
