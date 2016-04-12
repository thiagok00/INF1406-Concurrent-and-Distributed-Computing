
public class Filosofo implements Runnable {

	private static int numFilosofos = 0;
	private static volatile boolean[] forks = {true,true,true,true,true};
	private int myNum;
	
	Filosofo() {
		this.myNum = numFilosofos;
		Filosofo.numFilosofos++;	
	}
	void think() {
		try {
			Thread.sleep(2000);
			System.out.println("Filosofo "+myNum+" esta pensando.");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	void take_fork(int fork) {
		
		while(forks[fork] == false);
	
		forks[fork] = false;	
		System.out.println("Filosofo "+myNum+" pegou garfo "+fork+".");
			
		
	}
	void eat()   {
		System.out.println("Filosofo "+myNum+" começou a comer.");
		try {
			Thread.sleep(2000);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	void put_fork(int fork) {
		forks[fork] = true;
		System.out.println("Filosofo "+myNum+" largou o garfo "+fork+".");
	}
	
	@Override
	public void run() {
		while(true) {
			think();
			take_fork(myNum);
			take_fork((myNum+1) % numFilosofos);
			eat();
			put_fork(myNum);
			put_fork((myNum + 1) % numFilosofos);	
		}
		
	}


	public void mynums() {
		System.out.println(myNum);
	}
public static void main(String[] args) {
	
	Filosofo f1 = new Filosofo();
	Filosofo f2 = new Filosofo();
	Filosofo f3 = new Filosofo();
	Filosofo f4 = new Filosofo();
	Filosofo f5 = new Filosofo();

	(new Thread(f1)).start();
	(new Thread(f2)).start();
	(new Thread(f3)).start();
	(new Thread(f4)).start();
	(new Thread(f5)).start();
	
	return;
}

}

