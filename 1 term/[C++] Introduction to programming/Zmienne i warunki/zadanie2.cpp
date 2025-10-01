//Program prosi o podanie współczynników a i b w równaniu liniowym a*x + b = 0.
// Na podstawie podanych współczynników program podaje rozwiązanie równania.

#include <iostream>

using namespace std;

int main() {
 int liczba1, liczba2;

  cout << "Podaj liczbę a: ";
  cin >> liczba1;

  cout << "Podaj liczbę b: ";
  cin >> liczba2;

  if (liczba1 == 0){
      if (liczba2 == 0){
        cout << "tozsamosciowe";
      } else {
        cout << "sprzeczne";
      }
    }  
  else {
      cout << "x: ";
      cout << (-liczba2 / liczba1);
  }

  return 0;
}