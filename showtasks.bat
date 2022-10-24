call runcrud.bat
if "%ERRORLEVEL%" == "0" goto website
echo.
echo Runcrud has errors – breaking work
goto fail

:website
start http://localhost:8080/crud/v1/tasks/
if "%ERRORLEVEL%" == "0" goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.