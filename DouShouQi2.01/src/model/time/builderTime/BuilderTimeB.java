package model.time.builderTime;

import model.Tabuleiro;
import model.fabricaDePeca.FabricaAbstrataDePeca;
import model.terrenos.FabricaAbstrataDeTerreno;

/**
 *
 * @author Avell
 */
public class BuilderTimeB extends BuilderTime {

    public BuilderTimeB(FabricaAbstrataDePeca fabricaDePeca, FabricaAbstrataDeTerreno fabricaDeTerreno) {
        super(fabricaDePeca, fabricaDeTerreno);
        time.setNome("TimeB");
    }

    @Override
    public void constroiRato(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarRato("rato2.png", 1, "Rato", tabuleiro, time, 6, 6));
    }

    @Override
    public void constroiGato(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarGato("gato2.png", 2, "Gato", tabuleiro, time, 7, 1));
    }

    @Override
    public void constroiCachorro(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarCachorro("cao2.png", 3, "Cachorro", tabuleiro, time, 7, 5));
    }

    @Override
    public void constroiLobo(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLobo("lobo2.png", 4, "Lobo", tabuleiro, time, 6, 2));
    }

    @Override
    public void constroiLeopardo(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLeopardo("leopardo2.png", 5, "Leopardo", tabuleiro, time, 6, 4));
    }

    @Override
    public void constroiTigre(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarTigre("tigre2.png", 6, "Tigre", tabuleiro, time, 8, 0));
    }

    @Override
    public void constroiLeao(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarLeao("leao2.png", 7, "Leao", tabuleiro, time, 8, 6));
    }

    @Override
    public void constroiElefante(Tabuleiro tabuleiro) {
        time.addPecas(fabricaDePeca.criarElefante("elefante2.png", 8, "Elefante", tabuleiro, time, 6, 0));
    }

    @Override
    public void constroiArmadilhas(Tabuleiro tabuleiro) {
        time.addTerreno(fabricaDeTerreno.criarArmadilha(8, 2, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(8, 4, "Armadilha", "armadilha.png", 139, 69, 19));
        time.addTerreno(fabricaDeTerreno.criarArmadilha(7, 3, "Armadilha", "armadilha.png", 139, 69, 19));
    }

    @Override
    public void constroiToca(Tabuleiro tabuleiro) {
        time.addTerreno(fabricaDeTerreno.criarToca(8, 3, "TocaB", "toca.png", 100, 63, 3));
    }

}
