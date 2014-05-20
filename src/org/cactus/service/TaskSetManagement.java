package org.cactus.service;

import java.util.List;

import org.cactus.dao.TaskDAO;
import org.cactus.dao.TaskSetDAO;
import org.cactus.pojo.Task;
import org.cactus.pojo.TaskSet;
import org.cactus.util.ErrorCode;

public class TaskSetManagement {
	
	public String createTaskSet(String tasksetName,int creatorID,int projectID)
	{
		String result="ready";
		TaskSetDAO taskSetD=new TaskSetDAO();
		
		try
		{
			taskSetD.InsertTaskSet(tasksetName, projectID, creatorID);
			result="create success";
		}
		catch(Exception ex)
		{
			result="create failed";
		}	
		return result;
	}
	
	public List<TaskSet> getTaskSet(Integer projectID)
	{
		String result="Ready";
		TaskSetDAO taskSeetD=new TaskSetDAO();
		List<TaskSet> taskSetList;
		try{
			taskSetList= taskSeetD.getTaskSetByProject(projectID);
			result="Get Success";
			return taskSetList;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
}
