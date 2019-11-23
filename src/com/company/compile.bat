@echo off

SET ProgFiles86Root=%ProgramFiles(x86)%
IF NOT "%ProgFiles86Root%"=="" GOTO win64
SET ProgFiles86Root=%ProgramFiles%
:win64
echo Looking in %ProgFiles86Root%

echo Compiling %* with JAI...

javac -cp "%ProgFiles86Root%/Sun Microsystems/Java Advanced Imaging 1.1.3/lib/*;." %*

echo Finished.
