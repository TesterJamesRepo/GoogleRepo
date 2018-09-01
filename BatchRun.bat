set projectPath=C:\Users\admin\workspace\gsbank
cd\
cd %projectPath%
set classpath=%projectPath%\bin;%projectPath%\lib\*;
java org.testng.TestNG testng.xml