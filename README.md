Policy Registration Factory [![Javadocs](http://www.javadoc.io/badge/com.github.marschall/policy-registration-factory.svg)](http://www.javadoc.io/doc/com.github.marschall/policy-registration-factory) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/policy-registration-factory/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/policy-registration-factory)
===========================

A JNDI ObjectFactory for a PolicyRegistration. This is a work around for [SECURITY-864](https://issues.jboss.org/browse/SECURITY-864).

This used deprecated API that is likely going away with [Elytron](https://docs.jboss.org/author/display/WFLY/WildFly+Elytron+Security).

Two classes are offered

<dl>
  <dt>com.github.marschall.policyregistrationfactory.EmptyPolicyRegistrationObjectFactory</dt>
  <dd>Creates a `PolicyRegistration` that always throws an `UnsupportedOperationException`. Useful for cases when a `PolicyRegistration` is not needed but a lookup happens anyway.</dd>
  <dt>com.github.marschall.policyregistrationfactory.JBossPolicyRegistrationObjectFactory</dt>
  <dd>Creates a new `JBossPolicyRegistration`.</dd>
</dl>


Installation
------------

 * put the jar in a `com/github/marschall/policyregistrationfactory/main` folder
 * add a [module.xml](https://github.com/marschall/policy-registration-factory/blob/master/src/main/resources/module.xml)
