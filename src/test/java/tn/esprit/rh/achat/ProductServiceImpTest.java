package tn.esprit.rh.achat;


import static org.junit.Assert.*;
        import static org.mockito.Mockito.verify;
        import static org.mockito.Mockito.when;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

        import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
        import org.mockito.ArgumentMatchers;
        import org.mockito.BDDMockito;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.test.context.junit4.SpringRunner;

        import tn.esprit.rh.achat.entities.Produit;
        import tn.esprit.rh.achat.entities.Stock;
        import tn.esprit.rh.achat.repositories.ProduitRepository;
        import tn.esprit.rh.achat.repositories.StockRepository;
        import tn.esprit.rh.achat.services.ProduitServiceImpl;
        import tn.esprit.rh.achat.services.StockServiceImpl;

@RunWith(SpringRunner.class)
public class ProductServiceImpTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    //NewProject



    @Test
    @Order(0)
    public void addProduitTest() {

        Produit p = new Produit();
        p.setCodeProduit("123");
        p.setLibelleProduit("Tunis");
        p.setPrix(1000);
        p.setDateCreation(new Date());
        p.setDateDerniereModification(new Date());

        when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(p);
        Produit created = produitService.addProduit(p);
        assertSame(created, p);
        verify(produitRepository).save(p);

    }

    @Test
    @Order(1)
    public void retrieveAllProduitsTest() {

        Produit p1 = new Produit();
        p1.setCodeProduit("123");
        p1.setLibelleProduit("tunis");
        p1.setPrix(1000);
        p1.setDateCreation(new Date());
        p1.setDateDerniereModification(new Date());

        Produit p2 = new Produit();
        p1.setCodeProduit("999");
        p1.setLibelleProduit("Milk");
        p1.setPrix(3000);
        p1.setDateCreation(new Date());
        p1.setDateDerniereModification(new Date());

        List<Produit> listProds = new ArrayList<Produit>();
        listProds.add(p1);
        listProds.add(p2);

        BDDMockito.given(produitRepository.findAll()).willReturn(listProds);

        List<Produit> expected = produitService.retrieveAllProduits();

        assertEquals(listProds, expected);
        verify(produitRepository).findAll();

    }

    @Test
    @Order(2)
    public void deleteProduitTest() {

        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setCodeProduit("123");
        p.setLibelleProduit("tunis");
        p.setPrix(1000);
        p.setDateCreation(new Date());
        p.setDateDerniereModification(new Date());

        when(produitRepository.findById(p.getIdProduit())).thenReturn(Optional.of(p));
        produitService.deleteProduit(p.getIdProduit());
        verify(produitRepository).deleteById(p.getIdProduit());

    }


    @Test
    @Order(3)
    public void updateProduitTest() {

        Produit Prod = new Produit();
        Prod.setIdProduit(1L);
        Prod.setCodeProduit("123");
        Prod.setLibelleProduit("Tunis");
        Prod.setPrix(1000);
        Prod.setDateCreation(new Date());
        Prod.setDateDerniereModification(new Date());

        Produit NewProd = new Produit();
        NewProd.setIdProduit(2L);
        NewProd.setCodeProduit("999");
        NewProd.setLibelleProduit("Milk");
        NewProd.setPrix(1000);
        NewProd.setDateCreation(new Date());
        NewProd.setDateDerniereModification(new Date());
        when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(Prod);
        Produit UpdatedProd = produitService.addProduit(NewProd);
        assertEquals(Prod.getIdProduit(), UpdatedProd.getIdProduit());
        verify(produitRepository).save(NewProd);
    }

    @Test
    @Order(4)
    public void retrieveProduitTest () {

        Produit Prod = new Produit();
        Prod.setIdProduit(1L);
        Prod.setCodeProduit("123");
        Prod.setLibelleProduit("Bread");
        Prod.setPrix(2000);
        Prod.setDateCreation(new Date());
        Prod.setDateDerniereModification(new Date());

        when(produitRepository.findById(Prod.getIdProduit())).thenReturn(Optional.of(Prod));

        Produit expectedProd = produitService.retrieveProduit(Prod.getIdProduit());

        assertSame(expectedProd, Prod);
        verify(produitRepository).findById(Prod.getIdProduit());


    }

    @Test
    public void assignProduitToStockTest () {

        Stock S = new Stock();
        S.setIdStock(1L);
        S.setLibelleStock("test");
        S.setQte(1000);
        S.setQteMin(500);

        Produit Prod = new Produit();
        Prod.setIdProduit(1L);
        Prod.setCodeProduit("123");
        Prod.setLibelleProduit("Tunis");
        Prod.setPrix(1000);
        Prod.setDateCreation(new Date());
        Prod.setDateDerniereModification(new Date());

        when(produitRepository.findById(Prod.getIdProduit())).thenReturn(Optional.of(Prod));
        when(stockRepository.findById(S.getIdStock())).thenReturn(Optional.of(S));

        produitService.assignProduitToStock(Prod.getIdProduit(), S.getIdStock());

        assertSame(Prod.getStock(), S);
        verify(produitRepository).findById(Prod.getIdProduit());
        verify(stockRepository).findById(S.getIdStock());



    }


}