@echo off
if not exist out mkdir out
javac -encoding UTF-8 -d out src\composite\*.java test\composite\*.java
echo ===== Programa =====
java -cp out composite.Main
echo.
echo ===== Testes =====
java -cp out composite.TesteComposite
pause
