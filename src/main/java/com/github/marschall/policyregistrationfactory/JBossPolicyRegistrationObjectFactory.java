package com.github.marschall.policyregistrationfactory;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import org.jboss.security.authorization.PolicyRegistration;
import org.jboss.security.plugins.JBossPolicyRegistration;

/**
 * Creates a new {@link JBossPolicyRegistration}.
 */
public class JBossPolicyRegistrationObjectFactory implements ObjectFactory {

  @Override
  public PolicyRegistration getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) {
    return new JBossPolicyRegistration();
  }

}
