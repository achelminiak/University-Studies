; 2a+2b-2c

org 100h

mov al, [a]
mov dl, 02h
mul dl
mov byte [y], al
mov al, [b]
mul dl
add al, [y]
mov byte [y], al
mov al, [c]
mul dl
mov bl, [y]
sub bl, al
mov word [y], ax

mov ah, 00h
int 21h

a dw 0x05 
b dw 0x3B 
c dw 0x4C 
y dw 0x0