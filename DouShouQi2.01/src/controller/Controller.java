package controller;

import controller.state.State;
import model.Peca;
import model.time.Time;
import model.terrenos.Terreno;

/**
 *
 * @author Avell
 */
public interface Controller extends Observado {
    
    void criarTabuleiro() throws Exception;
    void tabuleiroClicado(int y, int x) throws Exception;
    int getQntLinhas() throws Exception;
    int getQntColunas() throws Exception;
    Terreno getTerreno(int y, int x) throws Exception;
    boolean existePecaSelecionada() throws Exception;
    void selecionarPeca(int y, int x) throws Exception;
    public Time getAtacante();
    public void limpaSelecao();
    public void notificaSelecao(int y, int x);
    public Peca getPecaSelecionada();
    public void notificaMovimentacao(int y, int x, int posAnteriorY, int posAnteriorX);
    public void trocarAtacante();
    public void setPecaSelecionada(Peca peca);
    public void setState(State state);
    public void atualizaPontuacao();
    public void atualizaPecasAtacadas();
    void jogoVencido(Time vencedor);
}
