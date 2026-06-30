$exercises = @(
    @{ Path = "Exercise 1 - Inventory Management System"; Main = "inventory.InventoryTest" },
    @{ Path = "Exercise 2 - E-commerce Search"; Main = "search.SearchTest" },
    @{ Path = "Exercise 3 - Sorting Orders"; Main = "sorting.SortTest" },
    @{ Path = "Exercise 4 - Employee Management"; Main = "employee.EmployeeTest" },
    @{ Path = "Exercise 5 - Task Management"; Main = "task.TaskTest" },
    @{ Path = "Exercise 6 - Library Management"; Main = "library.LibraryTest" },
    @{ Path = "Exercise 7 - Financial Forecasting"; Main = "finance.ForecastingTest" }
)

foreach ($ex in $exercises) {
    Write-Output "=============================================="
    Write-Output "Running: $($ex.Path)"
    Write-Output "=============================================="
    
    $srcDir = "Algorithms_Data Structures/$($ex.Path)/src"
    $binDir = "Algorithms_Data Structures/$($ex.Path)/bin"
    
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
