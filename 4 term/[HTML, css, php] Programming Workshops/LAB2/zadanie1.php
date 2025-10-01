<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
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
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $num1 = $_POST["num1"];
        $num2 = $_POST["num2"];
        $operation = $_POST["operation"];
        
        if ($operation == "add") $result = $num1 + $num2;
        if ($operation == "subtract") $result = $num1 - $num2;
        if ($operation == "multiply") $result = $num1 * $num2;
        if ($operation == "divide") $result = ($num2 != 0) ? $num1 / $num2 : "Cannot divide by zero";
        
        echo "<p>Result: $result</p>";
    }
    ?>
</body>
</html>
