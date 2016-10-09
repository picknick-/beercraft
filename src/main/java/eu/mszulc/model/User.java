package eu.mszulc.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User extends DefaultModel {

    @NotNull
    private String email;

    @NotNull
    private String name;

    // Public methods

    protected User() {
    }

    public User(long id) {

    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format(
                "User[id=%d, Email='%s', Name='%s' Date='%s']",
                getId(), email, name, getCreateAt());
    }
}
