package model;

import model.time.Time;
import model.terrenos.Terreno;
import model.time.builderTime.BuilderTime;
import model.time.builderTime.BuilderTimeA;
import model.time.builderTime.BuilderTimeB;
import model.time.builderTime.Tecnico;
import model.fabricaDePeca.FabricaAbstrataDePeca;
import model.fabricaDePeca.FabricaDePeca;
import model.terrenos.FabricaAbstrataDeTerreno;
import model.terrenos.FabricaDeTerreno;

/**
 *
 * @author Avell
 */
public class Tabuleiro {

    private static Tabuleiro instance;

    public synchronized static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }

        return instance;
    }

    private Terreno[][] terrenos;
    private final int qntLinhas = 9;
    private final int qntColunas = 7;

    private Tecnico tecnico;
    private BuilderTime builderTime;

    private Time timeA;
    private Time timeB;

    private FabricaAbstrataDePeca fabricaDePeca = new FabricaDePeca();
    private FabricaAbstrataDeTerreno fabricaDeTerreno = new FabricaDeTerreno();
    
    private Tabuleiro() {
    }

    public void limparTabuleiro() {
        terrenos = null;
        timeA = null;
        timeB = null;
    }
    
    private Time montarTimeA() {
        builderTime = new BuilderTimeA(fabricaDePeca, fabricaDeTerreno);
        tecnico = new Tecnico(builderTime);
        tecnico.montarTime();
        return builderTime.getTime();
    }

    private Time montarTimeB() {
        builderTime = new BuilderTimeB(fabricaDePeca, fabricaDeTerreno);
        tecnico = new Tecnico(builderTime);
        tecnico.montarTime();
        return builderTime.getTime();
    }

    public int getQntLinhas() {
        return qntLinhas;
    }

    public int getQntColunas() {
        return qntColunas;
    }

    public Terreno getTerreno(int columnIndex, int rowIndex) {
        return terrenos[columnIndex][rowIndex];
    }

    public Time getTimeA() {
        return timeA;
    }

    public void setTimeA(Time timeA) {
        this.timeA = timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public void setTimeB(Time timeB) {
        this.timeB = timeB;
    }

    public String[][] getImagensECorDeFundo() {
        String[][] imagens = new String[9][7];

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 6; j++) {
                int r = terrenos[i][j].getR();
                int g = terrenos[i][j].getG();
                int b = terrenos[i][j].getB();
                
                if(terrenos[i][j].getPeca() != null) {
                    imagens[i][j] = terrenos[i][j].getPeca().getCaminhoImagem() + "#" + r + "#" + g + "#" + b;
                } else if (terrenos[i][j].getNome().equals("Armadilha") || terrenos[i][j].getNome().equals("TocaA") || terrenos[i][j].getNome().equals("TocaB")) {
                    imagens[i][j] = terrenos[i][j].getCaminhoImagem() + "#" + r + "#" + g + "#" + b;
                } else {
                    imagens[i][j] = r + "#" + g + "#" + b;
                }
                
            }
        }
        return imagens;
    }

    @Override
    public String toString() {
        String retorno = "";
        System.out.println();
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 6; j++) {
                try {
                    retorno += terrenos[i][j].getPeca().getNome() + "| ";
                } catch (Exception ex) {
                    retorno += terrenos[i][j].getNome() + "| ";
                }
            }
            retorno += "\n";
        }
        return retorno;
    }

    public void montarTabuleiro() {
        this.terrenos = new Terreno[qntLinhas][qntColunas];
        
        this.timeA = montarTimeA();
        this.timeB = montarTimeB();
        
        terrenos[0][0] = fabricaDeTerreno.criarGrama(timeA.getPeca("Leao"), 0, 0, "Grama", 16, 135, 6);
        terrenos[0][1] = fabricaDeTerreno.criarGrama(0, 1, "Grama", 16, 135, 6);
        terrenos[0][2] = timeA.getTerreno(0, 2);
        terrenos[0][3] = timeA.getTerreno(0, 3);
        terrenos[0][4] = timeA.getTerreno(0, 4);
        terrenos[0][5] = fabricaDeTerreno.criarGrama(0, 5, "Grama", 16, 135, 6);
        terrenos[0][6] = fabricaDeTerreno.criarGrama(timeA.getPeca("Tigre"), 0, 6, "Grama", 16, 135, 6);

        terrenos[1][0] = fabricaDeTerreno.criarGrama(1, 0, "Grama", 16, 135, 6);
        terrenos[1][1] = fabricaDeTerreno.criarGrama(timeA.getPeca("Cachorro"), 1, 1, "Grama", 16, 135, 6);
        terrenos[1][2] = fabricaDeTerreno.criarGrama(1, 2, "Grama", 16, 135, 6);
        terrenos[1][3] = timeA.getTerreno(1, 3);
        terrenos[1][4] = fabricaDeTerreno.criarGrama(1, 4, "Grama", 16, 135, 6);
        terrenos[1][5] = fabricaDeTerreno.criarGrama(timeA.getPeca("Gato"), 1, 5, "Grama", 16, 135, 6);
        terrenos[1][6] = fabricaDeTerreno.criarGrama(1, 6, "Grama", 16, 135, 6);

        terrenos[2][0] = fabricaDeTerreno.criarGrama(timeA.getPeca("Rato"), 2, 0, "Grama", 16, 135, 6);
        terrenos[2][1] = fabricaDeTerreno.criarGrama(2, 1, "Grama", 16, 135, 6);
        terrenos[2][2] = fabricaDeTerreno.criarGrama(timeA.getPeca("Leopardo"), 2, 2, "Grama", 16, 135, 6);
        terrenos[2][3] = fabricaDeTerreno.criarGrama(2, 3, "Grama", 16, 135, 6);
        terrenos[2][4] = fabricaDeTerreno.criarGrama(timeA.getPeca("Lobo"), 2, 4, "Grama", 16, 135, 6);
        terrenos[2][5] = fabricaDeTerreno.criarGrama(2, 5, "Grama", 16, 135, 6);
        terrenos[2][6] = fabricaDeTerreno.criarGrama(timeA.getPeca("Elefante"), 2, 6, "Grama", 16, 135, 6);

        terrenos[3][0] = fabricaDeTerreno.criarGrama(3, 0, "Grama", 16, 135, 6);
        terrenos[3][1] = fabricaDeTerreno.criarAgua(3, 1, "Agua", 21, 106, 206);
        terrenos[3][2] = fabricaDeTerreno.criarAgua(3, 2, "Agua", 21, 106, 206);
        terrenos[3][3] = fabricaDeTerreno.criarGrama(3, 3, "Grama", 16, 135, 6);
        terrenos[3][4] = fabricaDeTerreno.criarAgua(3, 4, "Agua", 21, 106, 206);
        terrenos[3][5] = fabricaDeTerreno.criarAgua(3, 5, "Agua", 21, 106, 206);
        terrenos[3][6] = fabricaDeTerreno.criarGrama(3, 6, "Grama", 16, 135, 6);

        terrenos[4][0] = fabricaDeTerreno.criarGrama(4, 0, "Grama", 16, 135, 6);
        terrenos[4][1] = fabricaDeTerreno.criarAgua(4, 1, "Agua", 21, 106, 206);
        terrenos[4][2] = fabricaDeTerreno.criarAgua(4, 2, "Agua", 21, 106, 206);
        terrenos[4][3] = fabricaDeTerreno.criarGrama(4, 3, "Grama", 16, 135, 6);
        terrenos[4][4] = fabricaDeTerreno.criarAgua(4, 4, "Agua", 21, 106, 206);
        terrenos[4][5] = fabricaDeTerreno.criarAgua(4, 5, "Agua", 21, 106, 206);
        terrenos[4][6] = fabricaDeTerreno.criarGrama(4, 6, "Grama", 16, 135, 6);

        terrenos[5][0] = fabricaDeTerreno.criarGrama(5, 0, "Grama", 16, 135, 6);
        terrenos[5][1] = fabricaDeTerreno.criarAgua(5, 1, "Agua", 21, 106, 206);
        terrenos[5][2] = fabricaDeTerreno.criarAgua(5, 2, "Agua", 21, 106, 206);
        terrenos[5][3] = fabricaDeTerreno.criarGrama(5, 3, "Grama", 16, 135, 6);
        terrenos[5][4] = fabricaDeTerreno.criarAgua(5, 4, "Agua", 21, 106, 206);
        terrenos[5][5] = fabricaDeTerreno.criarAgua(5, 5, "Agua", 21, 106, 206);
        terrenos[5][6] = fabricaDeTerreno.criarGrama(5, 6, "Grama", 16, 135, 6);

        terrenos[6][0] = fabricaDeTerreno.criarGrama(timeB.getPeca("Elefante"), 6, 0, "Grama", 16, 135, 6);
        terrenos[6][1] = fabricaDeTerreno.criarGrama(6, 1, "Grama", 16, 135, 6);
        terrenos[6][2] = fabricaDeTerreno.criarGrama(timeB.getPeca("Lobo"), 6, 2, "Grama", 16, 135, 6);
        terrenos[6][3] = fabricaDeTerreno.criarGrama(6, 3, "Grama", 16, 135, 6);
        terrenos[6][4] = fabricaDeTerreno.criarGrama(timeB.getPeca("Leopardo"), 6, 4, "Grama", 16, 135, 6);
        terrenos[6][5] = fabricaDeTerreno.criarGrama(6, 5, "Grama", 16, 135, 6);
        terrenos[6][6] = fabricaDeTerreno.criarGrama(timeB.getPeca("Rato"), 6, 6, "Grama", 16, 135, 6);

        terrenos[7][0] = fabricaDeTerreno.criarGrama(7, 0, "Grama", 16, 135, 6);
        terrenos[7][1] = fabricaDeTerreno.criarGrama(timeB.getPeca("Gato"), 7, 1, "Grama", 16, 135, 6);
        terrenos[7][2] = fabricaDeTerreno.criarGrama(7, 2, "Grama", 16, 135, 6);
        terrenos[7][3] = timeB.getTerreno(7, 3);
        terrenos[7][4] = fabricaDeTerreno.criarGrama(7, 4, "Grama", 16, 135, 6);
        terrenos[7][5] = fabricaDeTerreno.criarGrama(timeB.getPeca("Cachorro"), 7, 5, "Grama", 16, 135, 6);
        terrenos[7][6] = fabricaDeTerreno.criarGrama(7, 6, "Grama", 16, 135, 6);

        terrenos[8][0] = fabricaDeTerreno.criarGrama(timeB.getPeca("Tigre"), 8, 0, "Grama", 16, 135, 6);
        terrenos[8][1] = fabricaDeTerreno.criarGrama(8, 1, "Grama", 16, 135, 6);
        terrenos[8][2] = timeB.getTerreno(8, 2);
        terrenos[8][3] = timeB.getTerreno(8, 3);
        terrenos[8][4] = timeB.getTerreno(8, 4);
        terrenos[8][5] = fabricaDeTerreno.criarGrama(8, 5, "Grama", 16, 135, 6);
        terrenos[8][6] = fabricaDeTerreno.criarGrama(timeB.getPeca("Leao"), 8, 6,"Grama", 16, 135, 6);
        
    }

}
