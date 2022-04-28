package thread_ex;

class BankAccount {
	private int money = 100_000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금기능
	public synchronized void saveMoney(int money) {
		// 기본값 10만원
		int currentMoney = getMoney();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMoney(currentMoney + money);
		System.out.println("입금 후 계좌 잔액 : " + getMoney());
	}

	// 출금기능
	public void withdraw(int money) {
		
		
		synchronized(this) {
			int currentMoney = getMoney();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setMoney(currentMoney - money);
			System.out.println("출금 후 계좌 잔액 : " + getMoney());
		}
			
		}
		
} // end of class

// 아버지는 세종시에서 일하고 입금함. 
// 네트워크가 느려서 시간이 조금 걸림
class Father extends Thread {
	BankAccount account;

	public Father(BankAccount account) {

		this.account = account;
	}

	@Override
	public void run() {
		account.saveMoney(10_000);
	}
} // end of class

class Mother extends Thread {
	BankAccount account;

	public Mother(BankAccount account) {
		this.account = account;

	}

	@Override
	public void run() {
		account.withdraw(5_000);
	}
}

public class SharedResource {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Father father = new Father(account);
		Mother mother = new Mother(account);
		
		//아버지가 입금합니다.
		father.start();
		
		// 어머니가 출금합니다.
		mother.start();
		
		//10만 5000원이 있어야 한다.
		// 정상처리 금액 : 10만 + 1만 - 0.5만
		
		
	} // end of main
} // end of class
