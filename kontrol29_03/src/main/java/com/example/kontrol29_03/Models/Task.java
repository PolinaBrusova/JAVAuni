package com.example.kontrol29_03.Models;

import com.example.kontrol29_03.utils.DateUtil;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(generator = "TaskId_generator")
    @SequenceGenerator(
                name = "TaskId_generator",
                sequenceName = "TaskID_sequence",
                initialValue = 1000
    )
    private Long id;

    @Column(name = "Naming", nullable = false)
    private String naming;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "AssignDate", nullable = false)
    private LocalDate assignDate;

    @Column(name = "Finished", nullable = false)
    private String finished;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Task(String naming, String description, String assignDate, String finished){
        this.naming=naming;
        this.description=description;
        this.assignDate=DateUtil.parse(assignDate);
        this.finished=finished;
    }

    public Task(){}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_Id", nullable = false)
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cathegory_Id", nullable = false)
    private Set<Cathegory> cathegories;

    public Long getId() {
        return id;
    }

    public String getNaming() {
        return naming;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public String getFinished() {
        return finished;
    }

    public Client getClient() {
        return client;
    }

    public Set<Cathegory> getCathegories() {
        return cathegories;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCathegory(Set<Cathegory> cathegories) {
        this.cathegories = cathegories;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", naming='" + naming + '\'' +
                ", description='" + description + '\'' +
                ", assignDate=" + assignDate +
                ", finished='" + finished + '\'' +
                ", client=" + client +
                ", cathegory=" + cathegories +
                '}';
    }
}
