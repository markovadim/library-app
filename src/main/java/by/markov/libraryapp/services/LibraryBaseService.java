package by.markov.libraryapp.services;

import by.markov.libraryapp.entity.PrintedProduct;
import by.markov.libraryapp.exceptions.PrintedProductionAlreadyExistsException;
import by.markov.libraryapp.exceptions.PrintedProductionNotFoundException;
import by.markov.libraryapp.repository.PrintedProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryBaseService {

    private final PrintedProductionRepository productionRepository;

    public PrintedProduct addPrintedProduct(PrintedProduct printedProduct) {
        if (productionRepository.findBySerialNumber(printedProduct.getSerialNumber()).isPresent()) {
            throw new PrintedProductionAlreadyExistsException();
        }
        printedProduct.setPublishDate(new Date());
        return productionRepository.save(printedProduct);
    }

    public List<PrintedProduct> findAll() {
        return productionRepository.findAll();
    }

    public PrintedProduct findById(long id) {
        return productionRepository.findById(id).orElseThrow(PrintedProductionNotFoundException::new);
    }

    public void deleteById(Long id) {
        findById(id);
        productionRepository.deleteById(id);
    }

    @Transactional
    public PrintedProduct updatePrintedProduct(long id, PrintedProduct updatedPrintedProduct) {
        PrintedProduct printedProduct = findById(id);
        printedProduct.setProductionsType(updatedPrintedProduct.getProductionsType());
        printedProduct.setTittle(updatedPrintedProduct.getTittle());
        printedProduct.setAuthor(updatedPrintedProduct.getAuthor());
        printedProduct.setPages(updatedPrintedProduct.getPages());
        printedProduct.setPublisher(updatedPrintedProduct.getPublisher());
        printedProduct.setPublishDate(new Date());
        printedProduct.setSerialNumber(updatedPrintedProduct.getSerialNumber());
        return productionRepository.save(printedProduct);
    }
}
