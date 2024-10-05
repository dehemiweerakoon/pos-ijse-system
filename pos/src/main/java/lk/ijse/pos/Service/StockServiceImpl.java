package lk.ijse.pos.Service;

import lk.ijse.pos.Entity.Item;
import lk.ijse.pos.Entity.Stock;
import lk.ijse.pos.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StockServiceImpl implements  StockService{
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(()->new NoSuchElementException("No such element"));
    }

    @Override
    public Stock createStock(Stock stock) {
        try{
            Stock stock1 = findByItemId(stock.getItem().getId());
            if(stock!=null){
                System.out.println(stock1.getId());
                stock1.setQuantity(stock.getQuantity()+stock1.getQuantity());
                return stockRepository.save(stock1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock updateStock(Long id,Stock stock) {
        Stock stock1 = getStockById(id);
        stock1.setItem(stock.getItem());
        stock1.setQuantity(stock.getQuantity());
        return stockRepository.save(stock1);
    }

    @Override
    public Stock findByItemId(Long id) {
        return stockRepository.findByItemId(id).orElseThrow(()-> new NoSuchElementException("There is no such item"));
    }
}
