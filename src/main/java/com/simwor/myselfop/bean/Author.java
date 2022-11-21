package com.simwor.myselfop.bean;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    @ToString.Exclude
    private List<Book> books;

}
