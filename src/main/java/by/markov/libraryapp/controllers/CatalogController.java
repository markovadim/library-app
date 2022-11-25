package by.markov.libraryapp.controllers;


import by.markov.libraryapp.dto.PrintedProductDTO;
import by.markov.libraryapp.mapping.PrintedProductionsMapper;
import by.markov.libraryapp.services.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;
    private final PrintedProductionsMapper printedProductionsMapper;


    @GetMapping("/filter")
    public ResponseEntity<List<PrintedProductDTO>> getByProductionsTypeOrAuthorOrPublisherFilter(@RequestParam(required = false) String type,
                                                                                                 @RequestParam(required = false) String author,
                                                                                                 @RequestParam(required = false) String publisher) {
        return ResponseEntity.ok().body(printedProductionsMapper
                .toDtoList(catalogService.findByProductionsTypeOrAuthorOrPublisher(type, author, publisher)));
    }

    @GetMapping("/before")
    public ResponseEntity<List<PrintedProductDTO>> getByFilterBeforeDate(@RequestParam String date) {
        return ResponseEntity.ok().body(printedProductionsMapper
                .toDtoList(catalogService.findProductionsBeforeDate(date)));
    }

    @GetMapping("/after")
    public ResponseEntity<List<PrintedProductDTO>> getByFilterAfterDate(@RequestParam String date) {
        return ResponseEntity.ok().body(printedProductionsMapper
                .toDtoList(catalogService.findProductionsAfterDate(date)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PrintedProductDTO>> getByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok().body(printedProductionsMapper
                .toDtoList(catalogService.findByKeyword(keyword)));
    }
}
