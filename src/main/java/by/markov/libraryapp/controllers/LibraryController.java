package by.markov.libraryapp.controllers;


import by.markov.libraryapp.dto.PrintedProductDTO;
import by.markov.libraryapp.mapping.PrintedProductionsMapper;
import by.markov.libraryapp.services.LibraryBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryBaseService libraryService;
    private final PrintedProductionsMapper printedProductionsMapper;

    @GetMapping
    public ResponseEntity<List<PrintedProductDTO>> getPrintedProducts() {
        return ResponseEntity.ok().body(printedProductionsMapper.toDtoList(libraryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrintedProductDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok().body(printedProductionsMapper.toDto(libraryService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PrintedProductDTO> addPrintedProduct(@RequestBody PrintedProductDTO printedProductDTO) {
        libraryService.addPrintedProduct(printedProductionsMapper.toEntity(printedProductDTO));
        return ResponseEntity.ok().body(printedProductDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrintedProduct(@PathVariable long id) {
        libraryService.deleteById(id);
        return ResponseEntity.ok().body(String.format("Printed Production With id: %d Was Deleted.", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrintedProductDTO> updatePrintedProduct(@PathVariable long id,
                                                                  @RequestBody PrintedProductDTO printedProductDTO) {
        libraryService.updatePrintedProduct(id, printedProductionsMapper.toEntity(printedProductDTO));
        return ResponseEntity.ok().body(printedProductDTO);
    }
}
