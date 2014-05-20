package org.cactus.test;

import java.util.Date;
import java.util.List;

import org.cactus.dao.GroupDAO;
import org.cactus.dao.ProjectDAO;
import org.cactus.dao.TaskDAO;
import org.cactus.dao.TaskSetDAO;
import org.cactus.pojo.Project;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.service.GroupTeamManagement;
import org.cactus.service.ProjectManagement;
import org.cactus.service.TeamManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Test {

	public static void main(String[] args) {
		GroupTeamManagement pm=new GroupTeamManagement();
		String a = pm.changeGroup(1, 1, 3);
		if (true){
			String s = "";
			s = "1";
		}
	}

}
