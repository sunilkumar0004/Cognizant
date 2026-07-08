# PowerShell Script to compile and run JUnit tests locally

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

$junitJar = Join-Path $libDir "junit-4.13.2.jar"
$hamcrestJar = Join-Path $libDir "hamcrest-core-1.3.jar"

# Download JUnit if not exists
if (-not (Test-Path $junitJar)) {
    Write-Output "Downloading JUnit 4.13.2..."
    Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar" -OutFile $junitJar -UserAgent "Mozilla/5.0"
}

# Download Hamcrest if not exists
if (-not (Test-Path $hamcrestJar)) {
    Write-Output "Downloading Hamcrest Core 1.3..."
    Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" -OutFile $hamcrestJar -UserAgent "Mozilla/5.0"
}

# Find all java files
$javaFiles = Get-ChildItem -Path $scriptDir -Filter *.java -Recurse | ForEach-Object { $_.FullName }

# Compile
Write-Output "Compiling Java files..."
$classpath = "$junitJar;$hamcrestJar"
javac -cp $classpath -d $binDir $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed"
    exit 1
}

# Run JUnit tests
Write-Output "Running JUnit tests..."
java -cp "$binDir;$classpath" org.junit.runner.JUnitCore com.exercise.CalculatorTest
