$exercises = @(
    @{ Path = "SingletonPatternExample"; Main = "singleton.SingletonTest" },
    @{ Path = "FactoryMethodPatternExample"; Main = "factory.FactoryMethodTest" },
    @{ Path = "BuilderPatternExample"; Main = "builder.BuilderTest" },
    @{ Path = "AdapterPatternExample"; Main = "adapter.AdapterTest" },
    @{ Path = "DecoratorPatternExample"; Main = "decorator.DecoratorTest" },
    @{ Path = "ProxyPatternExample"; Main = "proxy.ProxyTest" },
    @{ Path = "ObserverPatternExample"; Main = "observer.ObserverTest" },
    @{ Path = "StrategyPatternExample"; Main = "strategy.StrategyTest" },
    @{ Path = "CommandPatternExample"; Main = "command.CommandTest" },
    @{ Path = "MVCPatternExample"; Main = "mvc.MVCTest" },
    @{ Path = "DependencyInjectionExample"; Main = "di.DITest" }
)

foreach ($ex in $exercises) {
    Write-Output "=============================================="
    Write-Output "Running: $($ex.Path)"
    Write-Output "=============================================="
    
    $srcDir = "Design Patterns and Principle/$($ex.Path)/src"
    $binDir = "Design Patterns and Principle/$($ex.Path)/bin"
    
    if (-not (Test-Path $binDir)) {
        New-Item -ItemType Directory -Path $binDir | Out-Null
    }
    
    # Find all java files
    $javaFiles = Get-ChildItem -Path $srcDir -Filter *.java -Recurse | ForEach-Object { $_.FullName }
    
    # Compile
    javac -d $binDir $javaFiles
    if ($LASTEXITCODE -ne 0) {
        Write-Output "Compilation failed for $($ex.Path)"
        continue
    }
    
    # Run
    java -cp $binDir $($ex.Main)
    Write-Output ""
}
