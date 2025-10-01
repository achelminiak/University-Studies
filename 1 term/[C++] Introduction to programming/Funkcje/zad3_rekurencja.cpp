//Napisz iteracyjną i rekurencyjną wersję funkcji obliczającej:
//dwumian Newtona
//największy wspólny dzielnik (algorytm Euklidesa)
//Opierając się na programie z wykładu zmierz czas działania algorytmów i określ granice stosowalności w zależności od wartości parametrów.
#include <iostream>

using namespace::std;

int li1, li2;

int obliczDwumianNewtona(int n, int k){
    if (k==n || k==0){
        return 1;
    }
    return obliczDwumianNewtona(n - 1, k - 1) + obliczDwumianNewtona(n - 1, k);
}

int obliczAlgorytmEuklidesa(int a, int b){
    if (a%b != 0) {
        li1 = b;
        li2 = a%b;
        obliczAlgorytmEuklidesa(li1,li2);
    } else {return li2;}
}

int main() {
    int n, k, a, b;
    
    cout << "Podaj n do dwumianu: " << endl;
    cin >> n;
    cout << "Podaj k do dwumianu: " << endl;
    cin >> k;
    
    cout << "Wynik dwumianu newtona: " << obliczDwumianNewtona(n, k) << endl << endl;
    
    cout << "Podaj a do euklidesa: " << endl;
    cin >> a;
    cout << "Podaj b do euklidesa: " << endl;
    cin >> b;
    
    cout << "Wynik NWD: " << obliczAlgorytmEuklidesa(a, b);
    
    return 0;
}
