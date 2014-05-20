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
            System.err.println("��ȡ�ʼ��Ự����ʱ��������" + e); 
            return false; 
        } 
        try 
        { 
            mimeMsg = new MimeMessage(session); 
            mp = new MimeMultipart(); 
        } 
        catch (Exception e) 
        { 
            System.err.println("����MIME�ʼ�����ʧ�ܣ�" + e); 
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
        System.out.println("����õ��û���������"); 
        username = name; 
        password = pass; 
    } 

    public boolean setSubject(String mailSubject) 
    { 
        System.out.println("�����ʼ����⣡"); 
        try 
        { 
            mimeMsg.setSubject(mailSubject); 
        } 
        catch (Exception e) 
        { 
            System.err.println("�����ʼ����ⷢ������"); 
            return false; 
        } 
        return true; 
    } 

    public boolean setBody(String mailBody) 
    { 
        try 
        { 
            System.out.println("�����ʼ����ʽ"); 
            BodyPart bp = new MimeBodyPart(); 
            bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody, 
                            "text/html;charset=UTF-8"); 
            // �����������ʼ��ı� 
            mp.addBodyPart(bp); 
        } 
        catch (Exception e) 
        { 
            System.err.println("�����ʼ�����ʱ��������" + e); 
            return false; 
        } 
        return true; 
    } 

    public boolean addFileAffix(String filename) 
    { 
        System.out.println("�����ʼ�������" + filename); 
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
            System.err.println("�����ʼ�������" + filename + "��������" + e); 
            return false; 
        } 
        return true; 
    } 

    public boolean setFrom(String from) 
    { 
        System.out.println("���÷����ˣ�"); 
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
        System.out.println("����������"); 
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
        System.out.println("���͸�����"); 
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
            System.out.println("���ڷ����ʼ�...."); 
            Session mailSession = Session.getInstance(props, null); 
            Transport transport = mailSession.getTransport("smtp"); 
            // �����������ʼ������������������֤ 
            transport.connect((String) props.get("mail.smtp.host"), username, password); 
            // �����ʼ� 
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(javax.mail.Message.RecipientType.TO)); 
            System.out.println("�����ʼ��ɹ���"); 
            transport.close(); 
        } 
        catch (Exception e) 
        { 
            System.err.println("�ʼ�����ʧ�ܣ�" + e.getMessage()); 
            e.printStackTrace(); 
            return false; 
        } 
        return true; 
    } 


}