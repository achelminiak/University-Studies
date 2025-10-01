; a/2+b/3+c/4

org 100h

mov ax, [a]
mov dl, 02h
div dl
mov byte [y], al
mov ax, [b]
mov dl, 03h
div dl
add al, [y]
mov byte [y], al
mov ax, [c]
mov dl, 04h
div dl
add al, [y]
mov byte [y], al

mov ah, 00h
int 21h

a dw 0x05
b dw 0x3B
c dw 0x4C
y dw 0x0