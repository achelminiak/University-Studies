<?php
function add($a, $b) { return $a + $b; }
function subtract($a, $b) { return $a - $b; }
function multiply($a, $b) { return $a * $b; }
function divide($a, $b) {
    if ($b == 0) return "Nie można dzielić przez zero";
    return $a / $b;
}

function zapisz_do_pliku(string $tekst, string $plik = 'dane.txt'): bool {
    return file_put_contents($plik, $tekst . PHP_EOL, FILE_APPEND | LOCK_EX) !== false;
}
?>
