package model.pecaPadrao;

import model.Peca;
import model.Tabuleiro;
import model.time.Time;

/**
 *
 * @author Avell
 */
public class Cachorro extends Peca {

    public Cachorro(int forca, String caminhoImagem, String nome, Tabuleiro tabuleiro, Time time, int x, int y) {
        super(forca, caminhoImagem, nome, tabuleiro, time, x, y);
    }

}
