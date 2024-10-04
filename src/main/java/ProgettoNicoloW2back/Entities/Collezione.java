package ProgettoNicoloW2back.Entities;

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
    public Optional<Gioco> ricercaPerId(String id) {
        return giochi.stream().filter(g -> g.getId().equals(id)).findFirst();
    }
}
