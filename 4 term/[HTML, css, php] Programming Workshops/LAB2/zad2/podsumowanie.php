<?php
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo '<p>Brak danych do wyświetlenia. Proszę wypełnić formularz.</p>';
    exit;
}

$people = htmlspecialchars($_POST['people'] ?? '');
$firstName = htmlspecialchars($_POST['first_name'] ?? '');
$lastName = htmlspecialchars($_POST['last_name'] ?? '');
$address = htmlspecialchars($_POST['address'] ?? '');
$email = htmlspecialchars($_POST['email'] ?? '');
$card = htmlspecialchars($_POST['card'] ?? '');
$arrivalDate = htmlspecialchars($_POST['arrival_date'] ?? '');
$arrivalTime = htmlspecialchars($_POST['arrival_time'] ?? '');
$childBed = isset($_POST['child_bed']) ? 'Tak' : 'Nie';
$amenities = $_POST['amenities'] ?? [];
?>
<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>Podsumowanie rezerwacji</title>
    <link rel="stylesheet" href="css/rezerwacja.css">
</head>

<body>
    <div class="container">
        <h1>Podsumowanie rezerwacji</h1>

        <p><strong>Ilość osób:</strong> <?= $people ?></p>
        <p><strong>Imię:</strong> <?= $firstName ?></p>
        <p><strong>Nazwisko:</strong> <?= $lastName ?></p>
        <p><strong>Adres:</strong> <?= $address ?></p>
        <p><strong>Email:</strong> <?= $email ?></p>
        <p><strong>Numer karty kredytowej:</strong> <?= $card ?></p>
        <p><strong>Data przyjazdu:</strong> <?= $arrivalDate ?></p>
        <p><strong>Godzina przyjazdu:</strong> <?= $arrivalTime ?: 'Nie podano' ?></p>
        <p><strong>Dostawka dla dziecka:</strong> <?= $childBed ?></p>
        <p><strong>Udogodnienia:</strong>
            <?php
            if (!empty($amenities)) {
                echo htmlspecialchars(implode(', ', $amenities));
            } else {
                echo 'Brak';
            }
            ?>
        </p>

        <div class="footer">Dziękujemy za rezerwację!</div>
    </div>
</body>

</html>