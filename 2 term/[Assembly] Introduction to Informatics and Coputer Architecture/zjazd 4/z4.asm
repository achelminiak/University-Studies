; (a/b)+c

org 100h

mov ax, [a]
mov dl, [b]
div dl
add al, [c]
mov byte [y], al 

mov ah, 00h
int 21h

a dw 0x05 ; 5
b dw 0x3B ; 59
c dw 0x4C ; 76
y dw 0x0