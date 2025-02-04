import java.util.ArrayList;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Prodotto> carrello = new ArrayList<>();
        boolean haTessera = false;

        // Chiediamo se il cliente ha una tessera fedeltà
        System.out.print("Hai una tessera fedeltà (Sì/No)? ");
        String rispostaTessera = scanner.nextLine();
        if (rispostaTessera.equalsIgnoreCase("Sì")) {
            haTessera = true;
        }

        // Aggiungiamo prodotti al carrello
        boolean continua = true;
        while (continua) {
            System.out.println("Che tipo di prodotto vuoi inserire?");
            System.out.println("1. Smartphone");
            System.out.println("2. Televisore");
            System.out.println("3. Cuffie");
            System.out.print("Seleziona (1/2/3): ");
            
            // Gestione dell'input per la selezione del prodotto
            int scelta = 0;
            try {
                scelta = scanner.nextInt();
                scanner.nextLine();  // Pulisce il buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("Errore: devi inserire un numero valido!");
                scanner.nextLine(); // Pulisce il buffer dell'errore
                continue;
            }

            System.out.print("Inserisci il codice prodotto: ");
            int codice = scanner.nextInt();
            scanner.nextLine();  // Pulisce il buffer

            System.out.print("Inserisci il nome prodotto: ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci la marca prodotto: ");
            String marca = scanner.nextLine();

            System.out.print("Inserisci il prezzo prodotto: ");
            double prezzo = scanner.nextDouble();

            System.out.print("Inserisci la percentuale di IVA: ");
            double iva = scanner.nextDouble();
            scanner.nextLine();  // Pulisce il buffer

            Prodotto prodotto = null;

            switch (scelta) {
                case 1: // Smartphone
                    System.out.print("Inserisci il codice IMEI: ");
                    String imei = scanner.nextLine();
                    System.out.print("Inserisci la memoria (GB): ");
                    int memoria = scanner.nextInt();
                    scanner.nextLine();  // Pulisce il buffer
                    prodotto = new Smartphone(codice, nome, marca, prezzo, iva, imei, memoria);
                    break;
                case 2: // Televisore
                    System.out.print("Inserisci le dimensioni (pollici): ");
                    double dimensioni = scanner.nextDouble();
                    System.out.print("E' smart? (true/false): ");
                    boolean smart = scanner.nextBoolean();
                    scanner.nextLine();  // Pulisce il buffer
                    prodotto = new Televisore(codice, nome, marca, prezzo, iva, dimensioni, smart);
                    break;
                case 3: // Cuffie
                    System.out.print("Inserisci il colore: ");
                    String colore = scanner.nextLine();
                    System.out.print("Sono wireless? (true/false): ");
                    boolean wireless = scanner.nextBoolean();
                    scanner.nextLine();  // Pulisce il buffer
                    prodotto = new Cuffie(codice, nome, marca, prezzo, iva, colore, wireless);
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    continue;
            }

            // Aggiungiamo il prodotto al carrello
            carrello.add(prodotto);

            // Chiediamo se continuare ad aggiungere prodotti
            System.out.print("Vuoi aggiungere un altro prodotto? (Sì/No): ");
            String risposta = scanner.nextLine();  // Usa nextLine() per leggere la risposta
            if (risposta.equalsIgnoreCase("No")) {
                continua = false;
            }
        }

        // Stampa il carrello e calcola il totale
        double totale = 0;
        System.out.println("\nProdotti nel carrello:");
        for (Prodotto p : carrello) {
            System.out.println(p); // Mostra le informazioni del prodottsio
            totale += p.getPrezzoScontato(haTessera);
        }

        System.out.println("Totale carrello: " + totale + " (con sconto se applicabile)");
        scanner.close();
    }
}