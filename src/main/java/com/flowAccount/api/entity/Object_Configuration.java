package com.flowAccount.api.entity;

import java.sql.Blob;
import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "object_configuration")
public class Object_Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer object_id;

    @NotBlank
    @Column(unique = true, name = "config_version_id")
    private String config_version_id;

    @NotBlank
    @Column(unique = true, name = "created_user")
    private String created_user;

    @NotBlank
    @Column(unique = true, name = "comments")
    private String comments;

    @NotBlank
    @Column(unique = true, name = "create_timeStamp")
    private Timestamp create_timeStamp;

    @NotBlank
    @Column(unique = true, name = "config_json")
    private Blob config_json;




    public Integer getObject_id() {
        return object_id;
    }

    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
    }

    public String getConfig_version_id() {
        return config_version_id;
    }

    public void setConfig_version_id(String config_version_id) {
        this.config_version_id = config_version_id;
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getCreate_timeStamp() {
        return create_timeStamp;
    }

    public void setCreate_timeStamp(Timestamp create_timeStamp) {
        this.create_timeStamp = create_timeStamp;
    }

    public Blob getConfig_json() {
        return config_json;
    }

    public void setConfig_json(Blob config_json) {
        this.config_json = config_json;
    }

    public Object_Configuration() {

    }
    public Object_Configuration(String config_version_id, String created_user, String comments, Timestamp create_timeStamp, Blob config_json) {
        this.config_version_id = config_version_id;
        this.created_user = created_user;
        this.comments = comments;
        this.create_timeStamp = create_timeStamp;
        this.config_json = config_json;
    }



}
