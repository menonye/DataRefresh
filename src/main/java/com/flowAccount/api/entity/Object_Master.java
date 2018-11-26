package com.flowAccount.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;

@Entity
@Table(name = "object_master")
public class Object_Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer object_id;

    @NotBlank
    @Column(unique = true, name = "object_name")
    private String flow_name;

    @NotBlank
    @Column(unique = true, name = "object_type")
    private String flow_type;

    //@NotBlank
    //@AssertTrue
    @Column(unique = true, name = "is_deleted")
    private boolean is_deleted;


    public Integer getObject_id() {
        return object_id;
    }
    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
    }

    public String getFlow_name() {
        return flow_name;
    }
    public void setFlow_name(String flow_name) {
        this.flow_name = flow_name;
    }

    public String getFlow_type() {
        return flow_type;
    }
    public void setFlow_type(String flow_type) {
        this.flow_type = flow_type;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Object_Master() {
    }

    public Object_Master(String flow_name, String flow_type, boolean is_deleted) {
        this.flow_name = flow_name;
        this.flow_type = flow_type;
        this.is_deleted = is_deleted;
    }



}
