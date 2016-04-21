/* Thiago Klein de Angelis - 1321929
*  Implementação do problema "Jantar dos Filósofos", para materia INF1406 PUC-RIO.
*/
import java.util.concurrent.Semaphore;

enum State {
	Thinking,
	Hungry,
	Eating,
	
}
public class Filosofo implements Runnable {

	private static final int numFilosofos = 5;
	private static State states[] = new State[5];
	private static Semaphore mutex = new Semaphore(1, true);
	private static Semaphore s[] = new Semaphore[5];
	
	
	private int myNum;
	private final int left;
	private final int right;
	
	
	Filosofo(int num) {
		this.myNum = num;
		left = (num+numFilosofos-1)%numFilosofos;
		right = (num+1)%numFilosofos;
		
	}
	
	
	void think() {
		try {
			states[myNum] = State.Thinking;
			System.out.println("Filosofo "+myNum+" esta pensando.");
			Thread.sleep(2000);	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	void take_forks() {
		try {
			mutex.acquire(1);
			states[myNum] = State.Hungry;
			System.out.println("Filosofo "+myNum+" esta com fome.");
			test(myNum);
			mutex.release(1);
			s[myNum].acquire(1);
			System.out.println("Filosofo "+myNum+" pegou garfos "+myNum+", "+right+".");

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
	
	
	void put_forks() {
		try {
			mutex.acquire(1);			
			System.out.println("Filosofo "+myNum+" largando garfos "+myNum+", "+right+".");
			states[myNum] = State.Thinking;
			test(left);
			test(right);
			mutex.release(1);
		}
		catch (Exception e){ 
			System.out.println(e.getMessage());
		}
	}
	
	void test(int num) {
		int leftNum = (num+numFilosofos-1)%numFilosofos;
		int rightNum = (num+1)%numFilosofos;
		if (states[num] == State.Hungry && states[leftNum] != State.Eating && states[rightNum] != State.Eating) {
			states[num] = State.Eating;
			s[num].release(1);
		}
	}
	
	@Override
	public void run() {
		while(true) {		//repeat forever
			think();		//philosopher is thinking
			take_forks();	//acquire two forks or block
			eat();			//yum-yum, spaghetti
			put_forks();	//put both forks back on table
		}
		
	}

	static void putAllForks() {
		for (int i = 0 ; i < 5; i++) {
			s[i] = new Semaphore(0, true);;
		}
		
	}
public static void main(String[] args) {
	
	Filosofo f1 = new Filosofo(0);
	Filosofo f2 = new Filosofo(1);
	Filosofo f3 = new Filosofo(2);
	Filosofo f4 = new Filosofo(3);
	Filosofo f5 = new Filosofo(4);
	Filosofo.putAllForks();
	
	(new Thread(f1)).start();
	(new Thread(f2)).start();
	(new Thread(f3)).start();
	(new Thread(f4)).start();
	(new Thread(f5)).start();
	
	return;
}

}

