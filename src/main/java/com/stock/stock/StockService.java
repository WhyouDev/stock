package com.stock.stock;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockService
{
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Stock not found"));
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Stock stock = getStockById(id);
        stock.setItemName(stockDetails.getItemName());
        stock.setStockQuantity(stockDetails.getStockQuantity());
        stock.setSerialNumber(stockDetails.getSerialNumber());
        stock.setAdditionalInfo(stockDetails.getAdditionalInfo());
        stock.setImagePath(stockDetails.getImagePath());
        stock.setUpdatedAt(stockDetails.getUpdatedAt());
        stock.setUpdatedBy(stockDetails.getUpdatedBy());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        Stock stock = getStockById(id);
        stockRepository.delete(stock);
    }
}
