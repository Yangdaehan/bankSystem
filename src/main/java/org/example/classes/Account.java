package org.example.classes;

public class Account {

    private String accountNumber;
    private String name;
    private String pwd;
    private int balance;

    public Account(String accountNumber, String name, String pwd, int balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getBalance() {
        return balance;
    }

    public void printAccounts() {
        System.out.printf("이름 : %s, 계좌번호 : %s, 잔고 : %d\n", name, accountNumber, balance);
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount < balance) {
            this.balance -= amount;

            System.out.println("출금이 완료되었습니다.");
            System.out.printf("잔액은 %s원 입니다.", this.balance);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
