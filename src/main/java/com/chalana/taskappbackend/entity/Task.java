package com.chalana.taskappbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    private String content ;

    @Enumerated(EnumType.STRING)
    private Status status ;

    @JoinColumn(name = "project_id",referencedColumnName = "id",nullable = false)
    @ManyToOne
    private Project project ;

    public enum Status{
        COMPLETED,NOT_COMPLETED
    }
}
