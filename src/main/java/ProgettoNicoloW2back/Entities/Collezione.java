package ProgettoNicoloW2back.Entities;

import ProgettoNicoloW2back.Eccezioni.GiocoNonTrovato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Collezione {
    private List<Gioco> giochi = new ArrayList<>();

    // Creo il metodo per aggiungere un gioco
    public void aggiungiGioco(Gioco gioco) throws Exception {
        if (giochi.stream().anyMatch(g -> g.getId().equals(gioco.getId()))) {
            throw new Exception("Gioco con lo stesso ID già esistente.");
        } else {
            giochi.add(gioco);
        }
    }

    // Creo il metodo per ricercare un gioco per ID
    public Optional<Gioco> ricercaPerId(String id) throws GiocoNonTrovato {
        Optional<Gioco> giocoTrovato = giochi.stream().filter(g -> g.getId().equals(id)).findFirst();
        if (giocoTrovato.isEmpty()) {
            throw new GiocoNonTrovato("Nessun gioco trovato con ID :" + id);
        } else {
            return giocoTrovato;
        }

    }

    // Creo il metodo per ricercare giochi in base al prezzo
    public List<Gioco> ricercaPerPrezzo(double prezzo) throws GiocoNonTrovato {
        List<Gioco> giochiFiltratiPerPrezzo = new ArrayList<>();

        for (Gioco gioco : giochi) {
            if (gioco.getPrezzo() < prezzo) {
                giochiFiltratiPerPrezzo.add(gioco);
            } else {
                throw new GiocoNonTrovato("Nessun gioco trovato al di sotto del prezzo: " + prezzo);
            }
        }

        return giochiFiltratiPerPrezzo;
    }

    // Creo il metodo per ricercare giochi in base al numero di giocatori
    public List<GiocoDaTavolo> ricercaPerNumeroDiGiocatori(int numeroGiocatori) throws GiocoNonTrovato {
        List<GiocoDaTavolo> risultato = giochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumeroGiocatori() == numeroGiocatori)
                .collect(Collectors.toList());

        if (risultato.isEmpty()) {
            throw new GiocoNonTrovato("Nessun gioco da tavolo trovato con " + numeroGiocatori + " giocatori.");
        } else {
            return risultato;
        }

    }
    // Creo il metodo per rimuovere un gioco in base al suo id

    public Gioco rimuoviPerId(String id) throws GiocoNonTrovato {
        Optional<Gioco> rimozionePerId = giochi.stream().filter(gioco -> gioco.getId().equals(id)).findFirst();

        if (rimozionePerId.isPresent()) {
            Gioco giocoDaRimuovere = rimozionePerId.get();
            giochi.remove(giocoDaRimuovere);
            System.out.println("Gioco rimosso: " + giocoDaRimuovere.getTitolo());
            return giocoDaRimuovere;
        } else {
            throw new GiocoNonTrovato("Nessun gioco trovato con ID: " + id);
        }
    }

    public void stampaGiochi() {
        if (giochi.isEmpty()) {
            System.out.println("Nessun gioco presente nella collezione.");
        } else {
            giochi.forEach(gioco -> System.out.println("ID: " + gioco.getId() + ", Titolo: " + gioco.getTitolo()));
        }
    }

    public void aggiornaGioco(String id, Scanner scanner) throws GiocoNonTrovato {
        Optional<Gioco> giocoOptional = ricercaPerId(id);

        if (giocoOptional.isPresent()) {
            Gioco gioco = giocoOptional.get();
            System.out.println("Gioco trovato: " + gioco.getTitolo());

            System.out.print("Inserisci il nuovo Titolo: ");
            String nuovoTitolo = scanner.nextLine();
            gioco.setTitolo(nuovoTitolo);

            System.out.print("Inserisci il nuovo Anno: ");
            int nuovoAnno = Integer.parseInt(scanner.nextLine());
            gioco.setAnno(nuovoAnno);

            System.out.print("Inserisci il nuovo Prezzo: ");
            double nuovoPrezzo = Double.parseDouble(scanner.nextLine());
            gioco.setPrezzo(nuovoPrezzo);

            System.out.println("Gioco aggiornato con successo.");
        } else {
            System.out.println("Nessun gioco trovato con ID: " + id); // Debug
            throw new GiocoNonTrovato("Gioco non trovato con ID: " + id);
        }
    }
    
}
