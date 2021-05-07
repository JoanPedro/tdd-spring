package com.tdd.spring.firstlook.domain;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class IdGenerators implements IdentifierGenerator {
  @Override
  public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
    return Integer.toUnsignedLong(new Random().nextInt(1000000));
  }
}
