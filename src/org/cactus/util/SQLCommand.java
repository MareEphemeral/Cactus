package org.cactus.util;

public class SQLCommand {
	
	public static final String FIND_RELATION_BY_USER_TASK="from RUserTask where user_id=? and task_id=?";
	public static final String FIND_RELATION_BY_GROUP_USER="from RGroupUser where group_id=? and user_id=?";
	public static final String FIND_RELATION_BY_PROJECT_USER="from RProjectUser where project_id=? and user_id=?";
	public static final String FIND_RELATION_BY_TEAM_USER="from RTeamUser where team_id=? and user_id=?";
	public static final String FIND_TASK_BY_ID="from Task where task_id=?";
	public static final String FIND_MY_MESSAGE="from Message where receiver_id=?";
	public static final String FIND_TASK_BY_TASKSET="from Task where taskset_id=?";
	public static final String FIND_TASK_BY_USER="from Task as t,RUserTask as r where member_id=? and r.taskID=t.ID";
	public static final String FIND_TASK_BY_NAME="from Task as t,TaskSet as ts,Project as p where task_name=? and project_name=? and taskset_name=? and t.taskSetID=ts.ID and ts.projectID=p.ID";
	public static final String FIND_ALL_TASK_BY_NAME="from Task where task_name=?";
	public static final String GET_ID_BY_TASKSET_NAME="select ID from TaskSet where taskset_name=? and project_id=?";
	public static final String FIND_TASKSET_BY_ID="from Task where taskset_id=?";
	public static final String FIND_TASKSET_BY_PROJECT_ID="from Task where project_id=?";
	public static final String FIND_GROUP_BY_ID="from Group where group_id=?";
	public static final String FIND_GROUP_BY_PROJECT_ID="from Group where project_id=?";
	public static final String FIND_USER_BY_NAME="from User where user_name=?";	
	public static final String FIND_PROJECT_BY_NAME="from Project where project_name=?";	
	public static final String FIND_USER_BY_MAIL="from User where mail=?";
	public static final String FIND_USER_BY_ID="from User where user_id=?";
	public static final String FIND_PROJECT_BY_ID_EM="from Project where project_id=?";
	public static final String FIND_USERINFO_BY_ID="from UserInfo where userinfo_id=?";
	public static final String FIND_USERINFO_BY_USER_ID="from UserInfo where user_id=?";
	public static final String FIND_PROJECT_BY_ID="from Project where creator_id=?";
	public static final String FIND_USER_BY_GROUP="from Group as g,RGroupUser as r where r.groupID=? and r.groupID=g.ID";
	public static final String FIND_USER_BY_TEAM="from Team as t,RTeamUser as r where r.teamID=? and r.teamID=t.ID";
	public static final String FIND_USER_BY_PROJECT="from Project as p,RProjectUser as r where r.projectID=? and r.projectID=p.ID";
	public static final String FIND_PROJECT_BY_USER="from User as u,RProjectUser as r where r.userID=? and r.userID=u.ID";
	public static final String FIND_TEAM_BY_ID="from Team where team_id=?";
	public static final String FIND_TEAM_BY_CREATOR="from Team where creator_id=?";
	public static final String CHECK_AUTHORITY="from Project as p,Group as g ,RGroupUser as r where p.ID=? and r.groupID=g.ID and user_id=? and g.projectID=p.ID";
}
