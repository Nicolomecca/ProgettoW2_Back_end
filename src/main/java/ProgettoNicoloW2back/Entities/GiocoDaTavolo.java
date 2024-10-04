package ProgettoNicoloW2back.Entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String id, String titolo, int anno, double prezzo,
                         int numeroGiocatori, int durataMediaPartita) {
        super(id, titolo, anno, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "id='" + getId() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", anno=" + getAnno() +
                ", prezzo=" + getPrezzo() +
                ", numeroGiocatori=" + numeroGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}
