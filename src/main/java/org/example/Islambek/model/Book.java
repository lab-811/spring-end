package org.example.Islambek.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;


    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Issued> issuedList;

}
