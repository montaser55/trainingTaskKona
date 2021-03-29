package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(name = "os")
    private String OS;

    @Column(name = "mac")
    private String mac;

    @Column(name = "DeviceToken")
    private String DeviceToken;

    @Column(name = "CreatedAt")
    private Date CreatedAt;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;

    @Version
    @Column(name = "version")
    private int Version;

    @PrePersist
    public void prePersist(){
        CreatedAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate(){
        UpdatedAt = new Date(System.currentTimeMillis());
    }
}
