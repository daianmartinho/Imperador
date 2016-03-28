package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.Util;

@NamedQueries(
		{	@NamedQuery
			(	name = "Aniversariante.recuperaUmAniversarianteEFestas",
				query = "select a from Aniversariante a left outer join fetch a.festas where a.id = ?1"
			),
			@NamedQuery
			(	name = "Aniversariante.recuperaListaDeAniversariantes",
				query = "select a from Aniversariante a order by a.id"
			),
			@NamedQuery
			(	name = "Aniversariante.recuperaListaDeAniversariantesEFestas",
				query = "select distinct a from Aniversariante a left outer join fetch a.festas order by a.id asc"
			),
			@NamedQuery
			(	name = "Aniversariante.recuperaAniversariantes",
				query = "select a from Aniversariante a where a.primeiroNome like ?3 order by a.primeiroNome asc"                                
			),
                        @NamedQuery
			(	name = "Aniversariante.recuperaQtdDeRegistros",
				query = "select Count(a) from Aniversariante a where a.primeiroNome like ?1"                                
			)
		})

@Entity
@Table(name="ANIVERSARIANTES")

//@SequenceGenerator(name="SEQUENCIA02", 
//		           sequenceName="SEQ_PRODUTO",
//		           allocationSize=1)

public class Aniversariante
{	private Long id;
	private String primeiroNome;
	private String sobrenome;
        private int sexo;
        private Calendar dataAniversario;
        private String nomeDaMae;
        private String nomeDoPai;	
        private String telefone;
        private String endereco;
        private String email;
        private Calendar dataCadastro;
        

	//  Um Aniversariante possui festas

	private List<Festa> festas = new ArrayList<>();
	
	// ********* Construtores *********

	public Aniversariante()
	{
	}

	public Aniversariante(String primeiroNome,
                       String sobrenome,
                       int sexo,
                       Calendar dataAniversario,
	               String nomeDaMae, 
	               String nomeDoPai,
                       String telefone,
                       String endereco,
                       String email,	                                      
                       Calendar dataCadastro)
	{	this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
                this.sexo = sexo;
                this.dataAniversario = dataAniversario;
		this.nomeDaMae = nomeDaMae;
		this.nomeDoPai = nomeDoPai;
                this.telefone = telefone;
                this.endereco = endereco;
                this.email= email;
                this.dataCadastro = dataCadastro;
	}

	// ********* Métodos do Tipo Get *********

	
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA02")
	@Column(name="aniv_id")

	public Long getId()
	{	return id;
	}
	@Column(name="aniv_primeiro_nome")
	public String getPrimeiroNome()
	{	return primeiroNome;
	}
        @Column(name="aniv_sobrenome")
        public String getSobrenome()
	{	return sobrenome;
	}
        @Column(name="aniv_sexo")
        public int getSexo()
	{	return sexo;
	}
        @Column(name="aniv_data_aniversario")
	@Temporal(TemporalType.DATE)
	public Calendar getDataAniversario()
	{	return dataAniversario;
	}
	
	@Transient
	public String getDataMasc()
	{	return Util.calendarToStr(dataAniversario);
	}
	@Column(name="aniv_nome_da_mae")
	public String getNomeDaMae()
	{	return nomeDaMae;
	}
        
        @Column(name="aniv_nome_do_pai")
        public String getNomeDoPai()
	{	return nomeDoPai;
	}
	@Column(name="aniv_telefone")
        public String getTelefone()
	{	return telefone;
	}
        @Column(name="aniv_endereco")
        public String getEndereco()
	{	return endereco;
	}
        @Column(name="aniv_email")
        public String getEmail()
	{	return email;
	}

        @Column(name="aniv_data_cadastro")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro()
	{	return dataCadastro;
	}
	
	@Transient
	public String getDataCadastroMasc()
	{	return Util.calendarToStr(dataCadastro);
	}


	// ********* Métodos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}
	
	public void setPrimeiroNome(String primeiroNome)
	{	this.primeiroNome = primeiroNome;
	}
	
	public void setSobrenome(String sobrenome)
	{	this.sobrenome = sobrenome;
	}
        
        public void setSexo(int sexo)
	{	this.sexo = sexo;
	}
        
	public void setDataAniversario(Calendar dataAniversario)
	{	this.dataAniversario = dataAniversario;
	}
        
	public void setNomeDaMae(String nomeDaMae)
	{	this.nomeDaMae = nomeDaMae;
	}
        
        public void setNomeDoPai(String nomeDoPai)
	{	this.nomeDoPai = nomeDoPai;
	}
        
        public void setTelefone(String telefone)
	{	this.telefone = telefone;
	}
        
        public void setEndereco(String endereco)
	{	this.endereco = endereco;
	}
        
        public void setEmail(String email)
	{	this.email = email;
	}
	
        public void setDataCadastro(Calendar dataCadastro)
	{	this.dataCadastro = dataCadastro;
	}
	
	
	
	
	// ********* Mï¿½todos para Associaï¿½ï¿½es *********

	@OneToMany(mappedBy = "aniversariante")
	@OrderBy
	/*
	 * Com o atributo mappedBy. Sem ele a  JPA irï¿½ procurar  pela 
	 * tabela PRODUTO_LANCE. Com ele, ao se  tentar recuperar  um  
	 * produto  e  todos  os  seus  lances, o  join de PRODUTO  e 
	 * LANCE irï¿½ acontecer atravï¿½s da chave estrangeira existente
	 * em  LANCE.  
	 */
	public List<Festa> getFestas()
	{	return festas;
	}
	
	public void setFestas(List<Festa> festas)
	{	this.festas = festas;	
	}
}

