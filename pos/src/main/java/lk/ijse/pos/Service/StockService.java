package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    List<Stock> getAllStock();
    Stock getStockById(Long id);
    Stock createStock(Stock stock);
    void deleteStock(Long id);
    Stock updateStock(Long id,Stock stock);

    Stock findByItemId(Long id);
}
