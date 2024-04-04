//package com.project.model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "token")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Token {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "token")
//    private String token;
//
//    @Column(name = "is_logged_out")
//    private boolean loggedOut;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Employee employee;
//
//
//}
