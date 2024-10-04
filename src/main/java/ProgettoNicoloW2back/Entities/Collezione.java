package ProgettoNicoloW2back.Entities;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> giochi = new ArrayList<>();

    public void aggiungiGioco(Gioco gioco) throws Exception {
        if (giochi.stream().anyMatch(g -> g.getId().equals(gioco.getId()))) {
            throw new Exception("Gioco con lo stesso ID già esistente.");
        } else {
            giochi.add(gioco);
        }
    }
}
