package ProgettoNicoloW2back;

import ProgettoNicoloW2back.Eccezioni.GiocoNonTrovato;
import ProgettoNicoloW2back.Entities.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Collezione collezione = new Collezione();

        VideoGioco primoVideoGioco = new VideoGioco("1", "Unchurted", 1990, 20, "Epic Games",
                10, Genere.AZIONE);
        GiocoDaTavolo primoGiocoDaTavolo = new GiocoDaTavolo("2", "Monopoly", 1960, 35,
                6, 1);

        // inserisco nella collezione i giochi creati propagando l'eccezione e testo il metodo aggiungi
        try {
            collezione.aggiungiGioco(primoVideoGioco);
            System.out.println("VideoGioco  aggiunto con successo." + primoVideoGioco);
            collezione.aggiungiGioco(primoGiocoDaTavolo);
            System.out.println("Gioco da tavolo aggiunto con successo." + primoGiocoDaTavolo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // testo il metodo di  ricerca attraverso id
        try {
            Optional<Gioco> risultato = collezione.ricercaPerId("2");
            risultato.ifPresent(gioco -> System.out.println("Gioco trovato: " + gioco.getTitolo()));
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }

        // testo il metodo per la ricerca con il criterio del  prezzo
        System.out.print("Inserisci il prezzo massimo per la ricerca: ");

        double prezzo = scanner.nextDouble();

        try {
            List<Gioco> giochiTrovati = collezione.ricercaPerPrezzo(prezzo);
            System.out.println("Giochi trovati con prezzo inferiore a " + prezzo + ":");
            for (Gioco gioco : giochiTrovati) {
                System.out.println(gioco.getTitolo() + " - Prezzo: " + gioco.getPrezzo());
            }
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }

    }
}
