package com.example;

public class User {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String email;
    public User(int customer_id, String first_name, String last_name, String email) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }

}
