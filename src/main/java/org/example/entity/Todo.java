package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 12, max = 140, message = " Your need input min 12 max 140")
    private String title;
    @javax.validation.constraints.NotBlank(message = "Field Not null")
    private String description;
    @NotBlank(message = "Field Not null")
    @Column(name = "priority")
    private String urowen;
    private String data;
}
