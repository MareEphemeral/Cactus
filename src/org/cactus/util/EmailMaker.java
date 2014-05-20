package org.cactus.util; 
import java.util.Properties; 
import javax.activation.DataHandler; 
import javax.activation.FileDataSource; 
import javax.mail.*; 
import javax.mail.internet.*; 


public class EmailMaker 
{ 

    private MimeMessage mimeMsg; 
    private Session     session; 
    private Properties  props; 
    private String      username; 
    private String      password; 
    private Multipart   mp; 
    public EmailMaker(String smtp) 
    { 
        username = ""; 
        password = ""; 
        setSmtpHost(smtp); 
        createMimeMessage(); 
    } 

    
    public void setSmtpHost(String hostName) 
    { 
        if (props == null) 
            props = System.getProperties(); 
        props.put("mail.smtp.host", hostName); 
    } 

    
    public boolean createMimeMessage() 
    { 
        try 
        { 
            session = Session.getDefaultInstance(props, null); 
        } 
        catch (Exception e) 
        { 
            System.err.println("获取邮件会话对象时发生错误！" + e); 
            return false; 
        } 
        try 
        { 
            mimeMsg = new MimeMessage(session); 
            mp = new MimeMultipart(); 
        } 
        catch (Exception e) 
        { 
            System.err.println("创建MIME邮件对象失败！" + e); 
            return false; 
        } 
        return true; 
    } 

    
    public void setNeedAuth(boolean need) 
    { 
        if (props == null) 
        { 
            props = System.getProperties(); 
        } 
        if (need) 
            props.put("mail.smtp.auth", "true"); 
        else 
            props.put("mail.smtp.auth", "false"); 
    } 

    public void setNamePass(String name, String pass) 
    { 
        System.out.println("程序得到用户名与密码"); 
        username = name; 
        password = pass; 
    } 

    public boolean setSubject(String mailSubject) 
    { 
        System.out.println("设置邮件主题！"); 
        try 
        { 
            mimeMsg.setSubject(mailSubject); 
        } 
        catch (Exception e) 
        { 
            System.err.println("设置邮件主题发生错误！"); 
            return false; 
        } 
        return true; 
    } 

    public boolean setBody(String mailBody) 
    { 
        try 
        { 
            System.out.println("设置邮件体格式"); 
            BodyPart bp = new MimeBodyPart(); 
            bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody, 
                            "text/html;charset=UTF-8"); 
            // 在组件上添加邮件文本 
            mp.addBodyPart(bp); 
        } 
        catch (Exception e) 
        { 
            System.err.println("设置邮件正文时发生错误！" + e); 
            return false; 
        } 
        return true; 
    } 

    public boolean addFileAffix(String filename) 
    { 
        System.out.println("增加邮件附件：" + filename); 
        try 
        { 
            BodyPart bp = new MimeBodyPart(); 
            FileDataSource fileds = new FileDataSource(filename); 
            bp.setDataHandler(new DataHandler(fileds)); 
            bp.setFileName(fileds.getName()); 
            mp.addBodyPart(bp); 
        } 
        catch (Exception e) 
        { 
            System.err.println("增加邮件附件：" + filename + "发生错误！" + e); 
            return false; 
        } 
        return true; 
    } 

    public boolean setFrom(String from) 
    { 
        System.out.println("设置发信人！"); 
        try 
        { 
            mimeMsg.setFrom(new InternetAddress(from)); 
        } 
        catch (Exception e) 
        { 
            return false; 
        } 
        return true; 
    } 

    public boolean setTo(String to) 
    { 
        System.out.println("设置收信人"); 
        if (to == null) 
            return false; 
        try 
        { 
            mimeMsg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to)); 
        } 
        catch (Exception e) 
        { 
            return false; 
        } 
        return true; 
    } 

    public boolean setCopyTo(String copyto) 
    { 
        System.out.println("发送附件到"); 
        if (copyto == null) 
            return false; 
        try 
        { 
            mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(copyto)); 
        } 
        catch (Exception e) 
        { 
            return false; 
        } 
        return true; 
    } 

    public boolean sendout() 
    { 
        try 
        { 
            mimeMsg.setContent(mp); 
            mimeMsg.saveChanges(); 
            System.out.println("正在发送邮件...."); 
            Session mailSession = Session.getInstance(props, null); 
            Transport transport = mailSession.getTransport("smtp"); 
            // 真正的连接邮件服务器并进行身份验证 
            transport.connect((String) props.get("mail.smtp.host"), username, password); 
            // 发送邮件 
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(javax.mail.Message.RecipientType.TO)); 
            System.out.println("发送邮件成功！"); 
            transport.close(); 
        } 
        catch (Exception e) 
        { 
            System.err.println("邮件发送失败！" + e.getMessage()); 
            e.printStackTrace(); 
            return false; 
        } 
        return true; 
    } 


}