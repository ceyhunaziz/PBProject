package main.dao;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Validated
@Entity
public class Customer  {

    @Min(value = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please enter any name!")
    @Column(name = "name")
    private String name;

    public Customer() {

    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(@NotBlank(message = "Please enter any name!") String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
