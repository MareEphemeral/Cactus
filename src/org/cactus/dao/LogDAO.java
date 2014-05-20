package org.cactus.dao;

import java.util.Date;

import org.cactus.pojo.Comment;
import org.cactus.pojo.Log;
import org.cactus.util.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogDAO {
	public void InsertLog(Integer logLevel, String logBody, Integer logParticipant)
	{
		Session session = null;
        Transaction tx = null;
        Log log = new Log(logLevel, logBody, logParticipant);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(log);
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
