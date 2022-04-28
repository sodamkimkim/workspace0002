package ch03;

import java.util.Iterator;

public class MainTest1 {

	public static void main(String[] args) {
		Television television = new Television();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot robot = new ToyRobot();

//		television.turnOn();
//		refrigerator.turnOn();
//		robot.turnOn();
//		System.out.println("--------------");
//		
//		television.turnOff();
//		refrigerator.turnOff();
//		robot.turnOff();
		
		// 다형성@@
		
		RemoteController[] remoteControllers = new RemoteController[3];
		remoteControllers[0] = television;
		remoteControllers[1] = refrigerator;
		remoteControllers[2] = robot;
		
		 for (int i = 0; i < remoteControllers.length; i++) {
			 remoteControllers[i].turnOn();
			
		}
		 
		 for (int i = 0; i < remoteControllers.length; i++) {
			 remoteControllers[i].turnOff();
			
		}
	}

}
