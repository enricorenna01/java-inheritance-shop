public class Televisore extends Prodotto {
    private double dimensioni;
    private boolean smart;

    // Costruttore
    public Televisore(int codice, String nome, String marca, double prezzo, double iva, double dimensioni, boolean smart) {
        super(codice, nome, marca, prezzo, iva);
        this.dimensioni = dimensioni;
        this.smart = smart;
    }

    // Getter e Setter
    public double getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(double dimensioni) {
        this.dimensioni = dimensioni;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    // Metodi
    public double getPrezzoScontato(boolean haTessera) {
        double prezzoScontato = super.getPrezzoScontato(haTessera);

        if (!smart) {
            prezzoScontato *= 0.90; // Sconto del 10%
        } else {
            prezzoScontato *= 0.98; // Sconto del 2%
        }

        return prezzoScontato;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dimensioni: " + dimensioni + " pollici, Smart: " + (smart ? "Sì" : "No");
    }
}