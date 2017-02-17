Policy Registration Factory [![Javadocs](http://www.javadoc.io/badge/com.github.marschall/policy-registration-factory.svg)](http://www.javadoc.io/doc/com.github.marschall/policy-registration-factory) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/policy-registration-factory/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/policy-registration-factory)
===========================

A JNDI ObjectFactory for a PolicyRegistration. This is a work around for [SECURITY-864](https://issues.jboss.org/browse/SECURITY-864).

This used deprecated API that is likely going away with [Elytron](https://docs.jboss.org/author/display/WFLY/WildFly+Elytron+Security).

Two classes are offered

<dl>
  <dt>com.github.marschall.policyregistrationfactory.EmptyPolicyRegistrationObjectFactory</dt>
  <dd>Creates a <a href="https://access.redhat.com/webassets/avalon/d/red-hat-jboss-enterprise-application-platform/7.0.0/javadocs/org/jboss/security/authorization/PolicyRegistration.html">PolicyRegistration</a> that always throws an <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html">UnsupportedOperationException</a>. Useful for cases when a <code>PolicyRegistration</code> is not needed but a lookup happens anyway.</dd>
  <dt>com.github.marschall.policyregistrationfactory.JBossPolicyRegistrationObjectFactory</dt>
  <dd>Creates a new <a href="https://access.redhat.com/webassets/avalon/d/red-hat-jboss-enterprise-application-platform/7.0.0/javadocs/org/jboss/security/plugins/JBossPolicyRegistration.html">JBossPolicyRegistration</a>.</dd>
</dl>


Installation
------------

You need to create a [JBoss module](https://docs.jboss.org/author/display/MODULES/Introduction)

 * put the jar in a `${JBOSS_HOME}/modules/system/layers/base/com/github/marschall/policyregistrationfactory/main` folder (or whatever your [distribution layer](https://developer.jboss.org/wiki/LayeredDistributionsAndModulePathOrganization) is)
 * add a [module.xml](https://github.com/marschall/policy-registration-factory/blob/master/src/main/resources/module.xml), you can take the one from the root of the JAR
 * [configure](https://docs.jboss.org/author/display/WFLY10/Naming+Subsystem+Configuration) the object factory and bind it to a name 


```xml
<subsystem xmlns="urn:jboss:domain:naming:2.0">
  <bindings>
    <object-factory
         name="java:/policyRegistration"
         module="com.github.marschall.policyregistrationfactory"
         class="com.github.marschall.policyregistrationfactory.EmptyPolicyRegistrationObjectFactory"/>
  </bindings>
</subsystem>

```

