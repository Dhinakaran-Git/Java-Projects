package in.bassure.servlet.web1.model;

import java.time.LocalDateTime;

public class Customer {

    private int customerId;
    private String name;
    private String email;
    private String mobile;
    private LocalDateTime joinedOn;

    public Customer() {
    }

    public Customer(int customerId, String name, String email, String mobile, LocalDateTime joinedOn) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.joinedOn = joinedOn;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(LocalDateTime joinedOn) {
        this.joinedOn = joinedOn;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", joinedOn=" + joinedOn + '}';
    }

}
