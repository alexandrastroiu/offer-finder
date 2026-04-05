public class OfertaMeniu extends Oferta {
    private int reducere;


    // constructori
    public OfertaMeniu(int reducere) {
        this.reducere = reducere;
    }

    public OfertaMeniu(int id, String denumire, int reducere) {
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
