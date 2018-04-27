:: File made to compile all the classes in oblig2, IN1010, and then run it.
ECHO off
rm *.class
javac Kanal.java
:: javac Hovedprogram.java
:: javac Kryptograf.java
javac Melding.java
javac Monitor.java
javac Operasjonssentral.java
javac Tekster.java
javac Telegrafist.java
javac TestProgram.java
java TestProgram
