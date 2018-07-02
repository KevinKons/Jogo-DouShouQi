package model.terrenos;

import model.Peca;

/**
 *
 * @author Avell
 */
public abstract class FabricaAbstrataDeTerreno {
    
    public abstract Terreno criarGrama(Peca peca, int posY, int posX, String nome, int r, int g, int b);
    public abstract Terreno criarGrama(int posY, int posX, String nome, int r, int g, int b);
    public abstract Terreno criarAgua(int posY, int posX, String nome, int r, int g, int b);
    public abstract Terreno criarArmadilha(int posY, int posX, String nome, String caminhoImagem, int r, int g, int b);
    public abstract Terreno criarToca(int posY, int posX, String nome, String caminhoImagem, int r, int g, int b);
    
}
