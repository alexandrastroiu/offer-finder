import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {


    private List<Restaurant> restaurante;
    private List<Oferta> listaOferte;

    public Comparator() {
        this.restaurante = new ArrayList<>();
        this.listaOferte = new ArrayList<>();
    }

    public Comparator(List<Restaurant> restaurante) {
        this.restaurante = restaurante;
        this.listaOferte = extrageToateOfertele();
    }

    public List<Restaurant> getRestaurante() { return restaurante; }

    public void setRestaurante(List<Restaurant> restaurante) {
        this.restaurante = restaurante;
        this.listaOferte = extrageToateOfertele();
    }

    public List<Oferta> getListaOferte() { return listaOferte; }

    public void setListaOferte(List<Oferta> listaOferte) {
        this.listaOferte = listaOferte;
    }

    public List<Restaurant> filtrareDistanta(float distantaMax) {
        return this.restaurante.stream()
                .filter(r -> r.getDistanta() <= distantaMax)
                .collect(Collectors.toList());
    }

    public List<Restaurant> filtrareRecenzii(float notaMinima) {
        return this.restaurante.stream()
                .filter(r -> r.getNotaMedie() >= notaMinima)
                .collect(Collectors.toList());
    }

    public List<Oferta> filtrareProcentReducere(int pragMinim) {
        return this.listaOferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaMeniu) return ((OfertaMeniu) o).getReducere() >= pragMinim;
                    if (o instanceof OfertaProdus) return ((OfertaProdus) o).getReducere() >= pragMinim;
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<Oferta> filtrarePret(float pretMax) {
        List<Oferta> oferte = this.listaOferte;
        return oferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaMeniu)
                    {
                        OfertaMeniu ofertaMeniu = (OfertaMeniu) o;
                        int size = ofertaMeniu.getMeniu().getProduse().size();
                        for(int i = 0; i < size; i ++) {
                            if(ofertaMeniu.getMeniu().getProduse().get(i).getPret() <= pretMax) return true;
                            else return false;
                        }
                    }
                    if (o instanceof OfertaProdus) return ((OfertaProdus) o).getPretRedus() <= pretMax;
                    if (o instanceof OfertaCombo) return ((OfertaCombo) o).getPretCombo() <= pretMax;
                    return true;
                })
                .collect(Collectors.toList());
    }

    public List<Restaurant> cautaRestaurant(String nume) {
        return restaurante.stream()
                .filter(r -> r.getDenumire().equalsIgnoreCase(nume))
                .collect(Collectors.toList());
    }

    public List<Produs> cautaProdus(String numeProdus) {
        List<Produs> gasite = new ArrayList<>();
        for (Restaurant r : restaurante) {
            for (Produs p : r.getMeniu().getProduse()) {
                if (p.getDenumire().equalsIgnoreCase(numeProdus)) gasite.add(p);
            }
        }
        return gasite;
    }

    public Oferta selecteazaOferta(int id) {
        for (Oferta o : this.listaOferte) {
            if (o.getId() == id) return o;
        }
        return null;
    }

    public float getPretDinOferta(Oferta oferta) {
        float pret = 0f;
        if(oferta instanceof OfertaProdus) pret = ((OfertaProdus) oferta).getPretRedus();
        else if(oferta instanceof OfertaCombo) pret = ((OfertaCombo) oferta).getPretCombo();
        else pret = (float) -1;
        return pret;
    }

    public String priceToString(Oferta oferta) {
        if(getPretDinOferta(oferta) > 0.0) {
            return String.valueOf(getPretDinOferta(oferta));
        }
        else {
            return "-";
        }
    }

    public int getReducereDinOferta(Oferta oferta) {
        int reducere;
        if(oferta instanceof OfertaProdus) reducere = ((OfertaProdus) oferta).getReducere();
        else if(oferta instanceof OfertaMeniu) reducere = ((OfertaMeniu) oferta).getReducere();
        else reducere = -1;
        return reducere;
    }

    public String reducereToString(Oferta oferta) {
        if(getReducereDinOferta(oferta) > 0) {
            return String.valueOf(getReducereDinOferta(oferta));
        }
        else {
            return "-";
        }
    }

    public void comparaOferte(Restaurant r1, Oferta o1, Restaurant r2, Oferta o2) {
        int totalO1 = 0, totalO2 = 0;

        String[] headers = {"Distanta", "Pret", "Reducere", "Recenzii"};
        String dist1 = String.valueOf(r1.getDistanta());
        String dist2 = String.valueOf(r2.getDistanta());

        String rec1 = String.valueOf(r1.getNotaMedie());
        String rec2 = String.valueOf(r2.getNotaMedie());

        String pret1 = priceToString(o1);
        String pret2 = priceToString(o2);

        String red1 = reducereToString(o1);
        String red2 = reducereToString(o2);

        String rDist;
        if(r1.getDistanta() > r2.getDistanta()) {
            rDist = "Oferta 2";
            totalO2 ++;
        }
        else if(r1.getDistanta() < r2.getDistanta()){
            rDist = "Oferta 1";
            totalO1 ++;
        }
        else {
            rDist = "Egale";
        }

        String rPret;
        if(getPretDinOferta(o1) < 0 || getPretDinOferta(o2) < 0) rPret = "-";
        else if (getPretDinOferta(o1) < getPretDinOferta(o2)) {
            rPret = "Oferta 1";
            totalO1 ++;
        }
        else if (getPretDinOferta(o1) > getPretDinOferta(o2))  {
            rPret = "Oferta 2";
            totalO2 ++;
        }
        else {
            rPret = "Egale";
        }

        String rRed;
        if(getReducereDinOferta(o1) < 0 || getReducereDinOferta(o2) < 0) rRed = "-";
        else if (getReducereDinOferta(o1) < getReducereDinOferta(o2)) {
            rRed = "Oferta 1";
            totalO1 ++;
        }
        else if (getReducereDinOferta(o1) > getReducereDinOferta(o2)){
            rRed = "Oferta 2";
            totalO2 ++;
        }
        else {
            rRed = "Egale";
        }

        String rRec;
        if(r1.getNotaMedie() > r2.getNotaMedie()) {
            rRec = "Oferta 1";
            totalO1 ++;
        }
        else if(r1.getNotaMedie() < r2.getNotaMedie()) {
            rRec = "Oferta 2";
            totalO2 ++;
        }
        else {
            rRec = "Egale";
        }

        String[][] data = {
                {dist1, pret1, red1, rec1},
                {dist2, pret2, red2, rec2},
                {rDist, rPret, rRed, rRec}
        };

        System.out.printf("%-9s %-5s %-9s %-9s%n", headers[0], headers[1], headers[2], headers[3]);

        for (String[] row : data) {
            System.out.printf("%-9s %-9s %-9s %-9s%n", row[0], row[1], row[2], row[3]);
        }

        if(totalO2 > totalO1)
            System.out.println("Oferta 2 este mai avantajoasa");
        else if(totalO2 < totalO1) System.out.println("Oferta 1 este mai avantajoasa");
        else System.out.println("Ambele oferte sunt avantajoase");
    }

    private List<Oferta> extrageToateOfertele() {
        List<Oferta> toateOfertele = new ArrayList<>();
        if (this.restaurante == null) return toateOfertele;
        for (Restaurant r : this.restaurante) {
            if (r.getOferteValide() != null) toateOfertele.addAll(r.getOferteValide());
        }
        return toateOfertele;
    }
}


