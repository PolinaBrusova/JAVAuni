package com.example.kontrol29_03.Models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cathegories")
public class Cathegory{
    @Id
    @GeneratedValue(generator = "CathegoryId_generator")
    @SequenceGenerator(
            name = "CathegoryId_generator",
            sequenceName = "CathegoryID_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "Naming", nullable = false)
    private String naming;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;


    public Cathegory(String naming){
        this.naming = naming;
    }

    public Cathegory(){}

    public Long getId() {
        return id;
    }

    public String getNaming() {
        return naming;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    @Override
    public String toString() {
        return "Cathegory{" +
                "id=" + id +
                ", naming='" + naming + '\'' +
                '}';
    }
}
