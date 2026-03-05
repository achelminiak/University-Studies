<?php
// Wczytywanie danych
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['load_csv'])) {
    echo '<h2>Lista zapisanych rezerwacji</h2>';
    $plik = 'rezerwacje.csv';
    if (!file_exists($plik)) {
        echo "<p>Brak pliku rezerwacje.csv</p>";
    } else {
        $wiersze = file($plik, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        echo "<table border='1' cellpadding='6'><tbody>";
        foreach ($wiersze as $i => $linia) {
            $komorki = explode(';', $linia);
            echo "<tr>";
            foreach ($komorki as $k) {
                $tag = $i === 0 ? 'th' : 'td';
                echo "<$tag>" . htmlspecialchars($k) . "</$tag>";
            }
            echo "</tr>";
        }
        echo "</tbody></table>";
    }
    echo '<p><a href="zadanie3.php">← Powrót</a></p>';
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && !isset($_POST['load_csv'])) {

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

    // Zapis do CSV
    $plik = 'rezerwacje.csv';
    $nowy = !file_exists($plik);
    $naglowki = [
        'Ilość osób', 'Imię', 'Nazwisko', 'Adres', 'Email', 'Karta', 'Data przyjazdu',
        'Godzina przyjazdu', 'Dostawka', 'Udogodnienia', 'Imiona osób', 'Nazwiska osób'
    ];

    $rekord = [
        $people, $firstName, $lastName, $address, $email, $card, $arrivalDate,
        $arrivalTime ?: 'Nie podano', $childBed, implode(',', $amenities),
        implode(',', $personFirstNames), implode(',', $personLastNames)
    ];

    $fp = fopen($plik, 'a');
    if ($nowy) {
        fputcsv($fp, $naglowki, ';');
    }
    fputcsv($fp, $rekord, ';');
    fclose($fp);
}
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
        <?= !empty($amenities) ? htmlspecialchars(implode(', ', $amenities)) : 'Brak' ?>
    </p>

    <h2>Lista wszystkich osób w rezerwacji:</h2>
    <?php for ($i = 0; $i < $people; $i++): ?>
        <p><strong>Osoba <?= $i + 1 ?>:</strong>
            <?= htmlspecialchars($personFirstNames[$i] ?? '') ?>
            <?= htmlspecialchars($personLastNames[$i] ?? '') ?>
        </p>
    <?php endfor; ?>

    <form method="post" action="zadanie3.php">
        <button type="submit" name="load_csv">📄 Wczytaj zapisane rezerwacje</button>
    </form>

    <div class="footer">Dziękujemy za rezerwację!</div>
</div>
</body>
</html>
