org 100h

start:
    mov ah, 01h 
    int 21h          
    mov bl, al       

    cmp bl, 20h                
    jb koniec         

    cmp bl, 3Fh           
    jl dodaj_10  

    cmp bl, 40h     
    jb koniec           

    cmp bl, 5Fh               
    jl dodaj_7               

    cmp bl, 60h               
    jb koniec                  

    cmp bl, 7Eh               
    jl odejmij_12             

    jmp koniec               

dodaj_10:
    add bl, 10
    jmp wypisz                 

dodaj_7:
    add bl, 7
    jmp wypisz

odejmij_12:
    sub bl, 12

wypisz:
    mov ah, 02h               
    mov dl, bl                 
    int 21h                    

koniec:
    mov ah, 00h              
    int 21h                 

