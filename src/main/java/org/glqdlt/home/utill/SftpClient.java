package org.glqdlt.home.utill;

import java.io.FileInputStream;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

public class SftpClient {
	
	
	public void sftp() throws Exception {
		JSch jsch = new JSch();
		
		// connect session
		Session session = jsch.getSession("userid","192.168.0.2",  2222);
		session.setPassword("test");
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();

		// sftp remotely
		ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
		channel.connect();

		// ls
		Vector list = channel.ls(".");
		System.out.println("---- ls");
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}

		// lstat
		try {
			SftpATTRS stat = channel.lstat("index.html");
			System.out.println("---- lstat");
			System.out.println(stat);
			System.out.println(stat.getSize());
		} catch (SftpException ex) {
			ex.printStackTrace();
		}

		// get
		channel.get("./index.html", "./index.html.dst");
		// put
		channel.put(new FileInputStream("c:/test.txt"), "test_new.txt");

		channel.disconnect();
		session.disconnect();
	}
	//http://www.gnujava.com/board/article_view.jsp?article_no=5677&board_no=1&table_cd=EPAR01&table_no=01
	//http://www.programkr.com/blog/MUDM0ADMwYT2.html
	//참고
}
