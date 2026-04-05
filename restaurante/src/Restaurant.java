import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String denumire;
    private String adresaRestaurant;
    private float oraDeshidere;
    private float oraInchidere;
    private float notaMedie;
    private SpecificRestaurant tip;
    private Meniu meniu;
    private List<Oferta> oferteValide;

    // constructori
    public Restaurant() {}
    public Restaurant(int id, String denumire, String adresaRestaurant, float oraDeshidere,
                      float oraInchidere, float notaMedie, SpecificRestaurant tip, int idMeniu) {
        this.id = id;
        this.denumire = denumire;
        this.adresaRestaurant = adresaRestaurant;
        this.oraDeshidere = oraDeshidere;
        this.oraInchidere = oraInchidere;
        this.notaMedie = notaMedie;
        this.tip = tip;
        this.meniu = new Meniu(idMeniu);
        this.oferteValide = new ArrayList<>();
    }

    // geters si setters
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresaRestaurant() {
        return adresaRestaurant;
    }

    public void setAdresaRestaurant(String adresaRestaurant) {
        this.adresaRestaurant = adresaRestaurant;
    }

    public float getOraDeshidere() {
        return oraDeshidere;
    }

    public void setOraDeshidere(float oraDeshidere) {
        this.oraDeshidere = oraDeshidere;
    }

    public float getOraInchidere() {
        return oraInchidere;
    }

    public void setOraInchidere(float oraInchidere) {
        this.oraInchidere = oraInchidere;
    }

    public float getNotaMedie() {
        return notaMedie;
    }

    public void setNotaMedie(float notaMedie) {
        this.notaMedie = notaMedie;
    }

    public SpecificRestaurant getTip() {
        return tip;
    }

    public void setTip(SpecificRestaurant tip) {
        this.tip = tip;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    public List<Oferta> getOferteValide() {
        return oferteValide;
    }

    public void setOferteValide(List<Oferta> oferteValide) {
        this.oferteValide = oferteValide;
    }

    // metode

    // afisare oferte
    public void afisareOferte() {
        System.out.println("Oferte: ");
        for(int i = 0; i < this.oferteValide.size(); i ++) {
            System.out.println((i + 1) + ". " + this.oferteValide.get(i).getDenumire());
            String cls = String.valueOf(this.oferteValide.get(id));
            switch (cls) {
                case "OfertaMeniu":
                    OfertaMeniu ofertaMeniu = (OfertaMeniu) this.oferteValide.get(i);
                    System.out.println("Procent reducere: " + ofertaMeniu.getReducere());
                    break;
                case "OfertaProdus":
                    OfertaProdus ofertaProdus = (OfertaProdus) this.oferteValide.get(i);
                    System.out.println("Procent reducere: " + ofertaProdus.getReducere() + " la produsul " + ofertaProdus.getProdus().getDenumire());
                    break;
                case "OfertaCombo":
                    OfertaCombo ofertaCombo = (OfertaCombo) this.oferteValide.get(i);
                    System.out.println("Pret combo: " + ofertaCombo.getPretCombo());
                    System.out.println("Produse participante: ");
                    for (int j = 0; j < ofertaCombo.getProduseParticipante().size(); j++) {
                        System.out.println((i + 1) + ". " + ofertaCombo.getProduseParticipante().get(j).getDenumire());
                    }
                    break;
            }
            System.out.println("....................................................................................");
        }
        System.out.println("Pofta buna!");
    }

    //adaugare oferta
    public void adaugareOferta(Oferta ofertaNoua) {
        String cls = cls = String.valueOf(ofertaNoua);
        if(ofertaNoua != null) {
            this.oferteValide.add(ofertaNoua);
            if (cls.equals("OfertaMeniu")) {
                OfertaMeniu ofertaMeniu = (OfertaMeniu) ofertaNoua;
                for (int i = 0; i < this.meniu.getProduse().size(); i++) {
                    float pretNou = this.meniu.getProduse().get(i).getPret() - ofertaMeniu.getReducere() / 100 * this.meniu.getProduse().get(i).getPret();
                    this.meniu.getProduse().get(i).setPret(pretNou);
                }
            } else if (cls.equals("OfertaProdus")) {
                OfertaProdus ofertaProdus = (OfertaProdus) ofertaNoua;
                int i = this.meniu.getProduse().indexOf(ofertaProdus.getProdus());
                float pretVechi = ofertaProdus.getProdus().getPret() - ofertaProdus.getReducere() / 100 * this.meniu.getProduse().get(i).getPret();
                this.meniu.getProduse().get(i).setPret(pretVechi);
            }
        }
    }

    // eliminare oferta dupa id
    public void eleminareOfertaId(int id) {
        String cls = "";
        Oferta oferta = null;
        oferta = this.oferteValide.get(id);
        cls = String.valueOf(oferta);

        if(cls.equals("OfertaMeniu")) {
            OfertaMeniu ofertaMeniu = (OfertaMeniu)oferta;
            for(int i = 0; i < this.meniu.getProduse().size(); i ++) {
                float pretVechi =  100 * this.meniu.getProduse().get(i).getPret() / (100 - ofertaMeniu.getReducere()) ;
                this.meniu.getProduse().get(i).setPret(pretVechi);
            }
        }
        else if(cls.equals("OfertaProdus")) {
            OfertaProdus ofertaProdus = (OfertaProdus)oferta;
            float pretVechi =  100 * ofertaProdus.getProdus().getPret() / (100 - ofertaProdus.getReducere());
            int i = this.meniu.getProduse().indexOf(ofertaProdus.getProdus());
            this.meniu.getProduse().get(i).setPret(pretVechi);
        }
        this.oferteValide.remove(id);
    }

    // eliminare oferta dupa nume
    public void eleminareOfertaNume(String nume) {
        String cls = "";
        Oferta oferta = null;
        for(int i = 0; i < this.oferteValide.size(); i ++) {
            if(this.oferteValide.get(i).getDenumire().equals(nume)) {
                oferta = this.oferteValide.get(i);
                cls = String.valueOf(oferta);
                i = this.oferteValide.size();
            }
        }

        if(cls.equals("OfertaMeniu")) {
            OfertaMeniu ofertaMeniu = (OfertaMeniu)oferta;
            for(int i = 0; i < this.meniu.getProduse().size(); i ++) {
                float pretVechi =  100 * this.meniu.getProduse().get(i).getPret() / (100 - ofertaMeniu.getReducere()) ;
                this.meniu.getProduse().get(i).setPret(pretVechi);
            }
        }
        else if(cls.equals("OfertaProdus")) {
            OfertaProdus ofertaProdus = (OfertaProdus)oferta;
            float pretVechi =  100 * ofertaProdus.getProdus().getPret() / (100 - ofertaProdus.getReducere());
            int i = this.meniu.getProduse().indexOf(ofertaProdus.getProdus());
            this.meniu.getProduse().get(i).setPret(pretVechi);
        }
        this.oferteValide.removeIf(of -> (of.getDenumire().equals(nume)));
    }


}
