package org.cactus.dao;

import java.util.Date;

import org.cactus.pojo.Comment;
import org.cactus.pojo.Message;
import org.cactus.util.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentDAO {

	public void InsertComment(int commentType, String commentBody, String commentTitle,
			int senderID, int taskID, Date commentTime, int belongTopicID)
	{
		Session session = null;
        Transaction tx = null;
        Comment comment = new Comment(commentType, commentBody, commentTitle, senderID,taskID,commentTime,belongTopicID);
        try {
        	session = SessionFactory.currentSession();
            tx = session.beginTransaction();
            session.save(comment);
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
