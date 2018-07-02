/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;

import controller.Controller;
import controller.TabuleiroController;
import model.Peca;
import model.Tabuleiro;

/**
 *
 * @author Avell
 */
public class Selecao extends State {

    public Selecao(Controller controller) {
        super(controller);
    }

    @Override
    public void proxEstado(int y, int x) throws Exception {
        Peca peca = Tabuleiro.getInstance().getTerreno(y, x).getPeca();

        if (controller.getAtacante().getPecas().contains(peca)) { //Seleciona outra peca

            controller.limpaSelecao();
            ci.execute(y, x, 2, controller);
            controller.notificaSelecao(y, x);

        } else if (controller.getPecaSelecionada().isMovimentacaoPossivel(y, x) && peca == null) { //Realiza Movimentação
            int posAnteriorY = controller.getPecaSelecionada().getY();
            int posAnteriorX = controller.getPecaSelecionada().getX();

            ci.execute(y, x, 1, controller.getPecaSelecionada());
            
            operacoesPosMovOuAtaque(y, x, posAnteriorY, posAnteriorX);
            
        } else if (controller.getPecaSelecionada().isMovimentacaoPossivel(y, x) && peca != null) { //Ataque
            int posAnteriorY = controller.getPecaSelecionada().getY();
            int posAnteriorX = controller.getPecaSelecionada().getX();

            ci.execute(y, x, 3, controller.getPecaSelecionada());

            operacoesPosMovOuAtaque(y, x, posAnteriorY, posAnteriorX);
        }
    }

    @Override
    public void proxEstado() throws Exception {
        throw new Exception("Operação não suportada, para sair do estado de"
                + " seleção é necessário informar uma coordenada.");
    }
    
    private void operacoesPosMovOuAtaque(int y, int x, int posAnteriorY, int posAnteriorX) {
        controller.notificaMovimentacao(y, x, posAnteriorY, posAnteriorX);

        controller.trocarAtacante();
        controller.setPecaSelecionada(null);
        controller.setState(new NaoSelecao(controller));
    }

}
