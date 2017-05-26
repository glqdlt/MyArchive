package org.glqdlt.home.utills;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.glqdlt.home.servers.domain.server.ServerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WakeOnLan {
	
	/**
	 * 이상하게 될 때가 있고 안될 때가 있는 버그가 있음. 일단 해당 기능은 제외하고 개발 시작. 인터페이스는 만들어두자.
	 * @param svo
	 * @return
	 */
	public static boolean SendMagicPacket(ServerVO svo) {

		Logger logger = LoggerFactory.getLogger(WakeOnLan.class);
		
		int PORT = 9;
		String ipAddr = svo.getIpAddr();

		boolean result = false;

		try (DatagramSocket socket = new DatagramSocket()) {
			byte[] macBytes = getMacBytes(svo.getMacAddr());
			byte[] bytes = new byte[6 + 16 * macBytes.length];

			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) 0xff;
			}
			for (int i = 6; i < bytes.length; i += macBytes.length) {
				System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
			}

			InetAddress address = InetAddress.getByName(ipAddr);
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, PORT);

			socket.send(packet);

			logger.debug("Wake packet sent.");
			result = true;
		} catch (Exception e) {
			logger.debug("Failed to send packet");
		}
		return result;

	}

	private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
		byte[] bytes = new byte[6];
		String[] hex = macStr.split("(\\:|\\-)");

		if (hex.length != 6) {
			throw new IllegalArgumentException("Invalid MAC address.");
		}
		try {
			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) Integer.parseInt(hex[i], 16);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid hex digit in MAC address.");
		}
		return bytes;
	}
}
