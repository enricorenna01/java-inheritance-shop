public class Smartphone extends Prodotto {
    private String imei;
    private int memoria;

    // Costruttore
    public Smartphone(int codice, String nome, String marca, double prezzo, double iva, String imei, int memoria) {
        super(codice, nome, marca, prezzo, iva);
        this.imei = imei;
        this.memoria = memoria;
    }

    // Getter e Setter
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
            this.memoria = memoria;
    }

    //Metodi
    public double getPrezzoScontato(boolean haTessera) {
        double prezzoScontato = super.getPrezzoScontato(haTessera);
    
        if (memoria < 32) {
            prezzoScontato *= 0.95; // Sconto del 5%
        } else {
            prezzoScontato *= 0.98; // Sconto del 2%
        }

        return prezzoScontato;
    }

    @Override
    public String toString() {
        return super.toString() + ", IMEI: " + imei + ", Memoria: " + memoria + " GB";
    }
}
