
package model.BuilderTime;

import model.Tabuleiro;

/**
 *
 * @author Avell
 */

//Diretor
public class Tecnico {
    
    private BuilderTime bt;

    public Tecnico(BuilderTime bt) {
        this.bt = bt;
    }
    
    public void montarTime(Tabuleiro tabuleiro) {
        bt.constroiRato(tabuleiro);
        bt.constroiGato(tabuleiro);
        bt.constroiCachorro(tabuleiro);
        bt.constroiLobo(tabuleiro);
        bt.constroiLeopardo(tabuleiro);
        bt.constroiTigre(tabuleiro);
        bt.constroiLeao(tabuleiro);
        bt.constroiElefante(tabuleiro);
        bt.constroiArmadilhas(tabuleiro);
        bt.constroiToca(tabuleiro);
    }
}
