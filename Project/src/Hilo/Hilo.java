package Hilo;

import Forms.jframe_login;

public class Hilo extends Thread{
	int seg;
	 //Thread tiempo=new Thread();
	 	public void run() {
	 		
				for(seg=5;seg<=100;seg++) {
					jframe_login.progressBar.setValue(seg);
			try {
					Thread.sleep(50);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	 	}
	}
	} 