package ProgettoNicoloW2back.Entities;

import ProgettoNicoloW2back.Eccezioni.GiocoNonTrovato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
