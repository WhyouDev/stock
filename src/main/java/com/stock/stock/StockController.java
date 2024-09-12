package com.stock.stock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/create")
    public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDTO) {
        Stock stock = mapToEntity(stockDTO);
        stockService.createStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Stock>> listStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Stock> getStockDetail(@PathVariable Long id) {
        Stock stock = stockService.getStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody StockDTO stockDTO) {
        Stock stockDetails = mapToEntity(stockDTO);
        Stock updatedStock = stockService.updateStock(id, stockDetails);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Stock mapToEntity(StockDTO stockDTO) {
        return Stock.builder()
                .itemName(stockDTO.getItemName())
                .stockQuantity(stockDTO.getStockQuantity())
                .serialNumber(stockDTO.getSerialNumber())
                .additionalInfo(stockDTO.getAdditionalInfo())
                .imagePath(stockDTO.getImagePath())
                .build();
    }
}
