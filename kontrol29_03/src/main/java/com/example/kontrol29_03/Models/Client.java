package com.example.kontrol29_03.Models;

import com.example.kontrol29_03.utils.DateUtil;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Clients")
public class Client{
    @Id
    @GeneratedValue(generator = "ClientId_generator")
    @SequenceGenerator(
            name = "ClientId_generator",
            sequenceName = "ClientID_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "Login", nullable = false)
    private String login;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "FatherName", nullable = false)
    private String fatherName;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Task_Id", nullable = false)
    private Set<Task> task;

    public Client(String login, String firstName, String lastName, String faterName, String birthDate){
        this.login = login;
        this.firstName=firstName;
        this.lastName=lastName;
        this.fatherName=firstName;
        this.birthDate = DateUtil.parse(birthDate);
    }

    public Client(){}

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Set<Task> getTask() {
        return task;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTask(Set<Task> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}