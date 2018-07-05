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
    
    public abstract void constroiRato();
    public abstract void constroiGato();
    public abstract void constroiCachorro();
    public abstract void constroiLobo();
    public abstract void constroiLeopardo();
    public abstract void constroiTigre();
    public abstract void constroiLeao();
    public abstract void constroiElefante();
    public abstract void constroiArmadilhas();
    public abstract void constroiToca();

    public Time getTime() {
        return time;
    }
    
    
}
