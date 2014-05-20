package org.cactus.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.util.Streams;

public class FileOperating {
	
	 public boolean saveFile(String targetUrl, String fileName) {
		    try {
		      URL url = new URL(targetUrl);
		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      DataInputStream in = new DataInputStream(connection.getInputStream());
		      DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
		      byte[] buffer = new byte[4096];
		      int count = 0;
		      while ((count = in.read(buffer)) > 0) {
		        out.write(buffer, 0, count);
		      }
		      out.close();
		      in.close();
		      return true;
		    }
		    catch (Exception e) {
		      return false;
		    }
		  }
	 
	 public boolean uploadFile( String targetUrl,String fileName) {
	
		  try {
		      URL url = new URL(targetUrl);
		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      connection.setDoOutput(true);
		      DataInputStream in = new DataInputStream(new FileInputStream(fileName));
		      DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		      byte[] buffer = new byte[4096];
		      int count = 0;
		      while ((count = in.read(buffer)) > 0) {
		        out.write(buffer, 0, count);
		      }
		      out.close();
		      in.close();
		      return true;
		    }
		    catch (Exception e) {
		      return false;
		    }
	 }
	 
	    public void upload( String targetUrl,String targetFile) {  
	        try {  
	            String boundary = "------WebKitFormBoundaryUey8ljRiiZqhZHBu";  
	            String url =targetUrl;  
	            URL u = new URL(url);  
	            HttpURLConnection conn = (HttpURLConnection) u.openConnection();  
	            conn.setDoOutput(true);  
	            conn.setDoInput(true);  
	            conn.setUseCaches(false);  
	            conn.setRequestMethod("POST");  
	            conn.setRequestProperty("connection", "Keep-Alive");  
	            conn.setRequestProperty("Charsert", "UTF-8");  
	            conn.setRequestProperty("Content-Type",  
	                    "multipart/form-data;boundary=" + boundary);  
	            // 指定流的大小，当内容达到这个值的时候就把流输出  
	            conn.setChunkedStreamingMode(10240);  
	            OutputStream out = new DataOutputStream(conn.getOutputStream());  
	            byte[] end_data = ("\r\n--" + boundary + "--\r\n").getBytes();// 定义最后数据分隔线  
	            List<String> list  = new ArrayList<String>();  
	            list.add(targetFile);   
	            StringBuilder sb = new StringBuilder();  
	            sb.append("--");  
	            sb.append(boundary);  
	            sb.append("\r\n");  
	            sb.append("Content-Disposition: form-data; name=\"username\"");  
	            sb.append("\r\n\r\n");  
	            sb.append("hello word");  
	            out.write(sb.toString().getBytes("utf-8"));  
	            out.write("\r\n".getBytes("utf-8"));  
	              
	            int leng = list.size();  
	            for (int i = 0; i < leng; i++) {  
	                String fname = list.get(i);  
	                File file = new File(fname);  
	                sb = new StringBuilder();  
	                sb.append("--");  
	                sb.append(boundary);  
	                sb.append("\r\n");  
	                sb.append("Content-Disposition: form-data;name=\"file" + i  
	                        + "\";filename=\"" + file.getName() + "\"\r\n");  
	                sb.append("Content-Type:application/octet-stream\r\n\r\n");  
	                byte[] data = sb.toString().getBytes();  
	                out.write(data);  
	                DataInputStream in = new DataInputStream(new FileInputStream(  
	                        file));  
	                int bytes = 0;  
	                byte[] bufferOut = new byte[1024];  
	                while ((bytes = in.read(bufferOut)) != -1) {  
	                    out.write(bufferOut, 0, bytes);  
	                }  
	                out.write("\r\n".getBytes()); // 多个文件时，二个文件之间加入这个  
	                in.close();  
	            }  
	            out.write(end_data);  
	            out.flush();  
	            out.close();
	        } catch (Exception e) {  
	            System.out.println("发送POST请求出现异常！" + e);  
	            e.printStackTrace();  
	        }  
	    }  
	  
	}  
