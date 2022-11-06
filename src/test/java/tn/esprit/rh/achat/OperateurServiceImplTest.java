package tn.esprit.rh.achat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
	
	@Autowired
	IOperateurService operateurService;
	
	@Autowired
	OperateurRepository operatuerRepo;
	
	@Test
	public void addOperateurTest() {
		
			Operateur o = new Operateur(5L,"Ouanes","Nadia","123",null);
			Operateur savedOperateur= operateurService.addOperateur(o);
			assertNotNull(savedOperateur.getNom());
			assertNotNull(savedOperateur.getPrenom());
			assertNotNull(savedOperateur.getPassword());
	}
	
	@Test
	public void retrieveAllOperateursTest() {
		operateurService.retrieveAllOperateurs();
	}
	
	@Test
	public void retrieveOperateurTest() {
		operateurService.retrieveOperateur(1L);
	}
	
	@Test
	public void deleteOperateurTest() {
		//Stock s = new Stock("stock test",30,60);
		//Stock savedStock= stockService.addStock(s);
		operateurService.deleteOperateur(1L);
		//assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
}
