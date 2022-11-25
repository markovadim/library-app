package by.markov.libraryapp.mapping;

import by.markov.libraryapp.dto.PrintedProductDTO;
import by.markov.libraryapp.entity.PrintedProduct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PrintedProductionsMapper {

    private final ModelMapper modelMapper;

    public PrintedProductDTO toDto(PrintedProduct printedProduct) {
        return modelMapper.map(printedProduct, PrintedProductDTO.class);
    }

    public PrintedProduct toEntity(PrintedProductDTO printedProductDTO) {
        return modelMapper.map(printedProductDTO, PrintedProduct.class);
    }

    public List<PrintedProductDTO> toDtoList(List<PrintedProduct> printedProducts) {
        return printedProducts.stream().map(p -> modelMapper.map(p, PrintedProductDTO.class)).collect(Collectors.toList());
    }
}
