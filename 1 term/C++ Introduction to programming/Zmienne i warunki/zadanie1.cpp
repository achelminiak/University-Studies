//Program prosi o podanie pięciu liczb. O każdą z nich pyta oddzielnie. 
// Program przerywa działanie z odpowiednim komunikatem, jeżeli kolejna liczba nie jest większa od poprzedniej.

#include <iostream>

using namespace std;

int main() {
  int liczba1, liczba2, liczba3, liczba4, liczba5;
  
  cout << "Podaj liczbę 1: ";
  cin >> liczba1;

  cout << "Podaj liczbę 2: ";
  cin >> liczba2;

  if(liczba2>liczba1){
    cout << "Podaj liczbę 3: ";
    cin >> liczba3;
  } else {
    cout << "Liczba nie jest wieksza od poprzedniej";
    return 0;
  }
  
  if(liczba3>liczba2){
    cout << "Podaj liczbę 4: ";
    cin >> liczba4;
  } else {
    cout << "Liczba nie jest wieksza od poprzedniej";
    return 0;
  }
  
  if(liczba4>liczba3){
    cout << "Podaj liczbę 5: ";
    cin >> liczba5;
  } else {
    cout << "Liczba nie jest wieksza od poprzedniej";
    return 0;
  }

  if(liczba5>liczba4){
    cout << "Kazda liczba jest wieksza od poprzedniej";
  } else {
    cout << "Liczba nie jest wieksza od poprzedniej";
    return 0;
  }
}