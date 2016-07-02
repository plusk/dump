package o2;

public class Account {
	
	private double balance;
	private double interestRate;
	
	public Account(double startBalance, double startRate) throws IllegalArgumentException{
		if(startBalance < 0 || startRate < 0) {
			throw new IllegalArgumentException("Neither balance nor interest rate may be below 0.");
		}
		else {
			this.balance = startBalance;
			this.interestRate = startRate;
		}
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	public void setInterestRate(double interestRate) throws IllegalArgumentException{
		if(interestRate < 0) {
			throw new IllegalArgumentException("Interest rate may not be below 0.");
		}
		else {
			this.interestRate = interestRate;
		}
	}
	public void deposit(double amount) throws IllegalArgumentException {
		if(amount < 0) {
			throw new IllegalArgumentException("You aren't allowed to deposit a negative number.");
		}
		else {
			this.balance += amount;
		}
	}
	
	public void withdraw(double amount) throws IllegalArgumentException, IllegalStateException {
		if(amount < 0) {
			throw new IllegalArgumentException("You aren't allowed to withdraw a negative number.");
		}
		else {
			if(this.balance - amount < 0) {
				throw new IllegalStateException("Insufficient funds.");
			}
			else {
				this.balance -= amount;
			}
		}
	}
}
