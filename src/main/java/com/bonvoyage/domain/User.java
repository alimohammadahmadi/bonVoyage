package com.bonvoyage.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bonvoyage.validator.UniqueUsername;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import com.bonvoyage.validator.Age;
import com.bonvoyage.validator.Password;

/**
 * Class to hold and map user data at sign up and update. It is composed of two classes:
 * Address and Phone.
 *
 * @author Aser Ahmad
 * @author aaahmad@mum.edu
 * @version 1.0
 * @since 1.0
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "User_Id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "First_Name")
    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 4, max = 50, message = "{Size.range}")
    private String firstName;

    @Column(name = "Last_Name")
    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 4, max = 50, message = "{Size.range}")
    private String lastName;

    @Column(name = "Birthdate")
    @NotNull(message = "{NotNull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //to enable conversion from text to date
    @Age(min = 21, message = "{Age.min}")
    private LocalDate birthdate;

    @Column(name = "Email")
    @Email(message = "{Email}")
    private String email;

    @Transient
    private MultipartFile photo;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Phone_Id")
    private Phone phoneNo;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Address_Id")
    private Address address;

    @Column(name = "Username", nullable = false, unique = true)
    @NotNull(message = "{NotNull}")
//    @UniqueUsername(message = "{Unique.username}")
    @Size(min = 8, max = 20, message = "{Size.range}")
    private String username;

    @Column(name = "Password", nullable = false)
    @NotNull(message = "{NotNull}")
    @Size(min = 8, max = 20, message = "{Size.range}")
    @Password(message = "{Password}")
    private String password;

    @Column(name = "Average_Rating")
    private double averageRating;

    @Column(name = "No_of_Ratings")
    private long noOfRatings;

    @Column(name = "User_Role", columnDefinition = "varchar(20) default 'NONE'")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public Phone getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Phone phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
