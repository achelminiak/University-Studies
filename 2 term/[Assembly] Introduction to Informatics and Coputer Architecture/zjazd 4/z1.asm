; a+b+c

org 100h

mov ax, [a]
add ax, [b]
add ax, [c]
mov byte [y], al

mov AH, 00h
int 21h

a dw 0x05
b dw 0x3B
c dw 0x4C
y dw 0x0