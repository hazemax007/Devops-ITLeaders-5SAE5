package tn.esprit.rh.achat;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {
	
	//@InjectMocks
	//OperateurServiceImpl operateurService;
	
	@Autowired
	IOperateurService operateurService;
	
	//@Autowired
	@Mock
	OperateurRepository operatuerRepo;
	
	@Test
	public void addOperateurTestMock() {
		Operateur o = new Operateur(7L,"Ouanes","Nadia","123",null);
		//when(operatuerRepo.save(o)).thenReturn(o);
		assertEquals(o,operateurService.addOperateur(o));
	}
	
	@Test
	public void addOperateurTest() {
		
			Operateur o = new Operateur(6L,"Ouanes","Nadia","123",null);
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
		operateurService.deleteOperateur(6L);
		//assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	} 
}
