//Program prosi o podanie współczynników a, b i c w równaniu kwadratowym axx + b*x + c = 0.
// Na podstawie podanych współczynników program podaje rozwiązanie równania.

#include <iostream>
#include<math.h>


using namespace std;

int main() {

float a, b, c, delta, x1, x2;

cout << "Podaj liczbe a: ";
cin >> a;
  
cout << "Podaj liczbe b: ";
cin >> b;

cout << "Podaj liczbe c: ";
cin >> c; 

delta = b*b-4*a*c;

if (a==0){
  cout << "Rownanie liniowe, ktorego rozwiazaniem jest: " << (-c/b) << endl;
    return 0;
  }
  

if (delta<0){
  cout << "Brak rozwiazan" << endl;
    return 0;
  
  } else if (delta==0){
  cout << "1 rozwiazanie rownania: " << (-b/2*a) << endl;
    return 0; 
  
 } else {
      cout << "2 rozwiazania rownania: ";
  
        x1=(-b+sqrt(delta))/(2*a);
        x2=(-b-sqrt(delta))/(2*a);

      cout << "x1 = " << x1 << endl;
      cout << "x2 = " << x2 << endl;
  
      }
  
  return 0;
  
  }