package org.cactus.service;

import java.util.Date;

import org.cactus.dao.CommentDAO;
import org.cactus.dao.LogDAO;

public class LogManagement {

	public String CreateErrorLog(String errorMessage){		
		String result="Ready";
		LogDAO log=new LogDAO();
		try{
			//logLevel, logBody, logParticipant
			log.InsertLog(1, errorMessage , -1);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
	
	public String CreateActivityLog(String activityMessage,Integer myID){		
		String result="Ready";
		LogDAO log=new LogDAO();
		try{
			//logLevel, logBody, logParticipant
			log.InsertLog(2, activityMessage , myID);
			result="Send Success";
		}
		catch(Exception ex)
		{
			result="Send Failed";
		}	
		return result;
	}
}
