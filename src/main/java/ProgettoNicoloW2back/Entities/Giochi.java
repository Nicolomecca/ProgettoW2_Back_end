package ProgettoNicoloW2back.Entities;

public abstract class Giochi {
    private String id;
    private String titolo;
    private int anno;
    private double prezzo;

    public Giochi(String id, String titolo, int anno, double prezzo) {
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;
    }


    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
