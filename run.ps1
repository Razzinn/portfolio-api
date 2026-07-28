# run.ps1 — Avvia il backend caricando le variabili da .env
# Uso: .\run.ps1

$envFile = Join-Path $PSScriptRoot ".env"

if (-not (Test-Path $envFile)) {
    Write-Error "File .env non trovato. Copialo da .env.example e riempilo."
    exit 1
}

# Carica ogni riga KEY=VALUE come variabile d'ambiente del processo corrente
Get-Content $envFile | ForEach-Object {
    $line = $_.Trim()
    if ($line -and -not $line.StartsWith("#")) {
        $parts = $line -split "=", 2
        if ($parts.Length -eq 2) {
            [System.Environment]::SetEnvironmentVariable($parts[0].Trim(), $parts[1].Trim(), "Process")
            Write-Host "  SET $($parts[0].Trim())"
        }
    }
}

Write-Host ""
Write-Host "Avvio Spring Boot..."
& "$PSScriptRoot\mvnw.cmd" spring-boot:run
