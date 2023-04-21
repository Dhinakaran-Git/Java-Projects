package com.bassure.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alien_table")
public class Alien {

    @Id
    private int aid;
    @Column(name = "alienName")
    private String aName;
    @Column(name = "alienColor")
    private String color;
}
