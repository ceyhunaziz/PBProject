package main.dao.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Validated
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Min(value = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Please enter any name!")
    @Column(name = "name")
    private String name;

    public CustomerEntity() {

    }

    public CustomerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerEntity(@NotBlank(message = "Please enter any name!") String name) {
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
