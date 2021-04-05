package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "CreatedAt")
    private Date CreatedAt;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;

    @Version
    @Column(name = "version")
    private int Version;

    @OneToOne
    @JoinColumn(name="DeviceID")
    private Device device;

    @PrePersist
    public void prePersist(){
        CreatedAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate(){
        UpdatedAt = new Date(System.currentTimeMillis());
    }

}
