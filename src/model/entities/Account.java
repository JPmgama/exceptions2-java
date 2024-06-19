package model.entities;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withdrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withdrawLimit = withDrawLimit;
	}
	
	public void deposit (Double amount) {
		balance += amount;
	}
	public void withdraw (Double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	private void validateWithdraw (Double amount) {
		if(amount > getWithDrawLimit()) {
			throw new BusinessException ("The amount exceeds withdraw limit");
		}
		
		if (amount > getBalance()) {
			throw new BusinessException ("Not enough balance");
		}
	}
}
