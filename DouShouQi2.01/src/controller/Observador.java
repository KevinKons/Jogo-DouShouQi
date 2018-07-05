
package controller;

/**
 *
 * @author Avell
 */
public interface Observador {
    
    void iniciaTabuleiro(String[][] imagens);

    public void notificaSelecao(int y, int x);

    public void notificaMovimentacao(int y, int x, String caminhoImagem,
            int posAnteriorY, int posAnteriorX, String caminhoImagemPosAnterior);

    public void limpaSelecao(int posAnteriorY, int posAnteriorX);

    public void partidaEncerrada();
    
    public void atualizaPontuacaoTimeA(int pontuacaoTimeA);
    
    public void atualizaPontuacaoTimeB(int pontuacaoTimeB);

    public void notificaVitoria(String nome, String pecasAtacadasTimeVencedor, String pecasAtacadasTimeDefensor);
}
