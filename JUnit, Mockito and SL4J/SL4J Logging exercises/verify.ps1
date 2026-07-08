# PowerShell Script to run and verify SLF4J Logging exercises

$scriptDir = $PSScriptRoot
Push-Location $scriptDir

$mavenDir = Join-Path $scriptDir "maven"
$mvnCmd = Join-Path $mavenDir "apache-maven-3.9.6\bin\mvn.cmd"

# Re-use sibling Maven if already downloaded
$siblingMvnCmd = Join-Path $scriptDir "..\JUnit_Spring Test exercises\maven\apache-maven-3.9.6\bin\mvn.cmd"
if (Test-Path $siblingMvnCmd) {
    Write-Output "Found sibling Maven installation. Re-using it..."
    $mvnCmd = $siblingMvnCmd
} elseif (-not (Test-Path $mvnCmd)) {
    Write-Output "Downloading Apache Maven 3.9.6..."
    $mavenZip = Join-Path $scriptDir "apache-maven-3.9.6-bin.zip"
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    Invoke-WebRequest -Uri "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip" -OutFile $mavenZip -UserAgent "Mozilla/5.0"
    
    Write-Output "Extracting Apache Maven..."
    if (-not (Test-Path $mavenDir)) {
        New-Item -ItemType Directory -Path $mavenDir | Out-Null
    }
    Expand-Archive -Path $mavenZip -DestinationPath $mavenDir -Force
    Remove-Item $mavenZip -Force
}

# Compile code
Write-Output "Compiling logging exercises project..."
& $mvnCmd compile -f (Join-Path $scriptDir "pom.xml")
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed"
    exit 1
}

# Run Exercise 1
Write-Output "`n--- Executing Exercise 1 (Logging Levels) ---"
& $mvnCmd exec:java "-Dexec.mainClass=com.example.logging.LoggingExample" -f (Join-Path $scriptDir "pom.xml")
if ($LASTEXITCODE -ne 0) {
    Write-Error "Exercise 1 execution failed"
    exit 1
}

# Run Exercise 2
Write-Output "`n--- Executing Exercise 2 (Parameterized Logging) ---"
& $mvnCmd exec:java "-Dexec.mainClass=com.example.logging.ParameterizedLoggingExample" -f (Join-Path $scriptDir "pom.xml")
if ($LASTEXITCODE -ne 0) {
    Write-Error "Exercise 2 execution failed"
    exit 1
}

# Run Exercise 3
Write-Output "`n--- Executing Exercise 3 (Appender Logging) ---"
& $mvnCmd exec:java "-Dexec.mainClass=com.example.logging.AppenderLoggingExample" -f (Join-Path $scriptDir "pom.xml")
if ($LASTEXITCODE -ne 0) {
    Write-Error "Exercise 3 execution failed"
    exit 1
}

# Verify that app.log is created in the target project folder
$logFile = Join-Path $scriptDir "app.log"
if (-not (Test-Path $logFile)) {
    Write-Error "Verification failed: app.log file was not created!"
    exit 1
}

# Verify log file contents
$logContent = Get-Content $logFile -Raw
if (-not ($logContent -like "*Database connection failed!*")) {
    Write-Error "Verification failed: app.log does not contain expected error log lines"
    exit 1
}

Write-Output "`n=========================================================="
Write-Output "All SL4J Logging Exercises executed and verified successfully!"
Write-Output "=========================================================="

Pop-Location
