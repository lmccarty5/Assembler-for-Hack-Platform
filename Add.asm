// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/06/add/Add.asm

// Computes R0 = 2 + 3  (R0 refers to RAM[0])


@KBD
@mysymbol
@mysecondsymbol
@2
D=A
@3
D=D+A
@mysecondsymbol
@0 
@mysymbol
M=D
@bobo
@mysymbol
(mysymbol)
@THAT
(mysecondsymbol)

