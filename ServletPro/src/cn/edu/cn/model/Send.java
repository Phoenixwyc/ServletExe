package cn.edu.cn.model;

public class Send extends Thread{

	@Override
	public void run() {
		int i = 2;
		// TODO Auto-generated method stub
		while(i-->0) {
			System.out.println("out try " + i);
			try {
				System.out.println("before sleep " + i);
				Thread.sleep(2000);
				System.out.println("after sleep " + i);
				System.out.println("���� " + (i++) + " �ʼ�");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
