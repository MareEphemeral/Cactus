package org.cactus.dao;

import java.util.List;

import org.cactus.pojo.Group;
import org.cactus.pojo.Team;
import org.cactus.pojo.User;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeamDAO {
	public void InsertTeam(String teamName, String teamIntro, Integer creatorID)
	{
		Session session = null;
        Transaction tx = null;
        Team team = new Team(teamName, teamIntro, creatorID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(team);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	 public Team getTeam(Integer teamID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        Team team = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_TEAM_BY_ID);
	            query.setInteger(0, teamID);
	            team = (Team)query.uniqueResult();
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
	        return team;
	    }
	 
	 public List<User> getUserByTeam(int teamID) throws HibernateException {
	        Session session = null;
	        Transaction tx = null;
	        List<User> userList = null;
	        List temp;
	        try
	        {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_USER_BY_TEAM);
	            query.setInteger(0, teamID);
	            temp=query.list();
	            for (int i=0;i<temp.size();i++){
	            	userList.add((User)((Object[])temp.get(i))[0]) ;
	            }
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
	        return userList;
	    }
	
}
