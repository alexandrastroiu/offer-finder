import java.util.ArrayList;
import java.util.List;

public class Restaurant {
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
    public Restaurant(String denumire, String adresaRestaurant, float oraDeshidere,
                      float oraInchidere, float notaMedie, SpecificRestaurant tip, Meniu meniu) {
        this.denumire = denumire;
        this.adresaRestaurant = adresaRestaurant;
        this.oraDeshidere = oraDeshidere;
        this.oraInchidere = oraInchidere;
        this.notaMedie = notaMedie;
        this.tip = tip;
        this.meniu = meniu;
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
    public void adaugareOferta(Oferta ofertaNoua) {
        if(ofertaNoua != null) {
            this.oferteValide.add(ofertaNoua);
        }
    }

    public void eleminareOfertaIndex(int i) {
        this.oferteValide.remove(i);
    }
}
