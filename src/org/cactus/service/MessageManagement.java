package org.cactus.service;

import java.util.Date;
import java.util.List;

import org.cactus.dao.MessageDAO;
import org.cactus.dao.RUserTaskDAO;
import org.cactus.dao.UserDAO;
import org.cactus.pojo.Message;

public class MessageManagement {

	public String SendMessage(int senderID, int receiverID, int messageLevel,
			Date timestamp, String messageBody)
	{
		String result="Ready";
		MessageDAO messageD=new MessageDAO();
		try{
			messageD.InsertMessage(senderID, receiverID, messageLevel, timestamp, messageBody);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
	
	public List<Message> ReceiveMyMessage(Integer userID)
	{
		MessageDAO messageD=new MessageDAO();
		return messageD.getMyMessage(userID);
	}
	
	public String DeleteAMessage(Integer messageID)
	{
		String result="Ready";
		MessageDAO messageD=new MessageDAO();
		
		try{
			messageD.DeleteMessage(messageID);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}

}
