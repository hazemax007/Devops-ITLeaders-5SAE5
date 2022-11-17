package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {

		return stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		return stockRepository.findById(stockId).orElse(null);
	}

	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = stockRepository.retrieveStatusStock();
		for (Stock stock : stocksEnRouge) {
			finalMessage = newLine + finalMessage + msgDate + newLine + ": le stock "
					+ stock.getLibelleStock() + " a une quantité de " + stock.getQte()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stock.getQteMin()
					+ newLine;

		}
		return finalMessage;
	}

}