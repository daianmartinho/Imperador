package visao;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import modelo.Festa;

public class TabelaDeFestasDoAniversarianteModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int COLUNA_NUMERO = 0;
    public static final int COLUNA_DATA = 1;
    private List<Festa> festas;

    public TabelaDeFestasDoAniversarianteModel(List<Festa> festas) {
        this.festas = new ArrayList<>(festas);
    }

    public String getColumnName(int c) {
        String valor = null;
        switch (c) {
            case COLUNA_NUMERO:
                valor = "Número";
                break;

            case COLUNA_DATA:
                valor = "Data";
                break;
        }
        return valor;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return festas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Festa festa = festas.get(rowIndex);
        Object valor = null;
        
        switch (columnIndex) {
            case COLUNA_NUMERO:
                valor = festa.getId();
                break;
            case COLUNA_DATA:
                valor = festa.getDataMasc();
                break;
        }
        return valor;
    }

    // Para que os campos booleanos sejam renderizados como check box.
    // Neste caso, n?o h? campo boleano.
    @Override
    public Class<?> getColumnClass(int c) {
        Class<?> classe = null;
        switch (c) {
            case COLUNA_NUMERO:
                classe = Integer.class;
                break;
            case COLUNA_DATA:
                classe = String.class;
                break;
        }
        return classe;
    }

    // Para que as c?lulas referentes ?s colunas 1 em diante possam ser editadas
    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    public Festa getFestaAt(int row) {
        return festas.get(row);
    }
    
    public void addElement(Festa f) {
        // Adds the element in the last position in the list
        festas.add(f);
        fireTableRowsInserted(festas.size()-1, festas.size()-1);
    }
}
