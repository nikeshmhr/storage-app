package com.nikesh.storage.app.entities;

import com.nikesh.storage.app.support.UserAccountStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain object that represents the application user info. Will hold general information like username, userId, password,
 * email.
 *
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
@Entity
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo extends ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Alphanumeric unique user id given to every user while signing up
     */
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 25)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false, unique = true, length = 25)
    private String username;

    /**
     * Represents state of this particular user account.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "user_account_status", nullable = false)
    private UserAccountStatus userAccountStatus;

}
