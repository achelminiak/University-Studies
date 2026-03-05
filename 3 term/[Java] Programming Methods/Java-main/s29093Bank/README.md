# Zadanie: Aplikacja Bankowa

Napisz prostą aplikację, która będzie reprezentowała bank. Aplikacja musi być napisana z wykorzystaniem Spring boot i powinna pozwalać naprzeprowadzenie operacji:

- rejestracja klienta -> w trakcie rejestracji podajemy saldo jakie ma mieć klient
  
- zlecenie przelewu -> do zlecenia przelewu potrzebujemy dwóch informacji, identyfikatora klienta 
oraz wartości przelewu. Ta metoda powinna zwracać obiekt z którego odczytamy status transakcji
oraz nowe saldo. Przelew ma być fikcyjny, nie musisz podawać adresata, metoda ma jedynie 
spowodować zmniejszenie salda klienta

- wpłacenie pieniędzy na rachunek -> do wpłacenia pieniędzy potrzebujemy identyfikatora 
użytkownika oraz ilości pieniędzy do wpłacenia. Ta metoda powinna zwracać obiekt z którego 
odczytamy status transakcji oraz nowe saldo.

- odczytanie danych klienta -> do odczytu potrzebujemy jedynie identyfikatora użytkownika
  
Załóżmy, że każda transakcja może mieć jeden z dwóch statusów – ACCEPTED oraz DECLINED. 
Pozostałe statusy wedle własnego uznania. Jeżeli podczas dokonywania płatności klient nie posiada 
wystarczającego salda, bądź klient nie jest zarejestrowany, stosowna informacja powinna zostać 
zwrócona. Podobnie w przypadku wpłacania pieniędzy – jeżeli użytkownik nie jest zarejestrowany w 
banku to nie może wpłacić pieniędzy.

Do powstałej logiki napisz testy jednostkowe (jeżeli jest taka potrzeba to wykorzystaj mocki) oraz 
testy integracyjne.
