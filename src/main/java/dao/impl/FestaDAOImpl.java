package dao.impl;

import modelo.Festa;
import dao.FestaDAO;

public abstract class FestaDAOImpl 
	extends JPADaoGenerico<Festa, Long> implements FestaDAO
{
	public FestaDAOImpl() 
	{	super(Festa.class);		
	}
}
