
package model.terrenos;

import model.Peca;

/**
 *
 * @author Avell
 */
public class Grama extends Terreno {
    
    public Grama(int posY, int posX, Peca peca, String nome, int r, int g, int b) {
        super(posY, posX, peca, nome, r, g, b);
    }

    public Grama(int posY, int posX, String nome, int r, int g, int b) {
        super(posY, posX, nome, r, g, b);
    }


}
