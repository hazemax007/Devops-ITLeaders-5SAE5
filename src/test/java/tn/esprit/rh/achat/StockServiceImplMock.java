package tn.esprit.rh.achat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    Stock s = new Stock("stock test",10,100);
/*
    List<Stock> stockList = new ArrayList<>(){

    }
*/
}
