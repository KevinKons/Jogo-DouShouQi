package model.time.builderTime;

import model.fabricaDePeca.FabricaAbstrataDePeca;
import model.terrenos.FabricaAbstrataDeTerreno;

/**
 *
 * @author Avell
 */
public class BuilderTimeA extends BuilderTime {

    public BuilderTimeA(FabricaAbstrataDePeca fabricaDePeca, FabricaAbstrataDeTerreno fabricaDeTerreno) {
        super(fabricaDePeca, fabricaDeTerreno);
        time.setNome("TimeA");
    }

    @Override
    public void constroiRato() {
        time.addPecas(fabricaDePeca.criarRato("rato1.png", FabricaAbstrataDePeca.FORÇA_RATO, "Rato", time, 2, 0));
    }

    @Override
    public void constroiGato() {
        time.addPecas(fabricaDePeca.criarGato("gato1.png", FabricaAbstrataDePeca.FORÇA_GATO, "Gato", time, 1, 5));
    }

    @Override
    public void constroiCachorro() {
        time.addPecas(fabricaDePeca.criarCachorro("cao1.png", FabricaAbstrataDePeca.FORÇA_CACHORRO, "Cachorro", time, 1, 1));
    }

    @Override
    public void constroiLobo() {
        time.addPecas(fabricaDePeca.criarLobo("lobo1.png", FabricaAbstrataDePeca.FORÇA_LOBO, "Lobo", time, 2, 4));
    }

    @Override
    public void constroiLeopardo() {
        time.addPecas(fabricaDePeca.criarLeopardo("leopardo1.png", FabricaAbstrataDePeca.FORÇA_LEOPARDO, "Leopardo", time, 2, 2));
    }

    @Override
    public void constroiTigre() {
        time.addPecas(fabricaDePeca.criarTigre("tigre1.png", FabricaAbstrataDePeca.FORÇA_TIGRE, "Tigre", time, 0, 6));
    }

    @Override
    public void constroiLeao() {
        time.addPecas(fabricaDePeca.criarLeao("leao1.png", FabricaAbstrataDePeca.FORÇA_LEAO, "Leao", time, 0, 0));
    }

    @Override
    public void constroiElefante() {
        time.addPecas(fabricaDePeca.criarElefante("elefante1.png", FabricaAbstrataDePeca.FORÇA_ELEFANTE, "Elefante", time, 2, 6));
    }

    @Override
    public void constroiArmadilhas() {
        time.addTerreno(fabricaDeTerreno.criarArmadilha(0, 2, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(0, 4, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(1, 3, "Armadilha", "armadilha.png", 139, 69, 19));
    }

    @Override
    public void constroiToca() {
        time.addTerreno(fabricaDeTerreno.criarToca(0, 3, "TocaA", "toca.png", 100, 63, 3));
    }
    
}
