package org.glqdlt.home.servers.domain.server;

public class ServerVO {

	private String serverName;
	private String serverType;
	private String ipAddr;
	private String macAddr;
	private int pingTimeOut;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public int getPingTimeOut() {
		return pingTimeOut;
	}

	public void setPingTimeOut(int pingTimeOut) {
		this.pingTimeOut = pingTimeOut;
	}

	@Override
	public String toString() {

		// return new StringBuilder().append(ipAddr).toString();
		return "ServerVO [serverName=" + serverName + ", serverType=" + serverType + ", ipAddr=" + ipAddr + ", macAddr="
				+ macAddr + ", pingTimeOut=" + pingTimeOut + "]";
	}

	
	
	
}
