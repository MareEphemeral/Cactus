package org.cactus.dao;

import java.util.Date;
import java.util.List;

import org.cactus.pojo.*;
import org.cactus.util.SQLCommand;
import org.cactus.util.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MessageDAO {

	public void InsertMessage(int senderID, int receiverID, int messageLevel,
			Date timestamp, String messageBody)
	{
		Session session = null;
        Transaction tx = null;
        Message message = new Message(senderID, receiverID, messageLevel,timestamp,messageBody);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(message);
            tx.commit ();
        }catch(Exception e){
        	if (tx!=null) {
                tx.rollback();
            }
        }finally{  
            SessionFactory.closeSession();
        }        
	}
	
	
	 public List<Message> getMyMessage(int userID){
	        Session session = null;
	        Transaction tx = null;
	        List<Message> messageList = null;
	        try {
	            session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            Query query = session.createQuery(SQLCommand.FIND_MY_MESSAGE);
	            query.setInteger(0, userID);
	            messageList=query.list();
	         // task = (Task)query.uniqueResult();
	            query = null;
	            tx.commit ();
	        }catch(Exception e){
	        	if (tx!=null) {
	                tx.rollback();
	            }
	        }finally{  
	            SessionFactory.closeSession();
	        }
	        return messageList;
	    }
	 
	 public void DeleteMessage(Integer messageID)
		{
			Session session = null;
	        Transaction tx = null;
	        Message message = new Message();
	        message.setID(messageID);
	        try {
	        	session = SessionFactory.currentSession();
	            tx = session.beginTransaction();
	            session.delete(message);
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
