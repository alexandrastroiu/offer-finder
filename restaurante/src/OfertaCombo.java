import java.util.ArrayList;
import java.util.List;
public class OfertaCombo {
    private float pretCombo;
    private List<Produs> produseParticipante;

    // constructori
    public  OfertaCombo() {}
    public OfertaCombo(float pretCombo, List<Produs> produseParticipante) {
        this.pretCombo = pretCombo;
        this.produseParticipante = produseParticipante;
    }

    public OfertaCombo(float pretCombo) {
        this.pretCombo = pretCombo;
        this.produseParticipante = new ArrayList<>();
    }

    // getters si setters
    public float getPretCombo() {
        return pretCombo;
    }

    public void setPretCombo(float pretCombo) {
        this.pretCombo = pretCombo;
    }

    public List<Produs> getProduseParticipante() {
        return produseParticipante;
    }

    public void setProduseParticipante(List<Produs> produseParticipante) {
        this.produseParticipante = produseParticipante;
    }

    // metode
    public void adaugareProdus(Produs produsNou) {
        if(produsNou != null) {
            this.produseParticipante.add(produsNou);
        }
    }

    public void eleminareProdusIndex(int i) {
        this.produseParticipante.remove(i);
    }

}
