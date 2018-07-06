package controller.state;

import controller.Controller;
import model.Peca;
import model.Tabuleiro;

/**
 *
 * @author Avell
 */
public class NaoSelecao extends State {

    public NaoSelecao(Controller controller) {
        super(controller);
    }
    
    @Override
    public void proxEstado(int y, int x) throws Exception {
        Peca peca = Tabuleiro.getInstance().getTerreno(y, x).getPeca();
        if (peca != null) { //Se existe uma peca onde foi clicado (Selecao)
            if (controller.getAtacante().getPecas().contains(peca)) {

                ci.execute(y, x, 2, controller);
                
                controller.notificaSelecao(y, x);
                controller.setState(new Selecao(controller));
            }
        }
    }

}
