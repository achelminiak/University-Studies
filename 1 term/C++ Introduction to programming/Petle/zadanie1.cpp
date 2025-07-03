//Napisz program, który wypisze na ekranie wszystkie liczby pierwsze z zadanego zakresu.

#include <iostream>

using namespace std;

int main() {

  int a, b, i, j, liczbadzielnikow=0;

  cout << "Podaj poczatek zakresu: " << endl;
  cin >> a;
  cout << endl;

  cout << "Podaj koniec zakresu: " << endl;
  cin >> b;
  cout << endl;
  cout << "Liczby pierwsze: " << endl;

  for (i=a; i<=b; i++) {
    liczbadzielnikow=0;
    for (j=1; j<=b; j++) {
      if (i%j==0) {
        liczbadzielnikow++;
      }
    }
    if (liczbadzielnikow==2) {
      cout << i << endl;
    }
  }
  return 0;
}
