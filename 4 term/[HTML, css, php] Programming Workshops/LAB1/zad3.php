<?php

$n = 20;

$a = 0;
$b = 1;
$fib_tab = [];
for ($i = 0; $i < $n; $i++) {
    $fib_tab[] = $a;
    $temp = $a + $b;
    $a = $b;
    $b = $temp;
}

$count = 1;
foreach ($fib_tab as $num) {
    if ($num % 2 != 0) {
        echo "Linia $count    |    $num\n";
        $count++;
    }
}

?>
