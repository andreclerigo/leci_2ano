geometrics: main
/* ------------ WORKS ------------ */
x = 1
figure f1 {
    point p1 (0,0)
    square s1 p1 3
}

/* Should Work */
animation a1 {
    tick is 10
}

/* Should Work */
animation a2 {
    tick is 20
    translate f1 to (2,0)
}

/* Should Work */
animation a3 {
    tick is 30
    translate f1 to (2,0)
    rotate f1 30
}

/* Should Work */
animation a4 {
    tick is 30
    rotate f1 30
}

/* Should Work */
animation a5 {
    tick is 30
    loop 2 times
    rotate f1 30 over p1 
}

/* Should Work */
animation a6 {
    tick is 50
    loop 10 times
    translate s1 to (x,x)
    rotate f1 30 over p1 
}

add a1 to f1

/* ------------ ERRORS ------------ */
/* Should fail -> mismatched input '}' expecting 'tick is' 
animation a7 {
} */

/* Should fail -> mismatched input '+' expecting NEWLINE 
animation a7 {
    tick is 10+20
} */

/* Should fail -> mismatched input '(' expecting ID 
animation a8 {
    tick is 10
    translate (0,0) to (2,0)
} */

/* Should fail -> mismatched input '*' expecting {'over', NEWLINE} 
animation a9 {
    tick is 10
    rotate f1 -20*2
} */

/* Should fail -> mismatched input '(' expecting ID
mismatched input '\n' expecting '=' 
animation a10 {
    tick is 10
    rotate (3,1) -20 over p1
} */

/* Should fail -> mismatched input '\n' expecting Number 
animation a11 {
    tick is 11
    loop
} */

/* Should fail -> missing 'times' at '\n' 
animation a12 {
    tick is 11
    loop 2
} */

/* Should fail -> mismatched input 'loop' expecting 'tick is'
animation a13 {
	loop 10 times
    tick is 11
} */

/* Should fail -> mismatched input 'ten' expecting Number
mismatched input 'times' expecting '=' 
animation a14 {
	tick is 11
	loop ten times
} */

/* Should fail -> extraneous input '-' expecting Number 
animation a15 {
	tick is 20
	loop -2 times
} */

