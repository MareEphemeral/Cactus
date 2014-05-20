package org.cactus.dao;

import org.cactus.pojo.RProjectUser;
import org.cactus.pojo.RTeamUser;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RTeamUserDAO {
	
	public void InsertMember(Integer teamID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RTeamUser relation = new RTeamUser(teamID,userID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(relation);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	public RTeamUser GetRelation(Integer teamID, Integer userID)
	{
		Session session = null;
        Transaction tx = null;
        RTeamUser relation = null;
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(SQLCommand.FIND_RELATION_BY_TEAM_USER);
            query.setInteger(0, teamID);
            query.setInteger(1, userID);
            relation = (RTeamUser)query.uniqueResult();
            query = null;
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();       
        }     
        return relation;
	}
	
	public void DeleteRelation(Integer relationID)
	{
		Session session = null;
        Transaction tx = null;
        RTeamUser relation = new RTeamUser();
        relation.setID(relationID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.delete(relation);
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
