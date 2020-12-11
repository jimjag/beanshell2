March 13, 2018

* Update [2.1.9](https://github.com/pejobo/beanshell2/raw/v2.1/dist/bsh-2.1.9.jar)
  * Drop of all remote code execution capabilities
  * Restricting (de)serialization for security reasons (the serialization feature may be dropped in one  of the next
  releases) [#109](https://github.com/pejobo/beanshell2/issues/109)
  * Ability to run with Java-9 and Java-10 with restricted module access (jvm flag _--illegal-access=deny_).
  * Fixed a deadlock when pasting code into the graphical console 
  * [SHA512](https://raw.githubusercontent.com/pejobo/beanshell2/v2.1/dist/bsh-2.1.9.jar.sha512sum)

Feb. 20, 2014

* Update [2.1.8](https://github.com/pejobo/beanshell2/raw/5b925f056c7a4b192fcd7389c9362d4f43403f70/downloads/bsh-2.1.8.jar)
  * fixes [#97](https://github.com/pejobo/beanshell2/issues/97), 
  [#98](https://github.com/pejobo/beanshell2/issues/98), and
  [#99](https://github.com/pejobo/beanshell2/issues/99) - all variants of a regression introduced with
  [#88](https://github.com/pejobo/beanshell2/issues/88)


Nov. 6, 2013

* Update 2.1.7
  * Another hotfix when running beanshell in a security restricted environment
  * Fix for finally block not executed when an exception is thrown in catch block - thanks to Lorenzo Cameroni for pointing this out and suggesting a fix


Sep. 27, 2013

* Update v2.1.6
  * This release mainly fixes issues of running beanshell in a security restricted environment. This may break existing
   scriptes which define classes with protected methods, constructors or fields or which access inherited protected
   methods, constructors or fields. If your (script) code doesn't explicitly switch on the accessibility mode your 
   script code will break with this update.
   To receive the old behaviour either call `bsh.Capabilities.setAccessibility(true)` in your java code or 
   `setAccessibility(true)` in your script code. This change was done to allow the usage of beanshell2 in security
   restricted environments. See issue [#88](https://github.com/pejobo/beanshell2/issues/88) for code changes.
  * New version number scheme (drop of b for build).


Nov. 21, 2011

* Update v2.1b5, fixing
  * Do-while loop does not check condition on "continue" - issue [#57](https://github.com/pejobo/beanshell2/issues/57)
  * Fixes when using JSR-223 an exception which is thrown for clause that shouldn't be evaluated - issue
   [#60](https://github.com/pejobo/beanshell2/issues/60).

Older downloads are still available at [code.google.com](https://code.google.com/archive/p/beanshell2/downloads)

Other notable changes not mentioned above in contrast to the latest version available at 
[beanshell.org](http://www.beanshell.org) are:
* The support for parsing of java files through the class loader has been dropped. It was considered more harmful than
  helpful.
* The support of Java-5 varargs.
* Support for long string literals: 
  ```
  xml = """<books>
     <book>
        <title>Beanshell2</title>
     </book>
  </books>""""
  ```
* Build-in [jsr-233](https://www.jcp.org/en/jsr/detail?id=223) support (_Scripting for the Java Platform_).

# BeanShell

## Moved from apache-extras.org

On 2015-09-23, the BeanShell repository moved from https://code.google.com/a/apache-extras.org/p/beanshell/ to its new home on https://github.com/beanshell/beanshell/ as Google Code has been discontinued.

BeanShell had previously moved to Apache Extras from http://beanshell.org/, which remains available for older versions.


## Introduction

BeanShell is a small, free, embeddable Java source interpreter with object scripting language features, written in Java. BeanShell dynamically executes standard Java syntax and extends it with common scripting conveniences such as loose types, commands, and method closures like those in Perl and JavaScript.

You can use BeanShell interactively for Java experimentation and debugging as well as to extend your applications in new ways. Scripting Java lends itself to a wide variety of applications including rapid prototyping, user scripting extension, rules engines, configuration, testing, dynamic deployment, embedded systems, and even Java education.

BeanShell is small and embeddable, so you can call BeanShell from your Java applications to execute Java code dynamically at run-time or to provide extensibility in your applications. Alternatively, you can use standalone BeanShell scripts to manipulate Java applications; working with Java objects and APIs dynamically. Since BeanShell is written in Java and runs in the same VM as your application, you can freely pass references to "live" objects into scripts and return them as results.


## License

BeanShell is licensed under the 
[Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0). See [LICENSE](LICENSE) for details, and the [NOTICE](NOTICE) file for required attributions.

Earlier versions of BeanShell (2.0b4 and earlier) were distributed under 
GNU Lesser General Public License (LGPL) and Sun Public License (SPL).
