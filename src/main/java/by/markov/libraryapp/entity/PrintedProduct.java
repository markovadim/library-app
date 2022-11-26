package by.markov.libraryapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintedProduct {

    @Id
    private long id;
    private String productionsType;
    private String title;
    private String author;
    private int pages;
    private Date publishDate;
    private String publisher;
    private long serialNumber;
}
