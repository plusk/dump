package o1;

public class Account {
	
	public double balance = 0;
	public double interestRate = 15.5;
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0) {
			balance += depositAmount;
		}
	}
	
	public void addInterest() {
		balance *= (1 + (interestRate/100));
	}
	
	public String toString () {
		return "The balance for the account is " + balance + " and the interest rate is " + interestRate;
	}
	
	public static void main(String[] args) {
		
		Account acc = new Account();
		
		System.out.println(acc.toString());
		acc.deposit(100);
		System.out.println(acc.toString());
		acc.addInterest();
		System.out.println(acc.toString());	
		
	}
}