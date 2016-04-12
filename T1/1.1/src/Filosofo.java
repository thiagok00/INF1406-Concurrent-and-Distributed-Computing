import java.util.concurrent.atomic.AtomicBoolean;
/* Implementação com problemas de corrida 
*Exemplo de um deadlock possivel:
*
Filosofo 0 esta pensando.
Filosofo 1 esta pensando.
Filosofo 2 esta pensando.
Filosofo 3 esta pensando.
Filosofo 4 esta pensando.
Filosofo 3 pegou garfo 3.
Filosofo 0 pegou garfo 0.
Filosofo 4 pegou garfo 4.
Filosofo 2 pegou garfo 2.
Filosofo 1 pegou garfo 1.
*
*/
public class Filosofo implements Runnable {

	private static int numFilosofos = 0;
	private static AtomicBoolean forks[] = new AtomicBoolean[5];
	private int myNum;
	
	Filosofo() {
		this.myNum = numFilosofos;
		Filosofo.numFilosofos++;	
	}
	void think() {
		try {
			System.out.println("Filosofo "+myNum+" esta pensando.");
			Thread.sleep(2000);	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	void take_fork(int fork) {
	
		while(forks[fork].compareAndSet(true, false) == false);
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
		System.out.println("Filosofo "+myNum+" largou o garfo "+fork+".");
		forks[fork].set(true);;
		
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
	
	static void putAllForks() {
		for (int i = 0 ; i < 5; i++)
			forks[i] = new AtomicBoolean(true);
		
	}
public static void main(String[] args) {
	
	Filosofo f1 = new Filosofo();
	Filosofo f2 = new Filosofo();
	Filosofo f3 = new Filosofo();
	Filosofo f4 = new Filosofo();
	Filosofo f5 = new Filosofo();
	Filosofo.putAllForks();
	
	(new Thread(f1)).start();
	(new Thread(f2)).start();
	(new Thread(f3)).start();
	(new Thread(f4)).start();
	(new Thread(f5)).start();
	
	return;
}

}

