package dao.impl;

import modelo.Aniversariante;
import dao.AniversarianteDAO;

public abstract class AniversarianteDAOImpl
       extends JPADaoGenerico<Aniversariante, Long> implements AniversarianteDAO 
{   
    public AniversarianteDAOImpl()
    { 	super(Aniversariante.class); 
    }
}
