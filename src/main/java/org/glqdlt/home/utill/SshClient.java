package org.glqdlt.home.utill;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshClient {

	// http://www.jcraft.com/jsch/examples/Sudo.java.html
	// http://stackoverflow.com/questions/6770206/what-is-the-difference-between-the-shell-channel-and-the-exec-channel-in-jsc

	Logger logger = LoggerFactory.getLogger(SshClient.class);
	
	public static void ssh() throws Exception {
		JSch jsch = new JSch();

		String rootPw = "test";
		String userPw = "test";

		Session session = jsch.getSession("userId","192.168.0.2",  2222);
		session.setPassword(userPw);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();

		Channel channel = session.openChannel("shell");
		channel.connect();

		OutputStream forChannel = channel.getOutputStream();
		PrintStream cmd = new PrintStream(forChannel, true);
		cmd.println("sudo");
		Thread.sleep(1000);
		cmd.println(rootPw);
		Thread.sleep(1000);
		cmd.println("shutdown -P 00");
		cmd.close();
		InputStream in = channel.getInputStream();
		byte[] tmp = new byte[1024];
		
		while (true) {
			while (in.available() > 0) {
				int i = in.read(tmp, 0, 1024);
				if (i < 0)
					break;
				System.out.print(new String(tmp, 0, i));
			}

			if (channel.isClosed()) {
				System.out.println("exit-status: " + channel.getExitStatus());
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
		}
		channel.disconnect();
		session.disconnect();
	}

}
