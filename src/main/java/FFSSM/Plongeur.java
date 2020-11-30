package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Moniteur {

    private int niveau;
    public List<Licence> lesLicences = new ArrayList<>();

    public Plongeur(int niveau, Club club, int numeroDiplome, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin gs) {
        super(numeroDiplome, numeroINSEE, nom, prenom, adresse, telephone, naissance, gs);
        this.niveau = niveau;

    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        for (Licence l : lesLicences) {
            if (l.estValide(LocalDate.now())) {

                lesLicences.add(new Licence(this, numero, delivrance, niveau, club));
            }
        }
    }

    

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

}
