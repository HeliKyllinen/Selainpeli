package op2.ryhmatyo.pelisivusto.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

    @Id
    private Long user_id;

    private String username;

    private String password;

    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private LocalDate createDate;

    public User() {

    }

    public User(String username, String password, String email, LocalDate createDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
                + ", role=" + role + ", createDate=" + createDate + "]";
    }

}
