package org.example;

enum Status {
    Opened,
    Closed;
}

public class BankAccount {

    Status status;
    int balance;

    public BankAccount() {
        this.status = Status.Closed;
        this.balance = 0;
    }

    public void open() {
        this.status = Status.Opened;
    }

    public void close() {
        this.status = Status.Closed;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (this.status != Status.Closed) {
            if (amount >= 0) {
                this.balance = balance + amount;
            } else {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (this.status != Status.Closed) {

            if (amount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            if (this.balance == 0) {
                throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
            }
            if (amount <= balance) {
                this.balance = balance - amount;
            } else {
                throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
            }
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (this.status != Status.Closed) {

            return this.balance;
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}
