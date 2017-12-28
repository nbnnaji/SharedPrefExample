package com.example.nkechi_nnaji.sharedprefexample;

import java.util.List;

/**
 * Created by nkechi_nnaji on 12/28/17.
 */

//EMployee model class
public class Employee {

    private String name;
    private String profession;
    private Integer profId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    private List<String> roles;



}
