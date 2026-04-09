# Gatling blocking plugin

A plugin that allows running blocking code on virtual threads in Gatling simulations.

```scala
val scn = scenario("test")
    .exec(
      blocking("my blocking code")
        .run(() => someBlockingOperation())
    )
```

## Getting started

In SBT projects, add this dependency:

```scala
libraryDependencies += "com.github.bjansen" %% "gatling-blocking-plugin" % "0.1.0" % Test
```

In Maven projects, add this depedency:

```xml
<dependency>
    <groupId>com.github.bjansen</groupId>
    <artifactId>gatling-blocking-plugin_2.13</artifactId>
    <version>0.1.0</version>
</dependency>
```

##  Example scenarios

Example simulations can be found in 
[JavaDemo](src/test/java/com/github/bjansen/gatling/blocking/JavaDemo.java)
and
[ScalaDemo](src/test/scala/com/github/bjansen/gatling/blocking/ScalaDemo.scala).
