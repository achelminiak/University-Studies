//Liczby zaprzyjaźnione to dwie liczby naturalne, gdzie każda z nich jest równa sumie dzielników właściwych drugiej liczby.
// Napisz program wypisujący liczby zaprzyjaźnione z zadanego zakresu.

#include<iostream>
using namespace::std;

int main(){
    
    int sumaDzielnikow = 0;
    int liczba = 0; // obecnie obliczana liczba
    int suma = 0;
    int zakres; // koniec przedzialu
    int zakresPocz;

    cout << "Podaj poczatek zakresu: ";
    cin >> zakresPocz;
  
    cout << "Podaj koniec zakresu: ";
    cin >> zakres; 
    
    for(int liczba = zakresPocz; liczba <= zakres; liczba++){
        
        suma = 0;
        for(int i = 1;i < liczba/2+1;i++){
            if(liczba % i==0){
                suma+=i;
            }
        }
        sumaDzielnikow = suma;
        
        suma = 0;
        for(int i = 1;i < sumaDzielnikow/2+1;i++){
            if(sumaDzielnikow % i==0){
                suma+=i;
            }
        }
 if (suma == liczba && liczba > sumaDzielnikow){ 
            cout << "Liczby zaprzyjaznione: " << liczba << " " << sumaDzielnikow << "\n";
        }
    }
    return 0;
}
