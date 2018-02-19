:: File made to compile all the classes in oblig2, IN1010, and then run it.
ECHO off
rm *.class
javac Resept.java
javac BlaaResept.java
javac HvitResept.java
javac PResept.java
javac MilitaerResept.java
javac TestResepter.java
java TestResepter
