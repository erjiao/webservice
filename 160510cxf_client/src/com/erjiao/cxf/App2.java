package com.erjiao.cxf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class App2 {
	public static void main(String[] args) {
		String url = "http://localhost:8080/160510cxf/OrderService";
		try {
			URL u0 = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u0.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(5000);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
			conn.setRequestProperty("SOAPAction", "\"\"");
			OutputStream os = conn.getOutputStream();
			FileInputStream fis = new FileInputStream("F:/ws/out.txt");
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			os.write(bytes);
			os.close();
			if (conn.getResponseCode() == 200) {
				System.out.println("ok");
				FileOutputStream fos = new FileOutputStream("F:/ws/receice.txt");
				InputStream iss = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int len = -1;
				while ((len = iss.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
