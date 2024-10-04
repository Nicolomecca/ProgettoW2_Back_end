package ProgettoNicoloW2back;

import ProgettoNicoloW2back.Entities.Collezione;
import ProgettoNicoloW2back.Entities.Genere;
import ProgettoNicoloW2back.Entities.GiocoDaTavolo;
import ProgettoNicoloW2back.Entities.VideoGioco;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        VideoGioco primoVideoGioco = new VideoGioco("1", "Unchurted", 1990, 20, "Epic Games",
                10, Genere.AZIONE);
        GiocoDaTavolo primoGiocoDaTavolo = new GiocoDaTavolo("2", "Monopoly", 1960, 35,
                6, 1);

        // inserisco nella collezione i giochi creati propagando l'eccezione
        try {
            collezione.aggiungiGioco(primoVideoGioco);
            System.out.println("VideoGioco  aggiunto con successo." + primoVideoGioco);
            collezione.aggiungiGioco(primoGiocoDaTavolo);
            System.out.println("Gioco da tavolo aggiunto con successo." + primoGiocoDaTavolo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
