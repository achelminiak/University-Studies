//Dla zadanego N, napisz program wyliczający N-tą liczbę Fibonacciego.

#include <iostream>

using namespace std;

int main()
{
int n;

int liczbaFibonacciego = 0, pierwszyElement = 0, drugiElement = 1;

cout << "Podaj N: " << endl;
cin >> n;
  
if (n < 0) {
  cout << "Niewykonalne dla ujemnych" << endl;
  return 0;
}
  
for (int i = 0; i <= n; i++){
  if (i == 0) {
    liczbaFibonacciego = pierwszyElement;
  } else {
    if (i > 1) {
      pierwszyElement = liczbaFibonacciego;
    }
      liczbaFibonacciego = pierwszyElement + drugiElement;
      drugiElement = pierwszyElement;
    }
  }
  cout << liczbaFibonacciego << endl;
  return 0;
}
