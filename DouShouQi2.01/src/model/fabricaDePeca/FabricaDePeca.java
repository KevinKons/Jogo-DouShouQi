package model.fabricaDePeca;

import model.Tabuleiro;
import model.time.Time;
import model.pecaEntraNoRio.Rato;
import model.pecaPadrao.Cachorro;
import model.pecaPadrao.Elefante;
import model.pecaPadrao.Gato;
import model.pecaPadrao.Leopardo;
import model.pecaPadrao.Lobo;
import model.pecaPulaRio.Leao;
import model.pecaPulaRio.Tigre;

/**
 *
 * @author Avell
 */
public class FabricaDePeca extends FabricaAbstrataDePeca {

    @Override
    public Rato criarRato(String img, int forca, String nome, Time time, int x, int y) {
        return new Rato(forca, img, nome, time, x, y);
    }

    @Override
    public Gato criarGato(String img, int forca, String nome, Time time, int x, int y) {
        return new Gato(forca, img, nome, time, x, y);
    }

    @Override
    public Cachorro criarCachorro(String img, int forca, String nome, Time time, int x, int y) {
        return new Cachorro(forca, img, nome, time, x, y);
    }

    @Override
    public Lobo criarLobo(String img, int forca, String nome, Time time, int x, int y) {
        return new Lobo(forca, img, nome, time, x, y);
    }

    @Override
    public Leopardo criarLeopardo(String img, int forca, String nome, Time time, int x, int y) {
        return new Leopardo(forca, img, nome, time, x, y);
    }

    @Override
    public Tigre criarTigre(String img, int forca, String nome, Time time, int x, int y) {
        return new Tigre(forca, img, nome, time, x, y);
    }

    @Override
    public Leao criarLeao(String img, int forca, String nome, Time time, int x, int y) {
        return new Leao(forca, img, nome, time, x, y);
    }

    @Override
    public Elefante criarElefante(String img, int forca, String nome, Time time, int x, int y) {
        return new Elefante(forca, img, nome, time, x, y);
    }
    
}
