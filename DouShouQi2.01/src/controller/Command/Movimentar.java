
package controller.Command;

import model.Peca;

/**
 *
 * @author Avell
 */
public class Movimentar implements Command {

    private Peca peca;

    public Movimentar(Peca peca) {
        this.peca = peca;
    }
    
    @Override
    public void execute(int y, int x) {
        peca.movimentar(y, x);
    }
    
}
