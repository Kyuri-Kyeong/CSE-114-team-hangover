/* Name: Kyuri Kyeong
 * ID: 111827215
 * Class: CSE 114
 * Assignment: HW 5
 */

public class CheckingAccount extends GeneralAccount implements Savings {
	public CheckingAccount(int accountNumber, String firstName, String lastName, double initialBalance) {
		super(accountNumber, firstName, lastName, "70", initialBalance);
	}
	
	public void checkCashed(double amount) {
		super.withdrawal(amount);
	}
	
	public void pointOfSale(double amount) {
		super.withdrawal(amount);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean addTransaction(Transaction trans) {
		if (trans instanceof SavingsTransaction) {
			if (trans.getBalance >= 0) {
				return super.addTransaction(trans);
			}
		}
		return false;
		}
	
	public String toString() {
		return this.getNumber() + "-" + this.getSuffix() + " " + this.getBalance();
	}
}

