public class OfertaProdus extends Oferta {
    private int reducere;


    // constructori
    public OfertaProdus(int reducere) {
        this.reducere = reducere;
    }

    public OfertaProdus(int id, String denumire, int reducere) {
        super(id, denumire);
        this.reducere = reducere;
    }

    // getters si setters
    public int getReducere() {
        return reducere;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    // metode



}

