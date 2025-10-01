<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Kalkulator</title>
    <link rel="stylesheet" href="css/calculator.css" />
</head>

<body>

    <form method="post">
        <input type="number" name="num1" required>
        <input type="number" name="num2" required>
        <select name="operation">
            <option value="add">+</option>
            <option value="subtract">-</option>
            <option value="multiply">*</option>
            <option value="divide">/</option>
        </select>
        <button type="submit">=</button>
    </form>

    <?php
    require_once 'funkcje.php';

    if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['operation'])) {
        $num1 = $_POST["num1"];
        $num2 = $_POST["num2"];
        $operation = $_POST["operation"];

        switch ($operation) {
            case "add":
                $result = add($num1, $num2);
                $opSymbol = '+';
                break;
            case "subtract":
                $result = subtract($num1, $num2);
                $opSymbol = '-';
                break;
            case "multiply":
                $result = multiply($num1, $num2);
                $opSymbol = '*';
                break;
            case "divide":
                $result = divide($num1, $num2);
                $opSymbol = '/';
                break;
            default:
                $result = "Nieznana operacja";
                $opSymbol = '?';
                break;
        }

        $tekst_do_zapisu = "Operacja: $num1 $opSymbol $num2 = $result";

        if (!zapisz_do_pliku($tekst_do_zapisu)) {
            echo "<p style='color:red;'>Błąd zapisu do pliku.</p>";
        }

        echo "<p>Wynik: " . htmlspecialchars($result) . "</p>";
    }
    ?>

</body>

</html>