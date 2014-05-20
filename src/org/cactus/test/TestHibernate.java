package org.cactus.test;

import java.awt.Image;
import java.io.Console;
import java.util.Date;

import org.cactus.dao.ProjectDAO;
import org.cactus.dao.TaskDAO;
import org.cactus.dao.TaskSetDAO;
import org.cactus.dao.UserDAO;
import org.cactus.pojo.Task;
import org.cactus.pojo.User;
import org.cactus.service.ProjectManagement;
import org.cactus.service.UserManagement;
import org.cactus.util.FileOperating;
import org.cactus.util.PublicDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class TestHibernate {

	public static void main(String[] args) {

		FileOperating fo=new FileOperating();
		
		//fo.saveFile("http://221.239.199.136:8888/Cactus/pic/userAvatar/1.png", "D:\\1.png");
		fo.upload("http://221.239.199.136:8888/Cactus/pic", "D:\\2.png");
	}

}
