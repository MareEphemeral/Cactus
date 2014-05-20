package org.cactus.test;

import org.cactus.util.EmailMaker;

public class EmailTest {
	public static void main(String[] args){
  	 EmailMaker themail = new EmailMaker("smtp.163.com");
     String mailbody = "≤‚ ‘email";
     themail.setNeedAuth(true); 
     themail.setSubject("≤‚ ‘emailƒ£øÈ");
     themail.setBody(mailbody);
     themail.setTo("727613525@qq.com");
     themail.setFrom("project_cactus@163.com");
    // themail.addFileAffix("F:/download/email.rar");
     themail.setNamePass("project_cactus@163.com", "Wangsiyuan");
     themail.sendout(); 
	}
}
