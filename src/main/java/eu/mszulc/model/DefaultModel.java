package eu.mszulc.model;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public class DefaultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createAt = new Date();

    public Long getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
