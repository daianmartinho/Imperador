package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.Util;

@NamedQueries(
		{	@NamedQuery
			(	name = "Festa.recuperaListaDeFestas",
				query = "select f from Festa f order by f.id"
			),
			@NamedQuery
			(	name = "Festa.recuperaUltimaFesta",
				query = "select f from Festa f where f.aniversariante = ?1 order by f.id desc"
			),
			@NamedQuery
			(	name = "Festa.recuperaFestasDeUmAniversariante",
				query = "select f from Festa f where f.aniversariante = ?1"
			)
		})

/* ==>  Falta acrescentar a busca Lance.recuperaUmLanceComProduto */

		
@Entity
@Table(name="FESTAS")
//@SequenceGenerator(name="SEQUENCIA01", 
//		           sequenceName="SEQ_LANCE",
//		           allocationSize=1)

public class Festa
{	private Long id;
	private String descricao;
	private Calendar dataInicio;
        private Calendar dataFim;

	// Uma festa possui um aniversariante

	private Aniversariante aniversariante;

	// ********* Construtores *********

	public Festa()
	{
	}

	public Festa(String descricao, Calendar dataInicio,Calendar dataFim, Aniversariante aniversariante)
	{	this.descricao = descricao;
		this.dataInicio = dataInicio;
                this.dataFim = dataFim;
                this.aniversariante = aniversariante;
	}

	

	// ********* M�todos do Tipo Get *********
	
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA01")
	@Column(name="festa_id")

	public Long getId()
	{	return id;
	}
        @Column(name="festa_descricao")
	public String getDescricao()
	{	return descricao;
	}
	
	@Column(name="festa_timestamp_inicio")
	@Temporal(TemporalType.DATE)
	public Calendar getDataInicio()
	{	return dataInicio;
	}
	
	@Transient
	public String getDataInicioMasc()
	{	return Util.calendarToStr(dataInicio);
	}
        
        @Column(name="festa_timestamp_fim")
	@Temporal(TemporalType.DATE)
	public Calendar getDataFim()
	{	return dataFim;
	}
	
	@Transient
	public String getDataFimMasc()
	{	return Util.calendarToStr(dataFim);
	}
	
	// ********* M�todos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}

	public void setDescricao(String descricao)
	{	this.descricao = descricao;
	}

	public void setDataInicio(Calendar dataInicio)
	{	this.dataInicio = dataInicio;
	}
        
        public void setDataFim(Calendar dataFim)
	{	this.dataFim = dataFim;
	}

	// ********* M�todos para Associa��es *********

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="festa_aniv_id")
	public Aniversariante getAniversariante()
	{	return aniversariante;
	}
	
	public void setAniversariante(Aniversariante aniversariante)
	{	this.aniversariante = aniversariante;
	}
}	