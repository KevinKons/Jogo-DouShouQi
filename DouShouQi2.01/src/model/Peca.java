package model;

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

    public Peca(int forca, String caminhoImagem, String nome, Tabuleiro tabuleiro, Time time, int y, int x) {
        this.forca = forca;
        this.caminhoImagem = caminhoImagem;
        this.nome = nome;
        this.tabuleiro = tabuleiro;
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

    public void atacar(int y, int x) throws Exception {
        
    }

    public boolean isMovimentacaoPossivel(int y, int x) {
        return (x == this.x + 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()))
                || ((x == this.x) && (y == this.y + 1) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x - 1) && (y == this.y) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome())))
                || ((x == this.x) && (y == this.y - 1)) && (!tabuleiro.getTerreno(y, x).getNome().equalsIgnoreCase("Agua")) && (!time.getToca().getNome().equalsIgnoreCase(tabuleiro.getTerreno(y, x).getNome()));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
