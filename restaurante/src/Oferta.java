public class Oferta {
    private int id;
    private String denumire;

    // constructori
    public Oferta() {}
    public Oferta(int id, String denumire) {
        this.id = id;
        this.denumire = denumire;
    }

    // getters si setters
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

    // metode

}
