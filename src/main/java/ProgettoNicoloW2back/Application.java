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

        VideoGioco primoVideoGioco = new VideoGioco("1", "Uncharted", 1990, 20, "Epic Games",
                10, Genere.AZIONE);
        VideoGioco secondoVideoGioco = new VideoGioco("3", "The Legend of Zelda: Breath of the Wild", 2017, 59.99, "Nintendo",
                50, Genere.AVVENTURA);
        GiocoDaTavolo primoGiocoDaTavolo = new GiocoDaTavolo("2", "Monopoly", 1960, 35,
                6, 1);

        // inserisco nella collezione i giochi creati propagando l'eccezione e testo il metodo aggiungi
        try {
            collezione.aggiungiGioco(primoVideoGioco);
            System.out.println("VideoGioco  aggiunto con successo." + primoVideoGioco);
            collezione.aggiungiGioco(secondoVideoGioco);
            System.out.println("VideoGioco  aggiunto con successo." + secondoVideoGioco);
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
        scanner.nextLine();


        try {
            List<Gioco> giochiTrovati = collezione.ricercaPerPrezzo(prezzo);
            System.out.println("Giochi trovati con prezzo inferiore a " + prezzo + ":");
            for (Gioco gioco : giochiTrovati) {
                System.out.println(gioco.getTitolo() + " - Prezzo: " + gioco.getPrezzo());
            }
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }

        // Testo il metodo  per la ricerca Numero Di Giocatori
        System.out.print("Inserisci il numero di giocatori : ");
        int numeroGiocatori = scanner.nextInt();
        scanner.nextLine();


        try {
            List<GiocoDaTavolo> giochiTrovati = collezione.ricercaPerNumeroDiGiocatori(numeroGiocatori);
            System.out.println("Giochi da tavolo trovati per " + numeroGiocatori + " giocatori:");
            for (GiocoDaTavolo gioco : giochiTrovati) {
                System.out.println(gioco.getTitolo() + " - Numero di giocatori: " + gioco.getNumeroGiocatori());
            }
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }
        // Testo il metodo  per la rimozione tramite id

        try {
            Gioco giocoRimosso = collezione.rimuoviPerId("2");
            System.out.println("Gioco rimosso con successo: " + giocoRimosso.getTitolo());
            System.out.println("Lista aggiornata di giochi:");
            collezione.stampaGiochi();
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }

        // Testo  l'aggiornamento del gioco tramite id

        try {
            System.out.println(" aggiornamento gioco:");
            System.out.print("Inserisci l'ID del gioco da aggiornare: ");
            String idDaAggiornare = scanner.nextLine();
            collezione.aggiornaGioco(idDaAggiornare, scanner);
            System.out.println("Lista aggiornata");
            collezione.stampaGiochi();
        } catch (GiocoNonTrovato e) {
            System.out.println(e.getMessage());
        }
    }
}

