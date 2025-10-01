; Napisz programik, który przyjmie od użytkownika jeden znak.
; Jeśli będzie większy niż ‘_’ (5Fh) to wydrukuje ‘>’, jeśli mniejszy to wydrukuje ‘<’, jeśli równy, to wydrukuje ‘==’

org 100h

mov AH, 0Ah
mov DX, character
int 21h
mov BX, [character + 2]

cmp BL, 5Fh
jg greater
jl less
je equal

exit:
mov AH, 00h
int 21h

greater:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DL, greaterSign
int 21h
jmp exit

equal:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DL, equalSign
int 21h
jmp exit

less:
mov AH, 02h
mov DL, 0Ah
int 21h
mov AH, 09h
mov DL, lessSign
int 21h
jmp exit

character db 02h
dunno db "dunno$"
greaterSign db ">$"
lessSign db "<$"
equalSign db "==$"