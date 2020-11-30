/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Personne {

    List<Embauche> listeEmbauches = new ArrayList<>();
    public int numeroDiplome;

    public Moniteur(int numeroDiplome, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, gs);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        if (listeEmbauches.isEmpty());
        if (listeEmbauches.get(listeEmbauches.size() - 1).estTerminee());
        return Optional.ofNullable(listeEmbauches.get(listeEmbauches.size() - 1).getEmployeur());

    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        Embauche embauche = new Embauche(debutNouvelle, this, employeur);
        listeEmbauches.add(embauche);
    }

    public List<Embauche> emplois() {
        return listeEmbauches;
    }

}
