[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Hdnu-SzS)
# Zadania laboratoryjne: klasy, konstruktory, metody i testy

| Termin oddania   | Punkty |
| ------------ | ------------ |
| 28.04.2024  23:00 | 15 |

--- 
Przekroczenie terminu o **n** zajęć wiąże się z karą:
- punkty uzyskania za realizację zadania są dzielone przez **2<sup>n</sup>**.

--- 


## Zadanie 1 (1 punkt)

Zaimplementuj klasę `Card` reprezentującą pojedynczą kartę do gry z talii kart. 
Klasa powinna przechowywać `wartość` i `kolor`: kier, karo, pik, trefl. W zadaniu użyj typu wyliczeniowego.
Klasa powinna posiadać odpowiednie konstruktory, settery, getery oraz metodę roztrzygającą czy dana karta przebija drugą.

Napisz program testujący (testy jednostkowe), który stworzy trzy różne obiekty klasy `Card` i sprawdzi poprawność działania metod.

## Zadanie 2 (2 punkty)

Zaimplementuj klasę `Student`, do przechowywania `imienia`, `nazwiska`, `numer indeksu` i `obecność` (wyrażonej w procentach) `oceny z POJ` (typu int).
Jeżeli podczas tworzenia obiektu nie zostało przekazane imię i nazwisko, pola powinny być ustawione wartością "Unknown".
Dodaj odpowiednie metody set i get do wszystkich pól klasy. Jeżeli obecnocność jest mniejsza niż 50%, student powinien otrzymać ocenę 2. 
Przetestuj program, tworząc trzy różne obiekty klasy `Student`.

## Zadanie 3 (3 punkty)

Zaimplementuj klasę `MyDate`, która przechowuje informację: `month` (typu int), `day`(typu int) i `year` (type int).
Klasa powinna zawierać konstruktor, który inicjalizuje zmienne, sprawdzając poprawność zakresów (day 0-31, month 0-12, year 1990-2050).
Zaimplementuj methody set i get dla wszystkich pól. 
Dodaj metodę `displayDate`, która wyświetli pola z uwzględnieniem zer nieznaczących oddzielone znakiem "/", np `21/03/2051`.
Przetestuj zaimplementowaną klasę.

## Zadanie 4 (3 punkty)

Zaimplementuj klasę `Clock`. Klasa zawierać będzie pola: `hours, minutes, seconds`. Zmienna `hours` przyjmuje wartości z zakresu 0-23, `minutes` z zakresu 0-59, `seconds` 0-59.
Dodaj trzy konstruktor:
- domyślny - inicjalizuje godzinę 12:00:00;
- konstruktor zawierający trzy parametry: hours, minutes, seconds,
- konstruktor z jednym parametrem - czas w sekundach licząc od północy jest konwertowany do pól: `hours, minutes, seconds`.
Dodaj metody:
- `getHours(), getMinutes(), getSeconds()`, bez parametrów, które zwracają odpowiednie wartości;
- `setHours(), setMinutes(), setSeconds()`, z jednym parametrem, który ustawia odpowiednie wartości;
- `tick()`, bez parametrów, która inkrementuje wartość second o jeden. Przykład: wartość 00:00:01 zamieni się na 00:00:02; wartość 00:59:59 zmieni się na 01:00:00;
- `tickDown()`, zmniejsza wartość sekund o jedno; analogiczna do tick();
- `toString()`, bez parametrów, zwraca reprezentację obiektu w postaci **"[hh-mm-ss]"**, uzupełnioną o nieznaczące zera, na przykład: **"[03:12:56]"**. 
Przetestuj zaimplementowany program. 

##  Zadanie 5 (3 punkty)

Zaimplementuj klasę `Numbers`. Dodaj konstruktor który przyjmuje trzy liczby typu `int`. Dodaj metody:
- `sum()`, zwraca sumę liczb;
- `average()`, zwraca średnią arytmetyczną liczb;
- `min()`, zwraca najmniejszą z liczb;
- `max()`, zwraca największą z liczb;
- `geometric()`, zwraca średnią geometryczną liczb;
Przetestuj zaimplementowany program.

## Zadanie 6 (3 punkty)

Zaimplementuj klasę `Invoice` reprezentującą fakturę dla sklepu. Klasa przechowuje następujące informacje: 
`product_number (typ String)`, `prodcut_description` (typ String), `quantity`(typ int) i` `pricePerItem`(typ double).
 Klasa powinna mieć konstruktor, który umożliwi podanie wszystkich 4 parametrów. Zaimplementuj metody set i get dla każdej zmiennej. 
Dodaj metodę:
- `Amount`, które zwraca iloczyn `quantity` i `pricePerItem`. Jeżeli `pricePerItem` nie jest dodatnia, `Amount` powinien zwrócić 0. 
Jeżeli `quantity` nie jest dodatnie, `Amount` powinna zwrócić 0.
Przetestuj zaimplementowaną klasę.

## UWAGA:
- powyższych zadaniach stosować zasady Clean Code i [SOLID](https://www.samouczekprogramisty.pl/solid-czyli-dobre-praktyki-w-programowaniu-obiektowym/)
- dla implementowanej funkcjonalności przygotuj testy jednostkowe.
