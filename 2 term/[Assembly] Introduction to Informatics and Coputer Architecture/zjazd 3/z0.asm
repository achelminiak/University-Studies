org 100h

mov AH, 02h
mov DL, 41h
int 21h

jmp koniec

mov DL, 42h
int 21h

koniec:
mov AH, 00h
int 21h
