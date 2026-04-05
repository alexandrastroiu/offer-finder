import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {

    private int idOferta1;
    private int idOferta2;


    public Comparator() {
    }

    // Constructor cu parametri
    public Comparator(int idOferta1, int idOferta2) {
        this.idOferta1 = idOferta1;
        this.idOferta2 = idOferta2;
    }


    public int getIdOferta1() {
        return idOferta1;
    }

    public void setIdOferta1(int idOferta1) {
        this.idOferta1 = idOferta1;
    }

    public int getIdOferta2() {
        return idOferta2;
    }

    public void setIdOferta2(int idOferta2) {
        this.idOferta2 = idOferta2;
    }


    public void filtrareDistanta() {

        System.out.println("Filtrare dupa distanta executata.");
    }

    public List<Oferta> filtrareProcentReducere(List<Oferta> oferte, int pragMinim) {

        return oferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaMeniu) return ((OfertaMeniu) o).getReducere() >= pragMinim;
                    if (o instanceof OfertaProdus) return ((OfertaProdus) o).getReducere() >= pragMinim;
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<Restaurant> filtrareRecenzii(List<Restaurant> restaurante, float notaMinima) {

        return restaurante.stream()
                .filter(r -> r.getNotaMedie() >= notaMinima)
                .collect(Collectors.toList());
    }

    public void filtrarePret() {

        System.out.println("Filtrare dupa pret executata.");
    }


    public int comparaOferte(Oferta o1, Oferta o2) {

        this.idOferta1 = o1.getId();
        this.idOferta2 = o2.getId();


        return Integer.compare(this.idOferta1, this.idOferta2);
    }

    public Oferta selecteazaOferta(List<Oferta> oferte, int idCautat) {

        for (Oferta o : oferte) {
            if (o.getId() == idCautat) {
                return o;
            }
        }
        return null;
    }
}