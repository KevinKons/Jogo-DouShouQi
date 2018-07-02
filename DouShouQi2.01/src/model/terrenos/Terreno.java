package model.terrenos;

import model.Peca;

/**
 *
 * @author sAvell
 */
public abstract class Terreno {

    protected final int posX;
    protected final int posY;
    protected Peca peca = null;
    protected String nome;
    protected String caminhoImagem = null;
    protected int r, g, b;

    public Terreno(int posY, int posX, Peca peca, String nome, int r, int g, int b) {
        this.posX = posX;
        this.posY = posY;
        this.peca = peca;
        this.nome = nome;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Terreno(int posY, int posX, String nome, int r, int g, int b) {
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Terreno(int posY, int posX, String nome, String caminhoImagem, int r, int g, int b) {
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;
        this.r = r;
        this.g = g;
        this.b = b;
        this.caminhoImagem = caminhoImagem;
    }

    public String getNome() {
        return nome;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    
    
}
