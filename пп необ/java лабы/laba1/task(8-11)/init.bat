javac -encoding KOI8-R Runner.java
jar cfe archive.jar Runner Runner.class

@Rem Вывод на экран архива
@Rem jar tf archive.jar

java -jar archive.jar 1 2 3
pause