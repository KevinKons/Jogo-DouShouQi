package controller.Command;

import controller.Controller;

/**
 *
 * @author Avell
 */
public class SelecionarPeca implements Command {
    
    Controller controle;

    public SelecionarPeca(Controller controle) {
        this.controle = controle;
    }
    
    @Override
    public void execute(int y, int x) throws Exception {
        controle.selecionarPeca(y, x);
    }
    
}
