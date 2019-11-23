@echo off

SET ProgFiles86Root=%ProgramFiles(x86)%
IF NOT "%ProgFiles86Root%"=="" GOTO win64
SET ProgFiles86Root=%ProgramFiles%
:win64
echo Looking in %ProgFiles86Root%

echo Executing %* with JAI...

java -cp "%ProgFiles86Root%\Sun Microsystems\Java Advanced Imaging 1.1.3\lib\*;." -Djava.library.path="%ProgFiles86Root%\Sun Microsystems\Java Advanced Imaging 1.1.3\lib" -Xms128m -Xmx512m %*

echo Finished.
