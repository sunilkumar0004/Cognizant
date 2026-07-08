# PowerShell Script to download Maven and run tests for JUnit_Spring Test exercises

$scriptDir = $PSScriptRoot
$mavenDir = Join-Path $scriptDir "maven"
$mvnCmd = Join-Path $mavenDir "apache-maven-3.9.6\bin\mvn.cmd"

# Download and extract Apache Maven if not present
if (-not (Test-Path $mvnCmd)) {
    Write-Output "Downloading Apache Maven 3.9.6..."
    $mavenZip = Join-Path $scriptDir "apache-maven-3.9.6-bin.zip"
    
    # Try downloading using WebRequest with TLS 1.2
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    Invoke-WebRequest -Uri "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip" -OutFile $mavenZip -UserAgent "Mozilla/5.0"
    
    Write-Output "Extracting Apache Maven..."
    if (-not (Test-Path $mavenDir)) {
        New-Item -ItemType Directory -Path $mavenDir | Out-Null
    }
    
    # Extract using Expand-Archive
    Expand-Archive -Path $mavenZip -DestinationPath $mavenDir -Force
    
    # Remove the zip file
    Remove-Item $mavenZip -Force
    Write-Output "Apache Maven installed successfully under $mavenDir"
}

Write-Output "Running tests using Maven..."
# Run maven test
& $mvnCmd clean test -f (Join-Path $scriptDir "pom.xml")

if ($LASTEXITCODE -ne 0) {
    Write-Error "Maven test execution failed"
    exit 1
}

Write-Output "=========================================================="
Write-Output "All Spring Testing Exercises compiled and verified successfully!"
Write-Output "=========================================================="
