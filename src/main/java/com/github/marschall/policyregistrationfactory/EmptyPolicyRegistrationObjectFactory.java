package com.github.marschall.policyregistrationfactory;

import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import org.jboss.security.authorization.PolicyRegistration;

/**
 * Creates a {@link PolicyRegistration} that always throws an
 * {@link UnsupportedOperationException}. Useful for cases when a
 * {@link PolicyRegistration} is not needed but a lookup happens
 * anyway.
 */
public class EmptyPolicyRegistrationObjectFactory implements ObjectFactory {

  private static final PolicyRegistration POLICY_REGISTRATION = new EmptyPolicyRegistration();

  @Override
  public PolicyRegistration getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) {
    return POLICY_REGISTRATION;
  }

  static final class EmptyPolicyRegistration implements PolicyRegistration {

    @Override
    public void registerPolicy(String contextID, String type, URL location) {
      throw new UnsupportedOperationException();

    }

    @Override
    public void registerPolicy(String contextID, String type, InputStream stream) {
      throw new UnsupportedOperationException();

    }

    @Override
    public void registerPolicyConfigFile(String contextId, String type, InputStream stream) {
      throw new UnsupportedOperationException();

    }

    @Override
    public <P> void registerPolicyConfig(String contextId, String type, P policyConfig) {
      throw new UnsupportedOperationException();

    }

    @Override
    public void deRegisterPolicy(String contextID, String type) {
      throw new UnsupportedOperationException();

    }

    @Override
    public <T> T getPolicy(String contextID, String type, Map<String, Object> contextMap) {
      throw new UnsupportedOperationException();
    }

  }

}
