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
				query = "select f from Festa f left outer join fetch f.aniversariante order by f.id"
			),
                        @NamedQuery
			(	name = "Festa.recuperaFestaEAniversariante",
				query = "select f from Festa f left outer join fetch f.aniversariante where f.id = ?1 order by f.id"
			),   
			@NamedQuery
			(	name = "Festa.recuperaUltimaFesta",
				query = "select f from Festa f where f.aniversariante = ?1 order by f.id desc"
			),			
                        @NamedQuery
			(	name = "Festa.recuperaQtdDeRegistrosDoAniversariante",
				query = "select Count(f) from Festa f where f.aniversariante.id = ?1"                                
			),
                        @NamedQuery
			(	name = "Festa.recuperaQtdDeRegistros",
				query = "select Count(f) from Festa f"                                
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
	private Calendar data;
        //private Time horario;

	// Uma festa possui um aniversariante

	private Aniversariante aniversariante;

	// ********* Construtores *********

	public Festa()
	{
	}

	public Festa(Calendar data, Aniversariante aniversariante)
	{	this.data = data;
                //this.dataFim = dataFim;
                this.aniversariante = aniversariante;
	}

	

	// ********* M�todos do Tipo Get *********
	
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA01")
	@Column(name="festa_id")

	public Long getId()
	{	return id;
	}
        
	@Column(name="festa_datetime")
	@Temporal(TemporalType.DATE)
	public Calendar getData()
	{	return data;
	}
	
	@Transient
	public String getDataMasc()
	{	return Util.calendarToStr(data,"datetime");
	}
       
        
//        @Column(name="festa_horario")
//	@Temporal(TemporalType.DATE)
//	public Time getHorario()
//	{	return horario;
//	}
//	
//	@Transient
//	public String getHorarioMasc()
//	{	return Util.calendarToStr(horario);
//	}
	
	// ********* M�todos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}	

	public void setData(Calendar data)
	{	this.data= data;
	}
        
//        public void setHorario(Calendar dataFim)
//	{	this.data = data;
//	}

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