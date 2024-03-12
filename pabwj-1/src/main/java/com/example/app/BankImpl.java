package com.example.app;

import java.math.BigDecimal;

public class BankImpl implements Bank {
  public BankImpl() {
    
  }

  @Override
  public Long createAccount(String name, String address) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
  }

  @Override
  public Long findAccount(String name, String address) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAccount'");
  }

  @Override
  public void deposit(Long id, BigDecimal amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deposit'");
  }

  @Override
  public BigDecimal getBalance(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
  }

  @Override
  public void withdraw(Long id, BigDecimal amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
  }

  @Override
  public void transfer(Long idSource, Long idDestination, BigDecimal amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'transfer'");
  }

}
