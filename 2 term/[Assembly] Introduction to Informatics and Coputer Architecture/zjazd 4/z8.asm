; 2a*(b/2c)

org 100h

mov al, [c]
mov dl, 02h
mul dl
mov bl, al
mov al, [b]
mov dl, bl
div dl
mov byte [y], al
mov al, [a]
mov dl, 02h
mul dl
mov dl, [y]
mul dl
mov byte [y], al


mov ah, 00h
int 21h

a dw 0x05 ; 5
b dw 0x3B ; 59
c dw 0x4C ; 76
y dw 0x0