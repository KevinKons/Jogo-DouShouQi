/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;

import controller.Controller;
import model.Peca;
import model.Tabuleiro;
import model.terrenos.Terreno;
import model.time.Time;

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
            controller.notificaMovimentacao(y, x, posAnteriorY, posAnteriorX);
            
            Terreno destino = Tabuleiro.getInstance().getTerreno(y, x);
            if (destino.getNome().contains("Toca")) {
                controller.jogoVencido(controller.getPecaSelecionada().getTime());
            }

            controller.trocarAtacante();
            controller.setPecaSelecionada(null);
            controller.setState(new NaoSelecao(controller));
            
        } else if (controller.getPecaSelecionada().isMovimentacaoPossivel(y, x) && peca != null) { //Ataque
            int posAnteriorY = controller.getPecaSelecionada().getY();
            int posAnteriorX = controller.getPecaSelecionada().getX();

            ci.execute(y, x, 3, controller.getPecaSelecionada());

            controller.atualizaPontuacao();

            controller.notificaMovimentacao(y, x, posAnteriorY, posAnteriorX);

            controller.trocarAtacante();
            controller.setPecaSelecionada(null);
            controller.setState(new NaoSelecao(controller));
        }
    }


}
