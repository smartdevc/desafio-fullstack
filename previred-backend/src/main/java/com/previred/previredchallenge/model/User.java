package com.previred.previredchallenge.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private Long rut;
    private String dv;
    private Date fechaNacimiento;
    private String correoElectronico;
    private String contrasena;

    @Version
    private Integer version;
}
