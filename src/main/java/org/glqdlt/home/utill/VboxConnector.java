package org.glqdlt.home.utill;

//import java.io.IOException;
//
//import org.virtualbox_5_1.ISession;
//import org.virtualbox_5_1.IVirtualBox;
//import org.virtualbox_5_1.VirtualBoxManager;

public class VboxConnector {

	// // http://vboxvmservice.sourceforge.net/
	//
	// // C:\>"c:\Program Files\Sun\xVM VirtualBox\VBoxManage.exe" startvm
	// ubuntu"
	// // -type headless
	//
	// // https://www.vmware.com/support/ws5/doc/ws_learning_cli_vmrun.html
	// // vmware도 virtualbox 처럼 console start down 이 된다.
	// // "C:\Program Files (x86)\VMware\VMware Workstation\vmrun.exe" start
	// // "C:\Users\glqdl\Documents\Virtual Machines\CentOS 64-bit\CentOS
	// // 64-bit.vmx"
	// // shared 예제
	// // "C:\Program Files (x86)\VMware\VMware Workstation\vmrun.exe" -T
	// ws-shared
	// // -h https://127.0.0.1:443/sdk -u glqdlt@naver.com -p ejsglfdnd7@ start
	// // "[ha-datacenter/standard] CentOS 64-bit/CentOS 64-bit.vmx" nogui
	//
	// private static void Cmd() {
	// try {
	// Process oProcess = new ProcessBuilder("cmd", "c:/", "dir", "/?").start();
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public static void main(String[] args) {
	//
	// System.out.println("hello");
	// VirtualBoxManager mgr = VirtualBoxManager.createInstance(null);
	//
	// mgr.connect("http://127.0.0.1:18083", "UserId", "testPw");
	// System.out.println("start");
	// IVirtualBox vbox = mgr.getVBox();
	//
	// vbox.getMachines().forEach((x) -> {
	//
	// try {
	// ISession session = mgr.getSessionObject();
	//
	// /*
	// * powerOn
	// */
	// x.launchVMProcess(session, "headless", null);
	//
	// // Thread.sleep(10000);
	// // session.getConsole().powerDown();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// });
	//
	// mgr.disconnect();
	// mgr.cleanup();
	//
	// try {
	// Thread.sleep(60000);
	// } catch (InterruptedException e) {
	// try {
	// SshClient.ssh();
	// } catch (Exception e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// e.printStackTrace();
	// }
	// }
}