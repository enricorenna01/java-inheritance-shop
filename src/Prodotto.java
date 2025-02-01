import java.util.Random;

public class Prodotto {
    
    //Caratteristiche del prodotto
    int codice;
    String nome;
    String marca;
    double prezzo;
    double iva;


    //Costruttore
    public Prodotto(int codece, String nome, String marca, double prezzo, double iva){
        Random rand = new Random();
        this.codice = rand.nextInt(999999);
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }
    
    // Getter e Setter
    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
    //Metodi
        public double getPrezzoBase(){
        return this.prezzo;
    }

    public double getPrezzoIva(){
        return prezzo * (1 + iva / 100);
    }

    public double getPrezzoScontato(boolean haTessera) {
        double prezzoScontato = prezzo;

        if (haTessera) {
            prezzoScontato *= 0.98;
        }

        return prezzoScontato;
    }
}
