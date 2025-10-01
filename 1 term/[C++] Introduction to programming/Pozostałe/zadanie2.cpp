#include <iostream>
using namespace::std;

int sumaCyfr(int liczba){
    int suma = 0;
    while (liczba > 0){
        suma = suma + liczba%10;
        liczba = liczba/10;
    }
    
    return suma;
}

int main() {
    int liczba;
    cout << "Podaj liczbe" << endl;
    cin >> liczba;
    
    cout << sumaCyfr(liczba) << endl;
    cout << sumaCyfr(123) << endl;
    cout << sumaCyfr(98223) << endl;
    cout << sumaCyfr(0) << endl;
    cout << sumaCyfr(1000000000) << endl;

    return 0;
}