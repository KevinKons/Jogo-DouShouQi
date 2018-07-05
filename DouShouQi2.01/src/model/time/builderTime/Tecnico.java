
package model.time.builderTime;

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
    
    public void montarTime() {
        bt.constroiRato();
        bt.constroiGato();
        bt.constroiCachorro();
        bt.constroiLobo();
        bt.constroiLeopardo();
        bt.constroiTigre();
        bt.constroiLeao();
        bt.constroiElefante();
        bt.constroiArmadilhas();
        bt.constroiToca();
    }
}
