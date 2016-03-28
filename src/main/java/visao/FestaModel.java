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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Festa;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.FestaAppService;

public class FestaModel extends AbstractTableModel {

    private static Logger logger = LogManager.getLogger(FestaModel.class);
    private static final long serialVersionUID = 1L;

    public static final int COLUNA_NUMERO = 0;    
    public static final int COLUNA_DATA = 1;
    public static final int COLUNA_ANIVERSARIANTE = 2;
//    public static final int COLUNA_FIM = 3;

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
        if (c == COLUNA_DATA) {
            return "Data";
        }
        if (c == COLUNA_ANIVERSARIANTE) {
            return "Aniversariante";
        }
//        if (c == COLUNA_FIM) {
//            return "Fim";
//        }

        return null;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        if (qtd == null) {
            qtd = festaAppService.recuperaQtdDeFestas();
        }
        return qtd;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!cache.containsKey(rowIndex)) {
            if (cache.size() > (NUMERO_DE_LINHAS_POR_PAGINA * 3)) {
                cache.clear();

                if (rowIndex >= rowIndexAnterior) {
                    List<Festa> resultados = festaAppService.recuperaFestas(rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA - 1), NUMERO_DE_LINHAS_POR_PAGINA * 2);
                    for (int j = 0; j < resultados.size(); j++) {
                        Festa festa = resultados.get(j);
                        cache.put(rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA - 1) + j, festa);
                    }
                } else {
                    int inicio = rowIndex - NUMERO_DE_LINHAS_POR_PAGINA;
                    if (inicio < 0) {
                        inicio = 0;
                    }
                    List<Festa> resultados = festaAppService.recuperaFestas(inicio, NUMERO_DE_LINHAS_POR_PAGINA * 2);

                    for (int j = 0; j < resultados.size(); j++) {
                        Festa festa = resultados.get(j);
                        cache.put(inicio + j, festa);
                    }
                }
            } else if (rowIndex >= rowIndexAnterior) {
                List<Festa> resultados = festaAppService.recuperaFestas(rowIndex, NUMERO_DE_LINHAS_POR_PAGINA * 2);

                for (int j = 0; j < resultados.size(); j++) {
                    Festa festa = resultados.get(j);
                    cache.put(rowIndex + j, festa);
                }
            } else {
                int inicio = rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA * 2 - 1);
                if (inicio < 0) {
                    inicio = 0;
                }
                List<Festa> resultados = festaAppService.recuperaFestas(inicio, NUMERO_DE_LINHAS_POR_PAGINA * 2);

                for (int j = 0; j < resultados.size(); j++) {
                    Festa festa = resultados.get(j);
                    cache.put(inicio + j, festa);
                }
            }
        }

        rowIndexAnterior = rowIndex;

        Festa festa = cache.get(rowIndex);

        if (columnIndex == COLUNA_NUMERO) {
            return festa.getId();
        }
        if (columnIndex == COLUNA_DATA) {
            return festa.getDataMasc();
        }
        if (columnIndex == COLUNA_ANIVERSARIANTE) {             
            return festa.getAniversariante().getPrimeiroNome();            
        }
//        if (columnIndex == COLUNA_INICIO) {
//            return festa.getDataInicioMasc();
//        }
//        if (columnIndex == COLUNA_FIM) {
//            return festa.getDataFimMasc();
//        } 
        else {
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
        if (c == COLUNA_DATA) {
            classe = String.class;
        }
        if (c == COLUNA_ANIVERSARIANTE) {
            classe = String.class;
        }
//        if (c == COLUNA_FIM) {
//            classe = String.class;
//        }

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

        if (c == COLUNA_DATA) {
            umaFesta.setData((Calendar) obj);
        }
        if (c == COLUNA_ANIVERSARIANTE) {
            umaFesta.setAniversariante((Aniversariante) obj);
        }
//        if (c == COLUNA_FIM) {
//            umaFesta.setDataFim((Calendar) obj);
//        }

        try {
            festaAppService.altera(umaFesta);
        } catch (ProdutoNaoEncontradoException e) {
            e.printStackTrace();
        }
    }
}
