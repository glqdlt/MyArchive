package org.glqdlt.home.servers.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ServerConfigProps {

	private ServerVO svo;
	private static ServerConfigProps ins;

	private ServerConfigProps() {

		GetProps();
	}

	private void GetProps() {
		Properties props = new Properties();
		InputStream propsPath = getClass().getResourceAsStream("/props/servers.properties");
		try {
			props.load(propsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		svo = new ServerVO();
		svo.setIpAddr(props.get("ipAddr").toString());
		svo.setMacAddr(props.get("macAddr").toString());
		svo.setPingTimeOut(Integer.parseInt(props.get("pingTimeOut").toString()));
		svo.setServerName(props.get("serverName").toString());
		svo.setServerType(props.get("serverType").toString());

	}

	public static ServerConfigProps GetIns() {
		if (ins == null) {
			ins = new ServerConfigProps();
		}
		return ins;
	}

	public ServerVO GetVO() {

		return svo;
	}

	
}
