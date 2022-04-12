package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_task",
            joinColumns = { @JoinColumn(name = "users_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks = new ArrayList<Task>();
}
