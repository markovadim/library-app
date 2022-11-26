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
class CatalogServiceTest {

    @Mock
    private PrintedProductionRepository productionRepository;
    @InjectMocks
    private CatalogService catalogService;

    private List<PrintedProduct> productListForTests;

    @BeforeEach
    public void initPrintedProducts() {
        productListForTests = List.of(new PrintedProduct(1L, "book", "Master I Margarita", "Bulgakov", 231, Date.valueOf("2011-04-14"), "EKSMO", 32146123L),
                new PrintedProduct(2L, "newspaper", "The Times", "The Times", 15, Date.valueOf("2021-01-18"), "NY-Typography", 2466123L),
                new PrintedProduct(3L, "journal", "GQ", "Mass-media", 31, Date.valueOf("2017-02-22"), "Russia Print", 53221523L));
    }

    @Test
    void findByProductionsTypeOrAuthorOrPublisherShouldReturnProductionsList() {
        Mockito.when(productionRepository.findByProductionsTypeOrAuthorOrPublisher("book", null, null)).thenReturn(List.of(productListForTests.get(0)));

        List<PrintedProduct> list = catalogService.findByProductionsTypeOrAuthorOrPublisher("book", null, null);

        assertEquals(1, list.size());
        assertNotNull(list.stream().findAny());
        assertEquals("Bulgakov", list.stream().findAny().get().getAuthor());
    }

    @Test
    void findProductionsBeforeDateShouldReturnProductionsWhichPublishedBeforeInputDate() {
        Mockito.when(productionRepository.findAll()).thenReturn(productListForTests);

        List<PrintedProduct> list = catalogService.findProductionsBeforeDate("2018-01-01");

        assertEquals(2, list.size());
        assertEquals("journal", list.get(1).getProductionsType());
    }

    @Test
    void findProductionsAfterDateShouldReturnProductionsWhichPublishedAfterInputDate() {
        Mockito.when(productionRepository.findAll()).thenReturn(productListForTests);

        List<PrintedProduct> list = catalogService.findProductionsAfterDate("2017-03-03");

        assertEquals(1, list.size());
        assertEquals("The Times", list.get(0).getTitle());
    }

    @Test
    void findByKeyword() {
    }
}