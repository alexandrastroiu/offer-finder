package clase;

public class OfertaProdus extends Oferta {
    private int reducere;
    private Produs produs;
    private float pretRedus;

    // constructori
    public OfertaProdus(int reducere) {
        this.produs = new Produs();
        this.reducere = reducere;
        this.pretRedus = this.produs.getPret() - this.reducere * this.produs.getPret() / 100;
    }

    public OfertaProdus(int id, String denumire, int reducere) {
        super(id, denumire);
        this.reducere = reducere;
        this.produs = new Produs();
        this.pretRedus = this.produs.getPret() - this.reducere * this.produs.getPret() / 100;
    }

    // getters si setters
    public int getReducere() {
        return reducere;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
        this.pretRedus = this.produs.getPret() - this.reducere * this.produs.getPret() / 100;
    }

    public float getPretRedus() {
        return pretRedus;
    }




}

