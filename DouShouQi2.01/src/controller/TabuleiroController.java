package controller;

import controller.Command.CommandInvoker;
import controller.state.NaoSelecao;
import controller.state.State;
import java.util.ArrayList;
import java.util.List;
import model.Peca;
import model.Tabuleiro;
import model.time.Time;
import model.terrenos.Terreno;
import model.time.strategy.IdentificaPecasAtacadas;
import model.time.strategy.CalcPontuacaoStrategy;

/**
 *
 * @author Avell
 */
public class TabuleiroController implements Observado, Controller {

    private Tabuleiro tabuleiro;
    private List<Observador> observadores = new ArrayList<>();
    private Peca pecaSelecionada = null;
    private Time atacante;
    private Time defensor;
    private State tabuleiroControllerState = new NaoSelecao(this);

    @Override
    public void criarTabuleiro() {
        tabuleiro = Tabuleiro.getInstance();
        tabuleiro.montarTabuleiro();

        for (Observador o : observadores) {
            o.iniciaTabuleiro(tabuleiro.getImagensECorDeFundo());
        }
        atacante = tabuleiro.getTimeA();
    }

    public void encerrarPartida() {
        tabuleiro.limparTabuleiro();

        for (Observador o : observadores) {
            o.partidaEncerrada();
        }
    }

    @Override
    public void tabuleiroClicado(int y, int x) throws Exception {
        tabuleiroControllerState.proxEstado(y, x);
    }

    @Override
    public void limpaSelecao() {
        for (Observador o : observadores) {
            o.limpaSelecao(pecaSelecionada.getY(), pecaSelecionada.getX());
        }
    }

    @Override
    public void notificaSelecao(int y, int x) {
        for (Observador o : observadores) {
            o.notificaSelecao(y, x);
        }
    }

    @Override
    public void notificaMovimentacao(int y, int x, int posAnteriorY, int posAnteriorX) {
        String caminhoImagemPosAnterior = Tabuleiro.getInstance().getTerreno(
                posAnteriorY, posAnteriorX).getCaminhoImagem();

        for (Observador o : observadores) {
            o.notificaMovimentacao(y, x, pecaSelecionada.getCaminhoImagem(),
                    posAnteriorY, posAnteriorX, caminhoImagemPosAnterior);
            o.limpaSelecao(posAnteriorY, posAnteriorX);
        }

    }

    @Override
    public int getQntLinhas() {
        if (tabuleiro == null) {
            return 0;
        }
        return tabuleiro.getQntLinhas();
    }

    @Override
    public int getQntColunas() {
        if (tabuleiro == null) {
            return 0;
        }
        return tabuleiro.getQntColunas();
    }

    @Override
    public void addObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public Terreno getTerreno(int columnIndex, int rowIndex) {
        return tabuleiro.getTerreno(columnIndex, rowIndex);
    }

    @Override
    public boolean existePecaSelecionada() {
        return pecaSelecionada != null;
    }

    @Override
    public void selecionarPeca(int y, int x) {
        pecaSelecionada = tabuleiro.getTerreno(y, x).getPeca();
    }

    @Override
    public void trocarAtacante() {
        if (tabuleiro.getTimeA().equals(atacante)) {
            atacante = tabuleiro.getTimeB();
            defensor = tabuleiro.getTimeA();
        } else {
            atacante = tabuleiro.getTimeA();
            defensor = tabuleiro.getTimeB();
        }
    }

    @Override
    public void setState(State tabuleiroControllerState) {
        this.tabuleiroControllerState = tabuleiroControllerState;
    }

    @Override
    public Peca getPecaSelecionada() {
        return pecaSelecionada;
    }

    @Override
    public void setPecaSelecionada(Peca pecaSelecionada) {
        this.pecaSelecionada = pecaSelecionada;
    }

    @Override
    public Time getAtacante() {
        return atacante;
    }

    @Override
    public void atualizaPontuacao() {
        atacante.setStrategy(new CalcPontuacaoStrategy());
        int pontuacao = (int) atacante.calcularStrategy();
        if (atacante.equals(tabuleiro.getTimeA())) {
            for (Observador o : observadores) {
                o.atualizaPontuacaoTimeA(pontuacao);
            }
        } else {
            for (Observador o : observadores) {
                o.atualizaPontuacaoTimeB(pontuacao);
            }
        }
    }

    @Override
    public void atualizaPecasAtacadas() {

    }

    @Override
    public void jogoVencido(Time vencedor) {
        atacante.setStrategy(new IdentificaPecasAtacadas());
        String pecasAtacadasTimeVencedor = (String) atacante.calcularStrategy();

        defensor.setStrategy(new IdentificaPecasAtacadas());
        String pecasAtacadasTimeDefensor = (String) defensor.calcularStrategy();
        for (Observador o : observadores) {
            o.notificaVitoria(vencedor.getNome(), pecasAtacadasTimeVencedor, pecasAtacadasTimeDefensor);
        }
    }
}
