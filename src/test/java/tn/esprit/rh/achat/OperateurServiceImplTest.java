package tn.esprit.rh.achat;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {
	
	@InjectMocks
	OperateurServiceImpl operateurService;
	@Mock
	OperateurRepository operateurRepo;
	
	@Test
	public void addOperateurTestMock() {
		
	        Operateur o = new Operateur();
	        o.setIdOperateur(9L);
	        o.setNom("Ouannes");
	        o.setPrenom("Nadia");
	        o.setPassword("123");
	        when(operateurRepo.save(ArgumentMatchers.any(Operateur.class))).thenReturn(o);
	        assertSame(operateurService.addOperateur(o), o);
	        verify(operateurRepo).save(o);
	}
	
	@Test
	public void retrieveAllOperateursTestMock() {

		Operateur o1 = new Operateur(7L,"Ouanes","Nadia","123",null);
		Operateur o2 = new Operateur(8L,"Ouanes","Syrine","123",null);
        List<Operateur> listOperateurs = new ArrayList<Operateur>();
        listOperateurs.add(o1);
        listOperateurs.add(o2);
        BDDMockito.given(operateurRepo.findAll()).willReturn(listOperateurs);
        List<Operateur> expected = operateurService.retrieveAllOperateurs();
        assertEquals(listOperateurs, expected);
        verify(operateurRepo).findAll();

    }
	
	@Test
	public void deleteOperateurTestMock() {

		Operateur o = new Operateur(8L,"Ouanes","Nadia","123",null);
     
        when(operateurRepo.findById(o.getIdOperateur())).thenReturn(Optional.of(o));
        operateurService.deleteOperateur(o.getIdOperateur());
        verify(operateurRepo).deleteById(o.getIdOperateur());

    }
	
	@Test
	public void retrieveOperateurTestMock() {

		Operateur o = new Operateur(8L,"Ouanes","Nadia","123",null);
		
        when(operateurRepo.findById(o.getIdOperateur())).thenReturn(Optional.of(o));

        assertSame(operateurService.retrieveOperateur(o.getIdOperateur()),o);
        verify(operateurRepo).findById(o.getIdOperateur());

    }
	
}
