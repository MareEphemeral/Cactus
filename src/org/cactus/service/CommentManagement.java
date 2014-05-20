package org.cactus.service;

import java.util.Date;

import org.cactus.dao.CommentDAO;
import org.cactus.dao.MessageDAO;

public class CommentManagement {
	
	public String CreateTopic(Integer userID,String title,Integer taskID){		
		String result="Ready";
		CommentDAO comment=new CommentDAO();
		try{
			comment.InsertComment(1, "", title, userID, taskID, new Date(), -1);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
    
	public String GiveReply(Integer userID,String message,int topicID,Integer taskID){
		String result="Ready";
		CommentDAO comment=new CommentDAO();
		try{
			comment.InsertComment(2, message, "", userID, taskID, new Date(), topicID);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
	
}
