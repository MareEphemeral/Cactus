package org.cactus.test;

import java.util.Date;

import org.cactus.dao.ProjectDAO;
import org.cactus.dao.TaskDAO;
import org.cactus.dao.TaskSetDAO;
import org.cactus.pojo.Task;
import org.cactus.service.GroupTeamManagement;
import org.cactus.service.ProjectManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Test {

	public static void main(String[] args) {
		GroupTeamManagement gm=new GroupTeamManagement();
		gm.CreateGroup("aa", new byte[]{0}, 1);

	}

}
