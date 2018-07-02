package model.time.builderTime;

import model.Tabuleiro;
import model.time.Time;
import model.fabricaDePeca.FabricaAbstrataDePeca;
import model.terrenos.FabricaAbstrataDeTerreno;

/**
 *
 * @author Avell
 */
public abstract class BuilderTime {
    
    protected Time time = new Time();
    protected FabricaAbstrataDePeca fabricaDePeca;
    protected FabricaAbstrataDeTerreno fabricaDeTerreno;

    public BuilderTime(FabricaAbstrataDePeca fabricaDePeca, FabricaAbstrataDeTerreno fabricaDeTerreno) {
        this.fabricaDePeca = fabricaDePeca;
        this.fabricaDeTerreno = fabricaDeTerreno;
    }
    
    public abstract void constroiRato(Tabuleiro tabuleiro);
    public abstract void constroiGato(Tabuleiro tabuleiro);
    public abstract void constroiCachorro(Tabuleiro tabuleiro);
    public abstract void constroiLobo(Tabuleiro tabuleiro);
    public abstract void constroiLeopardo(Tabuleiro tabuleiro);
    public abstract void constroiTigre(Tabuleiro tabuleiro);
    public abstract void constroiLeao(Tabuleiro tabuleiro);
    public abstract void constroiElefante(Tabuleiro tabuleiro);
    public abstract void constroiArmadilhas(Tabuleiro tabuleiro);
    public abstract void constroiToca(Tabuleiro tabuleiro);

    public Time getTime() {
        return time;
    }
    
    
}
