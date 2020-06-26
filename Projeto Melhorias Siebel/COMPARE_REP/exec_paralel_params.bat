:: "Siebel Repository" "Siebel Repository" "@QA1SBL8" "@DEV4SBL8" 14/01/2019 34 TIM SADMIN/SADMIN@SIEBELDEV
:: %1 "Siebel Repository"
:: %2 "Siebel Repository"
:: %3 "@QA1SBL8"
:: %4 "@DEV4SBL8"
:: %5 26/11/2018
:: %6 34
:: %7 NV
:: %8 SADMIN/SADMIN@SIEBELDEV

@echo off
cls
setlocal enabledelayedexpansion

if "%6"=="" (goto:eof) else (set _VAR2CHECK=%6)

for /l %%a in (0,1,9) do (
   if defined _VAR2CHECK (set "_VAR2CHECK=!_VAR2CHECK:%%a=!") else (goto :end)
)

:end
if defined _VAR2CHECK (
echo #O parametro de numero de threads nao esta correto (%6)
) else (
	echo #Parametro de numero de threads validado OK (%6)
	sqlplus %8 @PL_COMPARE_REPOSITORY_MASTER.sql %1 %2 %3 %4 %7
::	@echo off
	set loopcount=%6
	:loop
	start sqlplus %8 @PL_COMPARE_REPOSITORY.sql %1 %2 %3 %4 %5 %loopcount% %7
	set /a loopcount=loopcount-1
	if %loopcount%==0 goto exitloop
	goto loop
	:exitloop
	pause
)

set "_VAR2CHECK="
endlocal