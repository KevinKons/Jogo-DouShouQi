
package model.pecaEntraNoRio;

import model.Peca;
import model.Tabuleiro;
import model.time.Time;

/**
 *
 * @author Avell
 */
public abstract class PecaEntraNoRio extends Peca {

    public PecaEntraNoRio(int forca, String caminhoImagem, String nome, Time time, int x, int y) {
        super(forca, caminhoImagem, nome, time, x, y);
    }

    @Override
    public boolean isMovimentacaoPossivel(int y, int x) {
        return (x == this.x + 1) && (y == this.y) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()))
                || ((x == this.x) && (y == this.y + 1) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x - 1) && (y == this.y) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x) && (y == this.y - 1)) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()));
    }
}
