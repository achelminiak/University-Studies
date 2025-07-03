#include <iostream>
using namespace::std;

int czyJestSzescianem(int podstawa, int szescian){
    if (szescian == podstawa * podstawa * podstawa){
        return 1;
    } else {return 0;}
}

int main() {
    int liczba, liczba2;
    
    cout << "Podaj liczby ktore chcesz sprawdzic" << endl;
    cout << "Czy liczba: ";
    cin >> liczba;
    cout << endl << "jest szescianem liczby: ";
    cin >> liczba2;
    
    cout << czyJestSzescianem(liczba2, liczba);

    return 0;
}