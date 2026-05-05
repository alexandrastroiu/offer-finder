import java.util.ArrayList;
import java.util.List;
public class OfertaMeniu extends Oferta {
    private int reducere;
    private Meniu meniu;

    // constructori
    public OfertaMeniu(int reducere, Meniu meniu) {
        this.reducere = reducere;
        this.meniu = meniu;
    }

    public OfertaMeniu(int id, String denumire, int reducere, Meniu meniu) {
        super(id, denumire);
        this.reducere = reducere;
        this.meniu = meniu;
    }

    // getters si setters
    public int getReducere() {
        return reducere;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    // metode
    public float getPretRedusProdus(String numeProdus) {
        int size = this.meniu.getProduse().size();
        for(int i = 0; i < size; i ++) {
            if(this.meniu.getProduse().get(i).getDenumire().equals(numeProdus)) {
                float pret = this.meniu.getProduse().get(i).getPret();
                return pret - this.reducere * pret / 100;
            }
        }
        return (float)-1;
    }
}
