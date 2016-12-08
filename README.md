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

You need to create a [JBoss module](https://docs.jboss.org/author/display/MODULES/Introduction)

 * put the jar in a `modules/system/layers/base/com/github/marschall/policyregistrationfactory/main` folder (or whatever your [distribution layer](https://developer.jboss.org/wiki/LayeredDistributionsAndModulePathOrganization) is)
 * add a [module.xml](https://github.com/marschall/policy-registration-factory/blob/master/src/main/resources/module.xml)
 * [configure](https://docs.jboss.org/author/display/WFLY10/General+configuration+concepts) the object factory and bind it to a name 


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

