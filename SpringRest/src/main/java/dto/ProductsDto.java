package dto;

import lombok.Data;

@Data
public class ProductsDto {

    private String name;
    private String description;
    private double price;
    private Long categoryId;

}
