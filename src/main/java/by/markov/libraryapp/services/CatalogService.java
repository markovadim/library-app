package by.markov.libraryapp.services;


import by.markov.libraryapp.entity.PrintedProduct;
import by.markov.libraryapp.repository.PrintedProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final PrintedProductionRepository productionRepository;

    public List<PrintedProduct> findByProductionsTypeOrAuthorOrPublisher(String type, String author, String publisher) {
        return productionRepository.findByProductionsTypeOrAuthorOrPublisher(type, author, publisher);
    }

    public List<PrintedProduct> findProductionsBeforeDate(String date) {
        return productionRepository.findAll()
                .stream()
                .filter(p -> p.getPublishDate().getTime() < Date.valueOf(date).getTime())
                .collect(Collectors.toList());
    }

    public List<PrintedProduct> findProductionsAfterDate(String date) {
        return productionRepository.findAll()
                .stream()
                .filter(p -> p.getPublishDate().getTime() > Date.valueOf(date).getTime())
                .collect(Collectors.toList());
    }

    public List<PrintedProduct> findByKeyword(String keyword) {
        return productionRepository.findAll()
                .stream()
                .filter(p -> p.toString().contains(keyword))
                .collect(Collectors.toList());
    }
}
