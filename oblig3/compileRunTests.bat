:: File made to compile all the classes in oblig3, IN1010, and then run it.
ECHO off
rm *.class
javac Liste.java
javac Lenkeliste.java
javac Stabel.java
javac TestLenkeliste.java
javac TestStabel.java
java TestStabel
