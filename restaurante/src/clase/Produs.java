package clase;

public class Produs {

    private int id;
    private String denumire;
    private float pret;
    private String descriere;
    private float calorii;

    // constructori
    public Produs(int id, String denumire, float pret, String descriere, float calorii) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
        this.descriere = descriere;
        this.calorii = calorii;
    }

    public Produs() {}

    // getteri si setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public float getCalorii() {
        return calorii;
    }

    public void setCalorii(float calorii) {
        this.calorii = calorii;
    }

    // metode

}
