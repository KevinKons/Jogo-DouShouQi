
package model.pecaPulaRio;

import model.Peca;
import model.Tabuleiro;
import model.time.Time;

/**
 *
 * @author Avell
 */
public abstract class PecaPulaRio extends Peca {

    public PecaPulaRio(int forca, String caminhoImagem, String nome, Time time, int x, int y) {
        super(forca, caminhoImagem, nome, time, x ,y);
    }

    @Override
    public boolean isMovimentacaoPossivel(int y, int x) {
        return (x == this.x + 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equals("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()))
                || ((x == this.x) && (y == this.y + 1) && (!tabuleiro.getTerreno(y, x).getNome().equals("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x - 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equals("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x) && (y == this.y - 1) && (!tabuleiro.getTerreno(y, x).getNome().equals("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x) && (y == this.y + 4) && ((tabuleiro.getTerreno(this.y + 1, x).getPeca() == null) && (tabuleiro.getTerreno(this.y + 1, x).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(this.y + 2, x).getPeca() == null) && (tabuleiro.getTerreno(this.y + 2, x).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(this.y + 3, x).getPeca() == null) && (tabuleiro.getTerreno(this.y + 3, x).getNome().equals("Agua"))))
                || ((x == this.x) && (y == this.y - 4) && ((tabuleiro.getTerreno(this.y - 1, x).getPeca() == null) && (tabuleiro.getTerreno(this.y - 1, x).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(this.y - 2, x).getPeca() == null) && (tabuleiro.getTerreno(this.y - 2, x).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(this.y - 3, x).getPeca() == null) && (tabuleiro.getTerreno(this.y - 3, x).getNome().equals("Agua"))))
                || (x == this.x + 3) && (y == this.y) && ((tabuleiro.getTerreno(y, this.x + 1).getPeca() == null) && (tabuleiro.getTerreno(y, this.x + 1).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(y, this.x + 2).getPeca() == null && (tabuleiro.getTerreno(y, this.x + 2).getNome().equals("Agua"))))
                || (x == this.x - 3) && (y == this.y) && ((tabuleiro.getTerreno(y, this.x - 1).getPeca() == null) && (tabuleiro.getTerreno(y, this.x - 1).getNome().equals("Agua"))) && ((tabuleiro.getTerreno(y, this.x - 2).getPeca() == null && (tabuleiro.getTerreno(y, this.x - 2).getNome().equals("Agua"))));
    }
}
