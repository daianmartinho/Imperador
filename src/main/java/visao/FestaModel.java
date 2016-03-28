package visao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import modelo.Aniversariante;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AniversarianteAppService;
import excecao.ProdutoNaoEncontradoException;
import java.util.Calendar;
import modelo.Festa;
import service.FestaAppService;

public class FestaModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int COLUNA_NUMERO = 0;
    public static final int COLUNA_DESCRICAO = 1;
    public static final int COLUNA_INICIO = 1;
    public static final int COLUNA_FIM = 1;

    private final static int NUMERO_DE_LINHAS_POR_PAGINA = 10;

    //private String[] idades = {"", "até 30 anos", "de 31 a 40 anos", "de 41 a 50 anos", "acima de 50 anos" };
    private static FestaAppService festaAppService;

    static {
        @SuppressWarnings("resource")
        ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

        festaAppService = (FestaAppService) fabrica.getBean("festaAppService");
    }

    private Map<Integer, Festa> cache;
    private int rowIndexAnterior = 0;
    private Integer qtd;
    private long aniversarianteID;

    public FestaModel() {
        this.qtd = null;
        this.cache = new HashMap<>(NUMERO_DE_LINHAS_POR_PAGINA * 4 / 75 / 100 + 2);
    }

    public void setBuscaPorAniversarianteID(long aniversarianteID) {
        this.aniversarianteID = aniversarianteID;
    }

    public String getColumnName(int c) {
        if (c == COLUNA_NUMERO) {
            return "Número";
        }
        if (c == COLUNA_DESCRICAO) {
            return "Descrição";
        }
        if (c == COLUNA_INICIO) {
            return "Início";
        }
        if (c == COLUNA_FIM) {
            return "Fim";
        }

        return null;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        if (qtd == null) {
            qtd = festaAppService.recuperaQtdDeFestasDoAniversariante(aniversarianteID);
        }
        return qtd;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!cache.containsKey(rowIndex)) {

            List<Festa> resultados = festaAppService.recuperaFestasDoAniversariante(aniversarianteID);

            for (int j = 0; j < resultados.size(); j++) {
                Festa festa = resultados.get(j);
                cache.put(0 + j, festa);
            }

        }

        rowIndexAnterior = rowIndex;

        Festa festa = cache.get(rowIndex);

        if (columnIndex == COLUNA_NUMERO) {
            return festa.getId();
        }
        if (columnIndex == COLUNA_DESCRICAO) {
            return festa.getDescricao();
        }
        if (columnIndex == COLUNA_INICIO) {
            return festa.getDataInicioMasc();
        }
        if (columnIndex == COLUNA_FIM) {
            return festa.getDataFimMasc();
        } else {
            return null;
        }
    }

    // Para que os campos booleanos sejam renderizados como check box.
    // Neste caso, n?o h? campo boleano.
    public Class<?> getColumnClass(int c) {
        Class<?> classe = null;
        if (c == COLUNA_NUMERO) {
            classe = Integer.class;
        }
        if (c == COLUNA_DESCRICAO) {
            classe = String.class;
        }
        if (c == COLUNA_INICIO) {
            classe = String.class;
        }
        if (c == COLUNA_FIM) {
            classe = String.class;
        }

        return classe;
    }

    // Para que as c?lulas referentes ?s colunas 1 em diante possam ser editadas
    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    @Override
    public void setValueAt(Object obj, int r, int c) {
        Festa umaFesta = cache.get(r);

        if (c == COLUNA_DESCRICAO) {
            umaFesta.setDescricao((String) obj);
        }
        if (c == COLUNA_INICIO) {
            umaFesta.setDataInicio((Calendar) obj);
        }
        if (c == COLUNA_FIM) {
            umaFesta.setDataFim((Calendar) obj);
        }

        try {
            festaAppService.altera(umaFesta);
        } catch (ProdutoNaoEncontradoException e) {
            e.printStackTrace();
        }
    }
}
