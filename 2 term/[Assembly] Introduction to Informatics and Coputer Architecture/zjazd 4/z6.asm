; a*(b/c)

org 100h

mov ax, [b]
mov dl, [c]
div dl
mov byte [y], al
mov al, [a]
mov dl, [y]
mul dl
mov word [y], ax

mov ah, 00h
int 21h

a dw 0x05 ; 5
b dw 0x3B ; 59
c dw 0x4C ; 76
y dw 0x0