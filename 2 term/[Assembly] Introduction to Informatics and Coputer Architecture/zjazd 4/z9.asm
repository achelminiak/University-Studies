; a*(b+a/c)

org 100h

mov ax, [a]
mov dl, [c]
div dl
add al, [b]
mov byte [y], al
mov al, [a]
mov dl, [y]
mul dl
mov word [y], ax

mov AH, 00h
int 21h

a dw 0x05
b dw 0x3B
c dw 0x4C
y dw 0x0