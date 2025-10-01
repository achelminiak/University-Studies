<?php

$start = 20;
$end = 125;

echo "Liczby pierwsze w zakresie $start - $end:" . PHP_EOL;

for ($num = max(2, $start); $num <= $end; $num++) {
    for ($i = 2; $i < $num; $i++) {
        if ($num % $i == 0) {
            break;
        }
    }
    if ($i == $num) {
        echo $num . PHP_EOL;
    }
}

?>
