package by.markov.libraryapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrintedProductDTO {

    private String productionsType;
    private String tittle;
    private String author;
    private int pages;
    private Date publishDate;
    private String publisher;
    private long serialNumber;
}
