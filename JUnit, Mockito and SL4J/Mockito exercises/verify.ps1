# PowerShell Script to compile and run Mockito tests locally

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

$dependencies = @(
    @{ Name = "junit-platform-console-standalone-1.10.2.jar"; Url = "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar" },
    @{ Name = "mockito-core-5.11.0.jar"; Url = "https://repo1.maven.org/maven2/org/mockito/mockito-core/5.11.0/mockito-core-5.11.0.jar" },
    @{ Name = "byte-buddy-1.14.12.jar"; Url = "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.14.12/byte-buddy-1.14.12.jar" },
    @{ Name = "byte-buddy-agent-1.14.12.jar"; Url = "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/1.14.12/byte-buddy-agent-1.14.12.jar" },
    @{ Name = "objenesis-3.3.jar"; Url = "https://repo1.maven.org/maven2/org/objenesis/objenesis/3.3/objenesis-3.3.jar" }
)

# Download dependencies if they do not exist
foreach ($dep in $dependencies) {
    $targetPath = Join-Path $libDir $dep.Name
    if (-not (Test-Path $targetPath)) {
        Write-Output "Downloading $($dep.Name)..."
        Invoke-WebRequest -Uri $dep.Url -OutFile $targetPath -UserAgent "Mozilla/5.0"
    }
}

# Construct Classpath
$jars = Get-ChildItem -Path $libDir -Filter *.jar | ForEach-Object { $_.FullName }
$classpath = $jars -join ";"

# Find all java files
$javaFiles = Get-ChildItem -Path $scriptDir -Filter *.java -Recurse | ForEach-Object { $_.FullName }

# Compile
Write-Output "Compiling Java files..."
javac -cp $classpath -d $binDir $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed"
    exit 1
}

# Run JUnit 5 tests
Write-Output "Running Mockito & JUnit 5 tests..."
$junitJar = Join-Path $libDir "junit-platform-console-standalone-1.10.2.jar"
$runClasspath = "$binDir;$classpath"

java "-Dnet.bytebuddy.experimental=true" -jar $junitJar --class-path $runClasspath --scan-class-path
