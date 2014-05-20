package org.cactus.service;

import java.util.Date;
import java.util.List;

import org.cactus.dao.RUserTaskDAO;
import org.cactus.dao.TaskDAO;
import org.cactus.dao.UserDAO;
import org.cactus.dao.UserInfoDAO;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.util.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskManagement {

	public TaskManagement(){};
	
	public List<Task> getMyTask(Integer myID)
	{
		String result="Ready";
		TaskDAO taskD=new TaskDAO();
		List<Task> taskList;
		try{
			taskList= taskD.getTaskByUser(myID);
			result="Get Success";
			return taskList;
		}
		catch(Exception ex)
		{
			result="Get Failed";
			return null;
		}	
	}
	
	public String CreateNewTask(String taskName, Date deadline,Date createTime,Integer process,Integer tasksetID, String taskDesc,Integer creatorID,Integer state)
	{
		String result="Ready";
		TaskDAO taskD=new TaskDAO();
		try{
			taskD.InsertTask(taskName, deadline, createTime, process, tasksetID, taskDesc, creatorID,state);
			result="Create Success";
		}
		catch(Exception ex)
		{
			result="Create Failed";
		}	
		return result;
	}
	
	public String finishTask(Integer taskID)
	{
		String result="Ready";
		TaskDAO taskD=new TaskDAO();
		Task oldTask =new Task();
		oldTask=taskD.getTaskByID(taskID);
		oldTask.setState(4);
		try{
			taskD.UpdateTask(taskID, oldTask.getTaskName(), oldTask.getCareateTime(),
						     oldTask.getDeadline(), oldTask.getProgress(), oldTask.getTaskSetID(),
							 oldTask.getTaskDesc(), oldTask.getCreatorID(),oldTask.getState());
			result="Update Success";
		}
		catch(Exception ex)
		{
			result="Update Failed";
		}	
		return result;
	}
	
	public String ReportFinish(Integer taskID,Integer userID)
	{
		Integer taskCreator=-1;
		String result="Ready";
		String userName="";
		String taskName="";
		
		MessageManagement messageM=new MessageManagement();
		TaskManagement taskM=new TaskManagement();
		UserManagement userM=new UserManagement();

		userName=userM.getMyInfomationByName(userID).getUserName();
		taskName=taskM.GetTaskByID(taskID).getTaskName();	
		taskCreator=taskM.GetTaskByID(taskID).getCreatorID();
		
	    try{
			result="Add Member Success";
		    messageM.SendMessage(userID, taskCreator, 1, new Date(), userName+"apply for finish task:"+taskName);
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	
	}
	
	public String DeleteMember(Integer memberID,Integer taskID)
	{
		String result="Ready";
		Integer relationID = -1;
		RUserTaskDAO relationD=new RUserTaskDAO();
		relationID = relationD.GetRelation(taskID, memberID).getID();
		if (relationID==-1)
		{
			result="Delete Member Failed";
			
		}
		else
		{
			relationD.DeleteRelation(relationID);
			result="Delete Member Success";
		}
		return result;
	}
	
	public String AddMember(Integer memberID,Integer taskID)
	{
		String result="Ready";
		RUserTaskDAO relationD=new RUserTaskDAO();
		try{
			relationD.InsertMember(taskID, memberID);
			result="Add Member Success";
		}
		catch(Exception ex)
		{
			result="Add Member Failed";
		}
		return result;
	}
	
	
	
	public Task GetTaskByTaskName(String taskName)
	{
		TaskDAO taskD=new TaskDAO();
		Task task=taskD.getTaskByName(taskName);
		return task;
	}
	
	public Task GetTaskByID(Integer taskID)
	{
		TaskDAO taskD=new TaskDAO();
		Task task=taskD.getTaskByID(taskID);
		return task;
	}
	
	public String reportProcess(Integer taskID,Integer progress)
	{
		String result="Ready";
		TaskDAO taskD=new TaskDAO();
		Task oldTask =new Task();
		oldTask=taskD.getTaskByID(taskID);
		oldTask.setProgress(progress);
		
		
		try{
			taskD.UpdateTask(taskID, oldTask.getTaskName(), oldTask.getCareateTime(),
						     oldTask.getDeadline(), oldTask.getProgress(), oldTask.getTaskSetID(),
							 oldTask.getTaskDesc(), oldTask.getCreatorID(),oldTask.getState());
			result="Update Success";
		}
		catch(Exception ex)
		{
			result="Update Failed";
		}	
		return result;
	}
	
}
