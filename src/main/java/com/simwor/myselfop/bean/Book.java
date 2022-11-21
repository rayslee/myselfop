package com.simwor.myselfop.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String isbn;

    @NotBlank
    private String name;

    private LocalDateTime publishDate;

    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private List<Author> authors;

}
