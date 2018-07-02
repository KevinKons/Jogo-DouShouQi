package model.terrenos;

import model.Peca;

/**
 *
 * @author Avell
 */
public class FabricaDeTerreno extends FabricaAbstrataDeTerreno {


    @Override
    public Terreno criarGrama(Peca peca, int posY, int posX, String nome, int r, int g, int b) {
        return new Grama(posY, posX, peca, nome, r, g, b);
    }
    
    @Override
    public Terreno criarGrama(int posY, int posX, String nome, int r, int g, int b) {
        return new Grama(posY, posX, nome, r, g, b);
    }

    @Override
    public Terreno criarAgua(int posY, int posX, String nome, int r, int g, int b) {
        Terreno a = new Agua(posY, posX, nome, r, g, b);
        a.setPeca(null);
        return a;
    }
    
    @Override
    public Terreno criarArmadilha(int posY, int posX, String nome, String caminhoImagem, int r, int g, int b) {
        return new Armadilha(posY, posX, nome, caminhoImagem, r, g, b);
    }
    
    @Override
    public Terreno criarToca(int posY, int posX, String nome, String caminhoImagem, int r, int g, int b) {
        return new Toca(posY, posX, nome, caminhoImagem, r, g, b);
    }
    
}

