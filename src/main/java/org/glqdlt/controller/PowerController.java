package org.glqdlt.controller;

import org.glqdlt.home.servers.domain.ServerConfigProps;
import org.glqdlt.home.servers.domain.server.ServerVO;
import org.glqdlt.home.utill.PingClient;
import org.glqdlt.home.utill.WakeOnLan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/power")
@Controller
public class PowerController {
	private ServerVO svo = ServerConfigProps.GetIns().GetVO();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String PonwerManager() {

		return "/power/manager.jsp";
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public void PonwerStatus() {

		PingClient.SendPing(svo);

	}

	@RequestMapping(value = "/on", method = RequestMethod.POST)
	public void PonwerOn() {
		System.out.println(svo.getIpAddr());
		System.out.println(svo.getMacAddr());
		WakeOnLan.SendMagicPacket(svo);

	}

	@RequestMapping(value = "/off", method = RequestMethod.POST)
	public void PonwerOff() {

	}

	@RequestMapping(value = "/re", method = RequestMethod.POST)
	public void PonwerRestart() {

	}

}
