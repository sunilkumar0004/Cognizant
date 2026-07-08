# PowerShell Script to run and verify Banking API Gateway exercises

$scriptDir = $PSScriptRoot
Push-Location $scriptDir

$mavenDir = Join-Path $scriptDir "maven"
$mvnCmd = Join-Path $mavenDir "apache-maven-3.9.6\bin\mvn.cmd"

# Re-use sibling Maven if already downloaded
$siblingMvnCmd = Join-Path $scriptDir "..\..\JUnit, Mockito and SL4J\JUnit_Spring Test exercises\maven\apache-maven-3.9.6\bin\mvn.cmd"
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

Write-Output "Running Maven compilation and testing for all 5 submodules..."
& $mvnCmd clean test -f (Join-Path $scriptDir "pom.xml")

if ($LASTEXITCODE -ne 0) {
    Write-Error "Maven build or testing failed"
    Pop-Location
    exit 1
}

Write-Output "`n=========================================================="
Write-Output "All 5 Banking Microservices Submodules compiled & tested successfully!"
Write-Output "=========================================================="

Pop-Location
