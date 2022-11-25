package by.markov.libraryapp.repository;

import by.markov.libraryapp.entity.PrintedProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PrintedProductionRepository extends CrudRepository<PrintedProduct, Long> {

    Optional<PrintedProduct> findBySerialNumber(long serialNumber);

    List<PrintedProduct> findAll();

    List<PrintedProduct> findByProductionsTypeOrAuthorOrPublisher(String type, String author, String publisher);
}
