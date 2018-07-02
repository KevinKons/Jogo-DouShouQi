package view;

import controller.TabuleiroController;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avell
 */
public class TabuleiroTableModel extends DefaultTableModel {

    private JLabel[][] casas = new JLabel[9][7];
    private TabuleiroController controle;

    public void setContoller(TabuleiroController controle) {
        this.controle = controle;
    }

    @Override
    public int getRowCount() {
        if (controle != null) {
            return controle.getQntLinhas();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        if (controle != null) {
            return controle.getQntColunas();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return casas[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        casas[rowIndex][columnIndex] = (JLabel) aValue;
        fireTableStructureChanged();
    }

    public void criarTabuleiro() {
        controle.criarTabuleiro();
        fireTableRowsInserted(getRowCount(), getRowCount());
    }
}
