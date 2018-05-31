public class CheckingAccount extends GeneralAccount implements Savings {
	public CheckingAccount(int accountNumber, String firstName, String lastName, double initialBalance) {
		super(accountNumber, firstName, lastName, "70", initialBalance);
	}

	public int getAccountNumber() {
		return super.getNumber();
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
			switch (trans.getTransactionType()) { 
			case Deposit: {this.deposit(trans.getAmount());}
			case Withdrawal: {this.withdrawal(trans.getAmount());}
			case Interest: {this.interest(trans.getAmount());}
			case CheckCashed: {this.checkCashed(trans.getAmount());}
			case PointOfSale: {this.pointOfSale(trans.getAmount());}
			}
		} else {return false;}
		return super.addTransaction(trans);}

	public String toString() {
		return this.getNumber() + "-" + this.getSuffix() + " " + this.getBalance();
	}
}

