package by.markov.libraryapp.services;

import by.markov.libraryapp.entity.PrintedProduct;
import by.markov.libraryapp.repository.PrintedProductionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibraryBaseServiceTest {

    @Mock
    private PrintedProductionRepository productionRepository;
    @InjectMocks
    private LibraryBaseService libraryBaseService;

    private List<PrintedProduct> productListForTests;

    @BeforeEach
    public void initPrintedProducts() {
        productListForTests = List.of(new PrintedProduct(1L, "book", "Master I Margarita", "Bulgakov", 231, Date.valueOf("2011-04-14"), "EKSMO", 32146123L),
                new PrintedProduct(2L, "newspaper", "The Times", "The Times", 15, Date.valueOf("2021-01-18"), "NY-Typography", 2466123L),
                new PrintedProduct(3L, "journal", "GQ", "Mass-media", 31, Date.valueOf("2017-02-22"), "Russia Print", 53221523L));
    }

    @Test
    void findAllShouldReturnAllPrintedProductions() {
        Mockito.when(productionRepository.findAll()).thenReturn(productListForTests);

        List<PrintedProduct> products = libraryBaseService.findAll();

        assertNotNull(products);
        assertEquals(3, products.size());
    }

    @Test
    void findByIdShouldReturnOnlyOneObject() {
        Mockito.when(productionRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(productListForTests.get(1)));

        PrintedProduct product = libraryBaseService.findById(2L);

        assertEquals("newspaper", product.getProductionsType());
    }

    @Test
    void addPrintedProductShouldSaveObjectInRepository() {
        PrintedProduct product = new PrintedProduct(4L, "journal", "VOGUE", "Mass-Media-ART", 23, Date.valueOf("2022-12-12"), "Karandash Publisher", 6544532L);
        Mockito.when(productionRepository.save(product))
                .thenReturn(product);

        assertNotNull(libraryBaseService.addPrintedProduct(product));
        assertEquals(4L, libraryBaseService.addPrintedProduct(product).getId());
    }

    @Test
    void updateProductShouldChangeObjectsFieldsInRepo() {
        PrintedProduct product = new PrintedProduct(3L, "journal", "GQ", "Unknown Author", 31, Date.valueOf("2022-11-27"), "ART-Media", 53225823L);

        Mockito.when(productionRepository.findById(3L)).thenReturn(java.util.Optional.of(product));
        Mockito.when(productionRepository.save(product)).thenReturn(product);

        PrintedProduct printedProduct = libraryBaseService.updatePrintedProduct(3L, product);

        assertEquals(product.getAuthor(), printedProduct.getAuthor());
    }
}