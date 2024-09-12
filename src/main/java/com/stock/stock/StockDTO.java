package com.stock.stock;

import lombok.Data;

@Data
public class StockDTO {
    private Long id;
    private String itemName;
    private Integer stockQuantity;
    private String serialNumber;
    private String additionalInfo;
    private String imagePath;
}