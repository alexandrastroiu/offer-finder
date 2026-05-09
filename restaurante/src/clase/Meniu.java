package clase;

import java.util.ArrayList;
import java.util.List;

public class Meniu {
    private int id;
    private List<Produs> produse;

    // constructori
    public Meniu() {}

    public Meniu(int id) {
        this.id = id;
        this.produse = new ArrayList<>();
    }

    // getters si setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    // metode

    // adauga produs
    public void adaugaProdus(Produs produs) {
        this.produse.add(produs);
    }

    // elimina produs dupa nume
    public void eliminaProdusNume(String nume) {
        this.produse.removeIf(p -> (p.getDenumire().equals(nume)));
    }

    // elimina produs dupa id
    public void eliminaProdusId(int id) {
        for(int i = 0; i < this.produse.size(); i ++) {
            if(this.produse.get(i).getId() == id)
                this.produse.remove(i);
        }
    }

    // afiseaza meniu
    public void afisareMeniu() {
        System.out.println("clase.Meniu: ");
        for(int i = 0; i < this.produse.size(); i ++) {
            System.out.println((i + 1) + ". " + this.produse.get(i).getDenumire() + "..........................." + this.produse.get(i).getPret());
        }
        System.out.println("Pofta buna!");
    }

}
