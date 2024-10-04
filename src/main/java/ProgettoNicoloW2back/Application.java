package ProgettoNicoloW2back;

import ProgettoNicoloW2back.Entities.*;

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
        Optional<Gioco> risultato1 = collezione.ricercaPerId("2");
        if (risultato1.isPresent()) {
            System.out.println("Gioco trovato: " + risultato1.get().getTitolo());
        } else {
            System.out.println("Nessun gioco trovato con ID 2");
        }

    }
}
