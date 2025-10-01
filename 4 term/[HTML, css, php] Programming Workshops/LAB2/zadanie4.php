<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prime Checker</title>
</head>
<body>
    <form method="post">
        <input type="number" name="number" required>
        <button type="submit">Check</button>
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $num = $_POST["number"];
        $iterations = 0;
        
        if ($num > 1) {
            if ($num == 2) {
                echo "<p>$num is a prime number</p>";
                echo "<p>Iterations: $iterations</p>";
                exit;
            }
            if ($num % 2 == 0) {
                echo "<p>$num is not a prime number</p>";
                echo "<p>Iterations: 1</p>";
                exit;
            }
            
            $is_prime = true;
            for ($i = 3; $i * $i <= $num; $i += 2) {
                $iterations++;
                if ($num % $i == 0) {
                    $is_prime = false;
                    break;
                }
            }
            echo "<p>$num " . ($is_prime ? "is a prime number" : "is not a prime number") . "</p>";
            echo "<p>Iterations: $iterations</p>";
        } else {
            echo "<p>Integer is not greater than 1</p>";
        }
    }
    ?>
</body>
</html>