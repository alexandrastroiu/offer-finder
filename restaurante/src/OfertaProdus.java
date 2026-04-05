public class OfertaProdus extends Oferta {
    private int reducere;
    private Produs produs;

    // constructori
    public OfertaProdus(int reducere) {
        this.produs = new Produs();
        this.reducere = reducere;
    }

    public OfertaProdus(int id, String denumire, int reducere) {
        super(id, denumire);
        this.reducere = reducere;
        this.produs = new Produs();
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
    }

    // metode


}

