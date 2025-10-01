//Program prosi o podanie pięciu liczb. 
// O każdą z nich pyta oddzielnie. 
// Program przerywa działanie z odpowiednim komunikatem, jeżeli kolejna liczba nie jest większa od poprzedniej.
#include <iostream>
using namespace std;

int liczba1, liczba2;

int main() {
    cout << "Podaj liczbe" << endl;
    cin >> liczba1;
    for(int i=1; i<5; i++) {
      cout << "Podaj kolejna liczbe" << endl;
      cin >> liczba2;
      if (liczba2 <= liczba1){
        cout << "Liczba nie jest wieksza od poprzedniej";
        break;
      }
      liczba1 = liczba2;
    }
  }