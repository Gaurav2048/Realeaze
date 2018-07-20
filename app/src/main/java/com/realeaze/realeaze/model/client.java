package com.realeaze.realeaze.model;

import java.io.Serializable;

/**
 * Created by saurav on 6/3/2018.
 */

public class client implements Serializable{

    String client_name;
    String client_phone;
    String client_email;
    String client_requirement;
    String client_price;

    public client(String client_name, String client_phone, String client_email, String client_requirement, String client_price) {
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_requirement = client_requirement;
        this.client_price = client_price;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_requirement() {
        return client_requirement;
    }

    public void setClient_requirement(String client_requirement) {
        this.client_requirement = client_requirement;
    }

    public String getClient_price() {
        return client_price;
    }

    public void setClient_price(String client_price) {
        this.client_price = client_price;
    }
}
