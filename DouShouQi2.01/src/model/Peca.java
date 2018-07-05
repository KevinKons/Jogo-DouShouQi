package model;

import model.time.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avell
 */
public abstract class Peca {

    protected Tabuleiro tabuleiro;
    protected String nome;
    protected int forca;
    protected String caminhoImagem;
    protected Time time;
    protected int x;
    protected int y;
    protected List<Peca> pecasAtacadas = new ArrayList<>();

    public Peca(int forca, String caminhoImagem, String nome, Time time, int y, int x) {
        this.forca = forca;
        this.caminhoImagem = caminhoImagem;
        this.nome = nome;
        this.tabuleiro = Tabuleiro.getInstance();
        this.time = time;
        this.x = x;
        this.y = y;
    }

    public void movimentar(int posY, int posX) {
        tabuleiro.getTerreno(this.y, this.x).setPeca(null);
        tabuleiro.getTerreno(posY, posX).setPeca(this);

        this.x = posX;
        this.y = posY;
    }

    public int getForca() {
        return forca;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public String getNome() {
        return nome;
    }

    public void atacar(Peca pecaDefensora) throws Exception {
        pecasAtacadas.add(pecaDefensora.getTime().removerPeca(pecaDefensora));
        movimentar(pecaDefensora.getY(), pecaDefensora.getX());
    }

    public boolean isMovimentacaoPossivel(int y, int x) {
        return (x == this.x + 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()))
                || ((x == this.x) && (y == this.y + 1) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x - 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x) && (y == this.y - 1)) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()));
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }

    public List<Peca> getPecasAtacadas() { return pecasAtacadas; }

    public void setForca(int forca) { this.forca = forca; }
    
    
    
    
    
    
    
}
