package com.example.app;

import java.lang.invoke.LambdaMetafactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BankImpl implements Bank {
  private final List<Account> accounts;

  private Long getNextId() {
    if(accounts.isEmpty()) return 1L;
    return accounts.get(accounts.size()-1).getId();
  }

  private Account findAccountById(Long id) {
    Optional<Account> fetchedAccount = accounts
            .stream()
            .filter(account -> Objects.equals(account.getId(), id))
            .findFirst();
    if(fetchedAccount.isEmpty()) throw new AccountIdException();
    return fetchedAccount.get();
  }

  public BankImpl() {
    accounts = new ArrayList<>();
  }

  @Override
  public Long createAccount(String name, String address) {
    Long existingAccountId = findAccount(name, address);
    if(existingAccountId != null) return existingAccountId;

    Account newAccount = new Account(getNextId(), name, address, new BigDecimal("0.0"));
    accounts.add(newAccount);
    return newAccount.getId();
  }

  @Override
  public Long findAccount(String name, String address) {
    Optional<Account> existingAccount = accounts
            .stream()
            .filter(account -> Objects.equals(account.getName(), name) && Objects.equals(account.getAddress(), address))
            .findFirst();

    return existingAccount.map(Account::getId).orElse(null);
  }

  @Override
  public void deposit(Long id, BigDecimal amount) {
    Account account = findAccountById(id);
    account.setBalance(account.getBalance().add(amount));
  }

  @Override
  public BigDecimal getBalance(Long id) {
    Account account = findAccountById(id);
    return account.getBalance();
  }

  @Override
  public void withdraw(Long id, BigDecimal amount) {
    Account account = findAccountById(id);
    if(account.getBalance().compareTo(amount) < 0) throw new InsufficientFundsException();
    account.setBalance(account.getBalance().subtract(amount));
  }

  @Override
  public void transfer(Long idSource, Long idDestination, BigDecimal amount) {
    withdraw(idSource, amount);
    deposit(idDestination, amount);
  }
}
