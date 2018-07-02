package model.time.builderTime;

import model.Tabuleiro;
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
    public void constroiRato(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarRato("rato1.png", FabricaAbstrataDePeca.FORÇA_RATO, "Rato", tabuleiro, time, 2, 0));
    }

    @Override
    public void constroiGato(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarGato("gato1.png", FabricaAbstrataDePeca.FORÇA_GATO, "Gato", tabuleiro, time, 1, 5));
    }

    @Override
    public void constroiCachorro(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarCachorro("cao1.png", FabricaAbstrataDePeca.FORÇA_CACHORRO, "Cachorro", tabuleiro, time, 1, 1));
    }

    @Override
    public void constroiLobo(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLobo("lobo1.png", FabricaAbstrataDePeca.FORÇA_LOBO, "Lobo", tabuleiro, time, 2, 4));
    }

    @Override
    public void constroiLeopardo(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLeopardo("leopardo1.png", FabricaAbstrataDePeca.FORÇA_LEOPARDO, "Leopardo", tabuleiro, time, 2, 2));
    }

    @Override
    public void constroiTigre(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarTigre("tigre1.png", FabricaAbstrataDePeca.FORÇA_TIGRE, "Tigre", tabuleiro, time, 0, 6));
    }

    @Override
    public void constroiLeao(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLeao("leao1.png", FabricaAbstrataDePeca.FORÇA_LEAO, "Leao", tabuleiro, time, 0, 0));
    }

    @Override
    public void constroiElefante(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarElefante("elefante1.png", FabricaAbstrataDePeca.FORÇA_ELEFANTE, "Elefante", tabuleiro, time, 2, 6));
    }

    @Override
    public void constroiArmadilhas(Tabuleiro tabuleiro) {
        time.addTerreno(fabricaDeTerreno.criarArmadilha(0, 2, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(0, 4, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(1, 3, "Armadilha", "armadilha.png", 139, 69, 19));
    }

    @Override
    public void constroiToca(Tabuleiro tabuleiro) {
        time.addTerreno(fabricaDeTerreno.criarToca(0, 3, "TocaA", "toca.png", 100, 63, 3));
    }
    
}
