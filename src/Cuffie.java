public class Cuffie extends Prodotto {
    private String colore;
    private boolean wireless;

    // Costruttore
    public Cuffie(int codice, String nome, String marca, double prezzo, double iva, String colore, boolean wireless) {
        super(codice, nome, marca, prezzo, iva);
        this.colore = colore;
        this.wireless = wireless;
    }

    // Getter e Setter
    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    // Metodi
    public double getPrezzoScontato(boolean haTessera) {
        double prezzoScontato = super.getPrezzoScontato(haTessera);

        if (!wireless) {
            prezzoScontato *= 0.93; // Sconto del 7%
        } else {
            prezzoScontato *= 0.98; // Sconto del 2%
        }

        return prezzoScontato;
    }
}