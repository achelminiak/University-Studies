; a^2+2b+c

org 100h

mov al, [a]
mov dl, [a]
mul dl
mov byte [y], al
mov al, [b]
mov dl, 02h
mul dl
mov bl, [y]
add bl, al
add bl, [c]
mov byte [y], bl

mov ah, 00h
int 21h

a dw 0x05 
b dw 0x3B 
c dw 0x4C 
y dw 0x0