//Napisz iteracyjną i rekurencyjną wersję funkcji obliczającej:
//dwumian Newtona
//największy wspólny dzielnik (algorytm Euklidesa)
//Opierając się na programie z wykładu zmierz czas działania algorytmów i określ granice stosowalności w zależności od wartości parametrów.

#include <iostream>

using namespace::std;

int obliczDwumianNewtona(int n, int k){
    int silniaN=1, silniaK=1, silniaNminusK=1, dwumianNewtona;
    for (int i = 1; i <= n; i++){
        silniaN = silniaN * i;
    }
    for (int i = 1; i <= k; i++){
        silniaK = silniaK * i;
    }
    for (int i = 1; i <= n - k; i++){
        silniaNminusK = silniaNminusK * i;
    }
    
    dwumianNewtona = silniaN/(silniaK*silniaNminusK);
    return dwumianNewtona;
}

int obliczAlgorytmEuklidesa(int a, int b){
    int li1, li2;
    while (true){
        if (a%b != 0) {
            li1 = b;
            li2 = a%b;
            
            a = li1;
            b = li2;
        } else {return li2;}
    }
}

int main() {
    int n, k, a, b;
    
    cout << "Podaj n do dwumianu: " << endl;
    cin >> n;
    cout << "Podaj k do dwumianu: " << endl;
    cin >> k;
    
    cout << "Wynik dwumianu newtona: " << obliczDwumianNewtona(n, k) << endl;
    
    cout << "Podaj a do euklidesa: " << endl;
    cin >> a;
    cout << "Podaj b do euklidesa: " << endl;
    cin >> b;
    
    cout << "Wynik NWD: " << obliczAlgorytmEuklidesa(a, b);
    
    return 0;
}
