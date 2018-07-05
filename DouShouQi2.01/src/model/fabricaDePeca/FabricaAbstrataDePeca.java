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
public abstract class FabricaAbstrataDePeca {
    
    public static final int FORÇA_RATO = 1;
    public static final int FORÇA_GATO = 2;
    public static final int FORÇA_CACHORRO = 3;
    public static final int FORÇA_LOBO = 4;
    public static final int FORÇA_LEOPARDO = 5;
    public static final int FORÇA_TIGRE = 6;
    public static final int FORÇA_LEAO = 7;
    public static final int FORÇA_ELEFANTE = 8;
 
    public abstract Rato criarRato(String img, int forca, String nome, Time time, int x, int y);
    public abstract Gato criarGato(String img, int forca, String nome, Time time, int x, int y);
    public abstract Cachorro criarCachorro(String img, int forca, String nome, Time time, int x, int y);
    public abstract Lobo criarLobo(String img, int forca, String nome, Time time, int x, int y);
    public abstract Leopardo criarLeopardo(String img, int forca, String nome, Time time, int x, int y);
    public abstract Tigre criarTigre(String img, int forca, String nome, Time time, int x, int y);
    public abstract Leao criarLeao(String img, int forca, String nome, Time time, int x, int y);
    public abstract Elefante criarElefante(String img, int forca, String nome, Time time, int x, int y);
}
