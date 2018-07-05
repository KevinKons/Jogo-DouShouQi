package controller.Command;

import model.Peca;
import model.Tabuleiro;

/**
 *
 * @author Avell
 */
public class Atacar implements Command {

    private Peca peca;

    public Atacar(Peca peca) {
        this.peca = peca;
    }
    
    @Override
    public void execute(int y, int x) throws Exception {
        Peca pecaDefensora = Tabuleiro.getInstance().getTerreno(y, x).getPeca();
        if(peca.getForca() >= pecaDefensora.getForca()) {
            peca.atacar(pecaDefensora);
        } else if(peca.getNome().equalsIgnoreCase("rato") && pecaDefensora.getNome()
                .equalsIgnoreCase("Elefante")) {
            peca.atacar(pecaDefensora);
        } else {
            throw new Exception("Ataque inapropriado");
        }
    }
    
}
