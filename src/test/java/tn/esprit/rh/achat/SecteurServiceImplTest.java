package tn.esprit.rh.achat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.ISecteurActiviteService;
import tn.esprit.rh.achat.services.IStockService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class SecteurServiceImplTest {

    @Autowired
    ISecteurActiviteService secteurActiviteService;

    @Test
    @Order(0)
    public void testAddSecteur() {

        Set<Fournisseur> h = new HashSet<>(Arrays.asList());

        SecteurActivite s = new SecteurActivite("11","33",h);
        SecteurActivite savedSecteurActivite = secteurActiviteService.addSecteurActivite(s);
        log.info(s.toString());
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }

    @Test
    @Order(1)
    public void testAddSecteurActiviteOptimized() {

        Set<Fournisseur> h = new HashSet<>(Arrays.asList());

        SecteurActivite s = new SecteurActivite("77","88",h);

        SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(s);
        assertNotNull(savedSecteurActivite.getIdSecteurActivite());
        assertSame("10", savedSecteurActivite.getLibelleSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }

    @Test
    @Order(2)
    public void testDeleteSecteurActivite() {

        Set<Fournisseur> h = new HashSet<>(Arrays.asList());

        SecteurActivite s = new SecteurActivite("10","100",h);

        SecteurActivite savedSecteurActivite = secteurActiviteService.addSecteurActivite(s);
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
    }



}
