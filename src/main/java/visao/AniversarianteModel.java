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
import java.util.LinkedHashMap;

public class AniversarianteModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int COLUNA_OBJETO = -1;
    public static final int COLUNA_NUMERO = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_SOBRENOME = 2;
    
    private final static int NUMERO_DE_LINHAS_POR_PAGINA = 10;

    //private String[] idades = {"", "at� 30 anos", "de 31 a 40 anos", "de 41 a 50 anos", "acima de 50 anos" };
    private static AniversarianteAppService aniversarianteAppService;

    static {
        @SuppressWarnings("resource")
        ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

        aniversarianteAppService = (AniversarianteAppService) fabrica.getBean("aniversarianteAppService");
    }

    private Map<Integer, Aniversariante> cache;
    private int rowIndexAnterior = 0;
    private Integer qtd;
    private String primeiroNome;

    public AniversarianteModel() {
        this.qtd = null;
        this.cache = new HashMap<>(NUMERO_DE_LINHAS_POR_PAGINA * 4 / 75 / 100 + 2);
    }

    public void setBuscaPorNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getColumnName(int c) {
        if (c == COLUNA_NUMERO) {
            return "N�mero";
        }
        if (c == COLUNA_NOME) {
            return "Nome";
        }
//		if(c == COLUNA_SEXO) return "Sexo";
//		if(c == COLUNA_IDADE) return "Idade";
//		if(c == COLUNA_NEWS_LETTER) return "News Letter";
//		if(c == COLUNA_ACAO) return "A??o";
        return null;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        if (qtd == null) {
            qtd = aniversarianteAppService.recuperaQtdDeRegistros(primeiroNome);
        }
        return qtd;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!cache.containsKey(rowIndex)) {
            if (cache.size() > (NUMERO_DE_LINHAS_POR_PAGINA * 3)) {
                cache.clear();

                if (rowIndex >= rowIndexAnterior) {
                    List<Aniversariante> resultados = aniversarianteAppService.recuperaAniversariantes(rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA - 1), NUMERO_DE_LINHAS_POR_PAGINA * 2, primeiroNome);
                    for (int j = 0; j < resultados.size(); j++) {
                        Aniversariante aniversariante = resultados.get(j);
                        cache.put(rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA - 1) + j, aniversariante);
                    }
                } else {
                    int inicio = rowIndex - NUMERO_DE_LINHAS_POR_PAGINA;
                    if (inicio < 0) {
                        inicio = 0;
                    }
                    List<Aniversariante> resultados = aniversarianteAppService.recuperaAniversariantes(inicio, NUMERO_DE_LINHAS_POR_PAGINA * 2, primeiroNome);

                    for (int j = 0; j < resultados.size(); j++) {
                        Aniversariante aniversariante = resultados.get(j);
                        cache.put(inicio + j, aniversariante);
                    }
                }
            } else if (rowIndex >= rowIndexAnterior) {
                List<Aniversariante> resultados = aniversarianteAppService.recuperaAniversariantes(rowIndex, NUMERO_DE_LINHAS_POR_PAGINA * 2, primeiroNome);

                for (int j = 0; j < resultados.size(); j++) {
                    Aniversariante aniversariante = resultados.get(j);
                    cache.put(rowIndex + j, aniversariante);
                }
            } else {
                int inicio = rowIndex - (NUMERO_DE_LINHAS_POR_PAGINA * 2 - 1);
                if (inicio < 0) {
                    inicio = 0;
                }
                List<Aniversariante> resultados = aniversarianteAppService.recuperaAniversariantes(inicio, NUMERO_DE_LINHAS_POR_PAGINA * 2, primeiroNome);

                for (int j = 0; j < resultados.size(); j++) {
                    Aniversariante aniversariante = resultados.get(j);
                    cache.put(inicio + j, aniversariante);
                }
            }
        }

        rowIndexAnterior = rowIndex;

        Aniversariante aniversariante = cache.get(rowIndex);
        
        if (columnIndex == COLUNA_OBJETO) {
            return aniversariante;
        } else if (columnIndex == COLUNA_NUMERO) {
            return aniversariante.getId();
        } else if (columnIndex == COLUNA_NOME) {
            return aniversariante.getPrimeiroNome();
        } //		else if (columnIndex == COLUNA_SEXO)
        //			return cliente.getSexo();
        //		else if (columnIndex == COLUNA_IDADE)
        //			return idades[cliente.getIdade()];
        //		else if (columnIndex == COLUNA_NEWS_LETTER)
        //			return cliente.isNewsLetter();
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
        if (c == COLUNA_NOME) {
            classe = String.class;
        }
//		if(c == COLUNA_SEXO) classe = String.class;
//		if(c == COLUNA_IDADE) classe = Integer.class;
//		if(c == COLUNA_NEWS_LETTER) classe = Boolean.class;
//		if(c == COLUNA_ACAO) classe = ButtonColumn.class;

        return classe;
    }

    // Para que as c?lulas referentes ?s colunas 1 em diante possam ser editadas
    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    @Override
    public void setValueAt(Object obj, int r, int c) {
        Aniversariante umAniversariante = cache.get(r);

        if (c == COLUNA_NOME) {
            umAniversariante.setPrimeiroNome((String) obj);
        }
        if (c == COLUNA_SOBRENOME) umAniversariante.setSobrenome((String)obj);

//		if(c == COLUNA_IDADE)
//		{
//			if(((String)obj).equals("at? 30 anos"))
//				umCliente.setIdade(1);
//			else if(((String)obj).equals("de 31 a 40 anos"))
//				umCliente.setIdade(2);
//			else if(((String)obj).equals("de 41 a 50 anos"))
//				umCliente.setIdade(3);
//			else if(((String)obj).equals("acima de 50 anos"))
//				umCliente.setIdade(4);
//		}
//		
//		if(c == COLUNA_NEWS_LETTER) umCliente.setNewsLetter((Boolean)obj);
        try {
            aniversarianteAppService.altera(umAniversariante);
        } catch (ProdutoNaoEncontradoException e) {
            e.printStackTrace();
        }
    }
    public void limparCache(){
        this.cache.clear();        
    }
}
