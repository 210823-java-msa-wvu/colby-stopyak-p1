package com.colby.models;


import javax.persistence.*;
import java.sql.Timestamp;

//@Entity
//@Table(name = "reimbursement")
public class Reimbursement {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rm_id;

    private String description;
    private String work_related;
    private Float amount;
    private String location;
    private String status;
    private Boolean is_approved;
    private Timestamp created_at;
    private Timestamp updated_at;



//    @ManyToOne
//    @JoinColumn(name = "emp_id")
    private User user;


    public Reimbursement() {
    }

    public Reimbursement(Integer rm_id, String description, String work_related, Float amount, String location, String status, Boolean is_approved, Timestamp created_at, Timestamp updated_at, User user) {
        this.rm_id = rm_id;
        this.description = description;
        this.work_related = work_related;
        this.amount = amount;
        this.location = location;
        this.status = status;
        this.is_approved = is_approved;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

    public Integer getRm_id() {
        return rm_id;
    }

    public void setRm_id(Integer rm_id) {
        this.rm_id = rm_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWork_related() {
        return work_related;
    }

    public void setWork_related(String work_related) {
        this.work_related = work_related;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(Boolean is_approved) {
        this.is_approved = is_approved;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "rm_id=" + rm_id +
                ", description='" + description + '\'' +
                ", work_related='" + work_related + '\'' +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", is_approved=" + is_approved +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", user=" + user +
                '}';
    }
}
