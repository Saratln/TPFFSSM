/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sara Toulon
 */
public class FFSSMTest {

    public Embauche e;
    public Club c;
    public Moniteur m1, m2;
    public Plongeur p1, p2;
    public Plongee plongee1;
    public Site s;

    @BeforeEach
    public void setUp() {
        c = new Club(m1, "Castres club", "0725689633");
        e = new Embauche(LocalDate.of(1998, Month.NOVEMBER, 8), m1, c);
        m1 = new Moniteur(4590, "1478523698521", "Valard", "Sophie", "35 rue Alamandas", "0624157823", LocalDate.of(1978, Month.MARCH,19), GroupeSanguin.AMOINS);
        m2 = new Moniteur(5360, "1423697523001", "Papaya", "Florian", "55 rue des Mirambeaux", "0574123565", LocalDate.of(1997, Month.MAY, 8), GroupeSanguin.BPLUS);
        p1 = new Plongeur(3, c, 5502, "5214630277123", "Durand", "Paul", "18 avenue des Hibiscus", "0614752684", LocalDate.of(2000, Month.OCTOBER, 10), GroupeSanguin.APLUS);
        p2 = new Plongeur(2, c, 1880, "1234567891012", "Sanchez", "Mario", "3 rue Dubourg", "0663425896", LocalDate.of(1999, Month.FEBRUARY, 26), GroupeSanguin.APLUS);
        plongee1 = new Plongee(s, m1, LocalDate.of(2020, Month.DECEMBER, 11), 22, 95);
    }

    @Test
    public void employeurActuel() {
        m1.nouvelleEmbauche(c, LocalDate.now());
        assertEquals(c, m1.employeurActuel().get(), "L'employeur attendu n'est pas celui affiché");
    }
    
    @Test
    public void Embauche(){
        assertTrue(m1.emplois().isEmpty());
        m1.nouvelleEmbauche(c, LocalDate.now());
        assertTrue(!m1.emplois().isEmpty(), "L'embauche n'a pas été enregistrée");   
        // on ajoute une embauche et on termine la dernière
         m1.nouvelleEmbauche(c, LocalDate.of(2020, Month.MARCH, 15));
         m1.emplois().get(m1.emplois().size()-1).terminer(LocalDate.now());
         assertTrue(m1.emplois().get(m1.emplois().size()-1).estTerminee(), "L'embauche n'a pas pris fin");      
    }
    
    @Test
    public void ajouterPlongeeConformes() {
        // on vérifie que la liste est nulle
        assertTrue(c.listePlongees.isEmpty());
        // on organise une plongée et on vérifie qu'elle soit ajoutée à la liste
        c.organisePlongee(plongee1);
        assertFalse(c.listePlongees.isEmpty());
        // on ajoute des licences aux plongeurs
        p1.ajouteLicence("002", LocalDate.of(2020, Month.AUGUST, 18), c); //valide
        p2.ajouteLicence("001", LocalDate.of(2018, Month.JUNE, 2), c); // invalide             
        // AJOUT DES PLONGEURS
        // aucun plongeur
        assertTrue(plongee1.listePlongeurs.isEmpty());
        // on ajoute un plongeur avec la licence valide
        plongee1.ajouteParticipant(p1);
        assertFalse(plongee1.listePlongeurs.isEmpty());
        assertTrue(plongee1.estConforme());
        // on ajoute un plongeur avec la licence invalide
        plongee1.ajouteParticipant(p2);
        assertFalse(plongee1.estConforme());
        
        //  PLONGEES NON CONFORMES
        //
        
      
        
    }
    
}
