package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(name = "filename")
    private String FileName;

    @Column(name = "url")
    private String Url;

    @Column(name = "CreatedAt")
    private Date CreatedAt;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;

    @Version
    @Column(name = "version")
    private int Version;

    @OneToOne
    @JoinColumn(name = "CreatedBy")
    private User user;

    @PrePersist
    public void prePersist(){
        CreatedAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate(){
        UpdatedAt = new Date(System.currentTimeMillis());
    }


}
