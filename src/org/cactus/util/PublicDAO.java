package org.cactus.util;

import java.util.List;

import org.cactus.pojo.Project;
import org.cactus.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PublicDAO {

	public Object publicSearchByID(Integer ID,String sqlcommand) throws HibernateException {
		  Session session = null;
	      Transaction tx = null;
	      Object result = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(sqlcommand);
	            query.setInteger(0, ID);
	            result = query.uniqueResult();
	            query = null;
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	 
	      return result;
	}
	
	public List<Object> publicAdvancedSearch(String[] types,Object[] paras,String sqlcommand) throws HibernateException {
		  Session session = null;
	      Transaction tx = null;
	      List<Object> result;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(sqlcommand);
	            
	            for (int i=0;i<types.length;i++)
	            {
	            	if (types[i].equals("s"))
	            	{
	            		query.setString(i, (String) paras[i]);
	            	}
	            	if (types[i].equals("i"))
	            	{
	            		query.setInteger(i, (Integer) paras[i]);
	            	}
	            }           
	            result = query.list();
	            query = null;
	            tx.commit ();
	        }catch(HibernateException e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	            throw e;
	        }finally{  
	            SessionFactory.closeSession();
	        }
	 
	      return result;
	}
	
	
	public void publicInsert(Object o)
	{
		Session session = null;
        Transaction tx = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	public void publicDelete(Object o)
	{
		Session session = null;
        Transaction tx = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	
	public void publicUpdate(Object o)
	{
		Session session = null;
        Transaction tx = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
}
