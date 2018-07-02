package controller.Command;

import model.Peca;

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
        peca.atacar(y, x);
    }
    
}
