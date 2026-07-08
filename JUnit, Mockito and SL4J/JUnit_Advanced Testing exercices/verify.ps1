# PowerShell Script to compile and run JUnit 5 tests locally

$scriptDir = $PSScriptRoot
$libDir = Join-Path $scriptDir "lib"
$binDir = Join-Path $scriptDir "bin"

# Create directories if they do not exist
if (-not (Test-Path $libDir)) {
    New-Item -ItemType Directory -Path $libDir | Out-Null
}
if (-not (Test-Path $binDir)) {
    New-Item -ItemType Directory -Path $binDir | Out-Null
}

$standaloneJar = Join-Path $libDir "junit-platform-console-standalone-1.10.2.jar"

# Download JUnit 5 Console Standalone Jar if not exists
if (-not (Test-Path $standaloneJar)) {
    Write-Output "Downloading JUnit 5 Console Standalone Launcher..."
    Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar" -OutFile $standaloneJar -UserAgent "Mozilla/5.0"
}

# Find all java files
$javaFiles = Get-ChildItem -Path $scriptDir -Filter *.java -Recurse | ForEach-Object { $_.FullName }

# Compile
Write-Output "Compiling Java files..."
javac -cp $standaloneJar -d $binDir $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed"
    exit 1
}

# Run JUnit 5 tests
Write-Output "Running JUnit 5 tests..."
java -jar $standaloneJar --class-path $binDir --scan-class-path
