package com.colby.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {

    @OneToMany
    @JoinColumn(name = "rm_id")
    private Reimbursement rm_id;

    @OneToMany
    @JoinColumn(name = "emp_id")
    private User user;

    private String status;
    private Boolean is_approved;
    private Integer amount;

    public Request() {
    }

    public Request(Reimbursement rm_id, User user, String status, Boolean is_approved, Integer amount) {
        this.rm_id = rm_id;
        this.user = user;
        this.status = status;
        this.is_approved = is_approved;
        this.amount = amount;
    }

    public Reimbursement getRm_id() {
        return rm_id;
    }

    public void setRm_id(Reimbursement rm_id) {
        this.rm_id = rm_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "rm_id=" + rm_id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", is_approved=" + is_approved +
                ", amount=" + amount +
                '}';
    }
}
