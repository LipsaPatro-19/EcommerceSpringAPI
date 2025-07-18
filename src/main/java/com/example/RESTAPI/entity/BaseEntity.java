package com.example.RESTAPI.entity;

//Importing JPA annotations like @Id, @Column used for mapping class to a db structure
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Instant class from Java time API > represents the timestamp in UTC
import java.time.Instant;

//MappedSuperclass is a JPA annotation used to define the base class that contains the common fields
//which will be inherited and mapped into child entity tables
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    @PrePersist
    public void onCreate(){
        Instant now= Instant.now();
        this.createdAt=now;
        this.updatedAt=now;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt=Instant.now();
    }
}
