<?php

$fruits = ["jablko", "banan", "pomarancza"];

foreach ($fruits as $fruit) {
    echo $fruit . PHP_EOL;
    
    echo "Zaczyna się na 'p': " . ($fruit[0] === 'p' ? "Tak" : "Nie") . PHP_EOL;
    
    $length = 0;
    while (isset($fruit[$length])) {
        $length++;
    }
    
    for ($i = $length - 1; $i >= 0; $i--) {
        echo $fruit[$i];
    }
    echo PHP_EOL;
}
?>
