package controller.Command;

import model.Peca;
import model.Tabuleiro;
import model.fabricaDePeca.FabricaAbstrataDePeca;
import model.terrenos.Terreno;

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
        Terreno terreno = Tabuleiro.getInstance().getTerreno(y, x);
        boolean entrouNaToca = false;
        
        if (terreno.getNome().equalsIgnoreCase("Armadilha")) {
            peca.setForca(0);
        } else if (peca.getForca() == 0) {
            switch (peca.getNome()) {
                case "Rato":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_RATO);
                    break;
                case "Gato":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_GATO);
                    break;
                case "Cachorro":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_CACHORRO);
                    break;
                case "Lobo":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_LOBO);
                    break;
                case "Leopardo":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_LEOPARDO);
                    break;
                case "Tigre":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_TIGRE);
                    break;
                case "Leao":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_LEAO);
                    break;
                case "Elefante":
                    peca.setForca(FabricaAbstrataDePeca.FORÇA_ELEFANTE);
                    break;
            }
        }
        peca.movimentar(y, x);
    }

}
