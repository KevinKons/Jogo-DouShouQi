package view;

import controller.Observador;
import controller.TabuleiroController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Avell
 */
public class TelaPrincipal extends JFrame implements Observador {

    private JButton jbNovaPartida;
    private JButton jbEncerrarPartida;
    private Container container;
    private JPanel jpMenu;
    private JPanel jpTabuleiro;
    private JPanel jpPontuacao;
    private JLabel pontuacaoTimeA = new JLabel("Time A: ");
    private JLabel pontuacaoTimeB = new JLabel("Time B: ");
    private TabuleiroController controller = new TabuleiroController();
    private TabuleiroTableModel tableModel;
    private JTable jtbTabela;

    public TelaPrincipal() {
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        setTitle("Dou Shou Qi");

        initComponents();
    }

    private void initComponents() {
        controller.addObservador(this);

        container = this.getContentPane();
        container.setLayout(new BorderLayout());

        jpMenu = new JPanel();
        jpMenu.setBorder(new TitledBorder("Menu"));
        jpMenu.setLayout(new FlowLayout());
        jbNovaPartida = new JButton("Iniciar Partida");
        jbEncerrarPartida = new JButton("Encerrar Partida");

        jpMenu.add(jbNovaPartida);
        jpMenu.add(jbEncerrarPartida);

        jpTabuleiro = new JPanel();
        jpTabuleiro.setBorder(new TitledBorder("Tabuleiro"));
        jpTabuleiro.setLayout(new FlowLayout());

        tableModel = new TabuleiroTableModel();
        tableModel.setContoller(controller);

        jtbTabela = new JTable(tableModel);
        jtbTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TabuleiroCellRenderer tabuleiroCellRenderer = new TabuleiroCellRenderer();
        jtbTabela.setDefaultRenderer(Object.class, tabuleiroCellRenderer);

        jpTabuleiro.add(jtbTabela);
        jtbTabela.setRowHeight(60);
        
        jpPontuacao = new JPanel();
        jpPontuacao.setLayout(new FlowLayout());
        jpPontuacao.setBorder(new TitledBorder("Pontuação"));
        jpPontuacao.add(pontuacaoTimeA);
        jpPontuacao.add(pontuacaoTimeB);
        
        container.add(BorderLayout.CENTER, jpTabuleiro);
        container.add(BorderLayout.NORTH, jpMenu);
        container.add(BorderLayout.EAST, jpPontuacao);

        jbNovaPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtbTabela.setEnabled(true);
                controller.criarTabuleiro();
                tableModel.criarTabuleiro();
                jbNovaPartida.setEnabled(false);
            }
        });

        jbEncerrarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.encerrarPartida();
                jbNovaPartida.setEnabled(true);
            }
        });

        jtbTabela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int y = jtbTabela.getSelectedRow();
                int x = jtbTabela.getSelectedColumn();

                try {
                    controller.tabuleiroClicado(y, x);
                } catch (Exception ex) {
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public static void main(String[] args) throws Exception {
        TelaPrincipal tp = new TelaPrincipal();
        tp.setVisible(true);

    }

    @Override
    public void iniciaTabuleiro(String[][] imagens) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 6; j++) {
                JLabel l = null;

                if (imagens[i][j].split("#").length == 3) {
                    String[] info = imagens[i][j].split("#");
                    int r = Integer.parseInt(info[0]);
                    int g = Integer.parseInt(info[1]);
                    int b = Integer.parseInt(info[2]);

                    l = new JLabel();
                    l.setOpaque(true);
                    l.setBackground(new Color(r, g, b));
                } else {
                    String[] info = imagens[i][j].split("#");
                    String caminhoImagem = info[0];
                    System.out.println();
                    int r = Integer.parseInt(info[1]);
                    int g = Integer.parseInt(info[2]);
                    int b = Integer.parseInt(info[3]);

                    l = new JLabel(new ImageIcon(getClass().getResource("/view/imagens/" + caminhoImagem)));
                    l.setOpaque(true);
                    l.setBackground(new Color(r, g, b));
                }

                jtbTabela.add(l);
                tableModel.setValueAt(l, i, j);
            }
        }
    }

    @Override
    public void partidaEncerrada() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 6; j++) {
                JLabel l = new JLabel();

                jtbTabela.add(l);
                tableModel.setValueAt(l, i, j);
            }
        }
    }

    @Override
    public void notificaSelecao(int y, int x) {
        JLabel atual = (JLabel) tableModel.getValueAt(y, x);
        atual.setBorder(BorderFactory.createLineBorder(Color.red));
        jtbTabela.repaint();
    }

    @Override
    public void notificaMovimentacao(int y, int x, String caminhoImagem, int posAnteriorY, int posAnteriorX, String caminhoImagemPosAnterior) {
        JLabel posAnterior = (JLabel) tableModel.getValueAt(posAnteriorY, posAnteriorX);
        if (caminhoImagemPosAnterior != null) {
            posAnterior.setIcon(new ImageIcon(getClass().getResource("/view/imagens/" + caminhoImagemPosAnterior)));
        } else {
            posAnterior.setIcon(new ImageIcon());
        }

        JLabel posAtual = (JLabel) tableModel.getValueAt(y, x);
        posAtual.setIcon(new ImageIcon(getClass().getResource("/view/imagens/" + caminhoImagem)));

        jtbTabela.repaint();
    }

    @Override
    public void limpaSelecao(int posAnteriorY, int posAnteriorX) {
        JLabel l = (JLabel) tableModel.getValueAt(posAnteriorY, posAnteriorX);
        l.setBorder(BorderFactory.createEmptyBorder());
        jtbTabela.repaint();
    }

    @Override
    public void atualizaPontuacaoTimeA(int pontuacaoTimeA) {
        this.pontuacaoTimeA.setText("Time A: " + pontuacaoTimeA);
    }

    @Override
    public void atualizaPontuacaoTimeB(int pontuacaoTimeB) {
        this.pontuacaoTimeB.setText("Time B: " + pontuacaoTimeB);
    }

    @Override
    public void notificaVitoria(String nome, String pecasAtacadasTimeVencedor, String pecasAtacadasTimeDefensor) {
        jtbTabela.setEnabled(false);
        JOptionPane.showMessageDialog(this, "O time " + nome + " venceu a partida! \n \n"
                + "Pecas mortas pelo time vencedor: \n"
                + pecasAtacadasTimeVencedor + "\n \n"
                + "Pecas mortas pelo time perdedor: \n"
                + pecasAtacadasTimeDefensor);
    }

}
