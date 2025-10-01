<?php
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo '<p>Brak danych do wyświetlenia. Proszę wypełnić formularz.</p>';
    exit;
}

$people = (int) ($_POST['people'] ?? 0);
$firstName = htmlspecialchars($_POST['first_name'] ?? '');
$lastName = htmlspecialchars($_POST['last_name'] ?? '');
$address = htmlspecialchars($_POST['address'] ?? '');
$email = htmlspecialchars($_POST['email'] ?? '');
$card = htmlspecialchars($_POST['card'] ?? '');
$arrivalDate = htmlspecialchars($_POST['arrival_date'] ?? '');
$arrivalTime = htmlspecialchars($_POST['arrival_time'] ?? '');
$childBed = isset($_POST['child_bed']) ? 'Tak' : 'Nie';
$amenities = $_POST['amenities'] ?? [];

$personFirstNames = $_POST['person_first_name'] ?? [];
$personLastNames = $_POST['person_last_name'] ?? [];

if (count($personFirstNames) !== $people || count($personLastNames) !== $people):
    ?>
    <!DOCTYPE html>
    <html lang="pl">

    <head>
        <meta charset="UTF-8" />
        <title>Uzupełnij dane osób</title>
        <link rel="stylesheet" href="css/uzupelnij-osoby.css" />
    </head>

    <body>
        <main>
            <form method="post" action="zadanie3.php">
                <h2>Uzupełnij dane osób w rezerwacji</h2>

                <input type="hidden" name="people" value="<?= $people ?>">
                <input type="hidden" name="first_name" value="<?= $firstName ?>">
                <input type="hidden" name="last_name" value="<?= $lastName ?>">
                <input type="hidden" name="address" value="<?= $address ?>">
                <input type="hidden" name="email" value="<?= $email ?>">
                <input type="hidden" name="card" value="<?= $card ?>">
                <input type="hidden" name="arrival_date" value="<?= $arrivalDate ?>">
                <input type="hidden" name="arrival_time" value="<?= $arrivalTime ?>">
                <?php if ($childBed === 'Tak'): ?>
                    <input type="hidden" name="child_bed" value="on">
                <?php endif; ?>
                <?php foreach ($amenities as $a): ?>
                    <input type="hidden" name="amenities[]" value="<?= htmlspecialchars($a) ?>">
                <?php endforeach; ?>

                <!-- Formularz uzupełniania danych osób -->
                <?php for ($i = 0; $i < $people; $i++): ?>
                    <fieldset>
                        <legend>Osoba <?= $i + 1 ?></legend>
                        <label>Imię: <input type="text" name="person_first_name[]" required></label>
                        <label>Nazwisko: <input type="text" name="person_last_name[]" required></label>
                    </fieldset>
                <?php endfor; ?>

                <button type="submit">Dalej →</button>
            </form>
        </main>
    </body>

    </html>

    <?php
    exit;
endif;
?>

<!-- Podsumowanie rezerwacji -->
<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8" />
    <title>Podsumowanie rezerwacji</title>
    <link rel="stylesheet" href="css/rezerwacja.css" />
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

        <h2>Lista wszystkich osób w rezerwacji:</h2>
        <?php for ($i = 0; $i < $people; $i++): ?>
            <p><strong>Osoba <?= $i + 1 ?>:</strong>
                <?= htmlspecialchars($personFirstNames[$i] ?? '') ?>     <?= htmlspecialchars($personLastNames[$i] ?? '') ?>
            </p>
        <?php endfor; ?>

        <div class="footer">Dziękujemy za rezerwację!</div>
    </div>
</body>

</html>