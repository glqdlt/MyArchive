package org.glqdlt.home.utills;

import java.io.IOException;
import java.net.InetAddress;

import org.glqdlt.home.servers.domain.server.ServerVO;

public class PingClient {

	public static boolean SendPing(ServerVO svo) {
		boolean result = false;
		try {
			InetAddress target = InetAddress.getByName(svo.getIpAddr());
			result = target.isReachable(svo.getPingTimeOut());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
		
	}

}
