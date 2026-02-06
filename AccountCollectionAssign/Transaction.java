package com.tss.AccountCollectionAssign;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Transaction {
    private Integer transactionId;
    private Set<Integer> transactionSet = new HashSet<Integer>();
    private TrasactionType transactionType;
    private Integer senderAccountNumber;
    private Integer receiverAccountNumber;
    private Double amount;
    private Double balanceAfterTransaction;
//    private final LocalDateTime timestamp;


    public Transaction(Integer senderAccountNumber, Integer receiverAccountNumber, TrasactionType trasactionType, Double amount , Double balanceAfterTransaction) {
        Random random = new Random();
        int number = 100 + random.nextInt(900);
        while (transactionSet.contains(number)){
            number = 100 + random.nextInt(900);
        }
        transactionId = number;
        transactionSet.add(number);

        this.transactionType = trasactionType;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
//        this.timestamp = timestamp;
    }

    public Transaction(Integer receiverAccountNumber, TrasactionType trasactionType, Double amount , Double balanceAfterTransaction) {
        Random random = new Random();
        int number = 100 + random.nextInt(900);
        while (transactionSet.contains(number)){
            number = 100 + random.nextInt(900);
        }
        transactionId = number;
        transactionSet.add(number);

        this.transactionType = trasactionType;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
//        this.timestamp = timestamp;
    }

    public Integer getTrasactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer trasactionId) {
        this.transactionId = trasactionId;
    }

    public Set<Integer> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Integer> transactionSet) {
        this.transactionSet = transactionSet;
    }

    public TrasactionType getTransactionType() {
        return transactionType;
    }

    public void setTrasactionType(TrasactionType trasactionType) {
        this.transactionType = trasactionType;
    }

    public Integer getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(Integer senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public Integer getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(Integer receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void displayTransactionDetails(Transaction transaction) {
        int senderAccount = 0;

        if (transaction.getTransactionType().equals(TrasactionType.TRANSFER_IN) || transaction.getTransactionType().equals(TrasactionType.TRANSFER_OUT)) {
            senderAccount = transaction.getSenderAccountNumber();
        }

        System.out.printf(
                "| %-15s | %-15s | %-15s | %-13s | %-10s | %-15s |\n",
                transaction.getTrasactionId(),
//                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                (senderAccount == 0 ? "SELF" : String.valueOf(senderAccount)),
//                transaction.getSenderAccountNumber(),
                transaction.getReceiverAccountNumber(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getBalanceAfterTransaction()
        );
    }

}
