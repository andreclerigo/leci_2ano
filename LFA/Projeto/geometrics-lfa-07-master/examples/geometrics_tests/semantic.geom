geometrics: main
/* ------------ WORKS ------------ */

/* -------- POINT -------- */
point p1 (1,0)
point p2 (2,0)
add p1 to p2

x = 5*10
point p3 (x,x)

/* -------- FIGURE -------- */
figure f1 {
    point p4 (x,x)
    line l5 (2,0) (3,0)
}

add figure f2 {
    point p5 (6,0)
    line l6 p3 p3
} 
to f1

/* -------- LINE -------- */
line l1 (2,0) (3,3)
line l2 p3 (3,0)
line l3 p3 p3
line l4 (0,0) p3

/* -------- CIRLCE -------- */
circle c1 (0,0) 4
circle c2 p3 3

/* -------- RECTANGLE -------- */
rectangle r1 (0,0) 4 4
rectangle r2 p3 3*x 4
rectangle r3 p3 3*x 4*x*x

/* -------- SQUARE -------- */
square q1 (2,0) 3 
square q2 p3 3*x
square q3 (3,0) 4*x*x

/* -------- ELLIPSE -------- */
ellipse e1 (7,0) 4 3
ellipse e2 p3 3*x 4
ellipse e3 p3 3*x 4*x*x

/* -------- ADD -------- */
add color #0f0f0f to r1
add thickness 3 to r1

add circle c10 (x,x) x color red to f1

add (x, x) to p1
add (3*4, x) to p2

add -1 to x

figure f3 {
	add e1 to f3
}


/* -------- REMOVE -------- */
remove r1
r1 = -(x * (3 + x))

/* ------------ ERRORS ------------ */

/* -------- LINE -------- */
/* Should fail -> p not defined 
line l7 (p, 10) p3 */

/* Should fail -> missing ',' at '0' 
line l8 (2, 0) (2 0) */

/* -------- CIRLCE -------- */
/* Should fail -> mismatched input '1' expecting {'(', ID} 
circle c3 1 */

/* -------- RECTANGLE -------- */
/* Should fail -> mismatched input '(' expecting {'color', 'thickness', '
filled', 'hidden', NEWLINE} 
rectangle r4 p3 5/x 3(3 */

/* -------- FIGURE -------- */
/* Should fail -> missing 'to' at 'f2' 
add figure f3 {
    point p5 (6,0)
    line l6 p3 p3
} 
f2 */

/* -------- ADD -------- */
/* Should fail -> extraneous input '-' expecting Number 
add thickness -10 to r1 */

/* Should fail -> mismatched input 'color' expecting {'(', ID} 
add rectangle r1 color red to f1 */

/* Should fail -> mismatched input '*' expecting 'to' 
add 5*10 x */

/* -------- REMOVE -------- */
/* Should fail -> token recognition error at: '?'; 
extraneous input '2' expecting NEWLINE 
remove r1
r1 = -x * 4 ? 2 */

/* -------- ANIMATIONS -------- */
/* Should fail -> LoopError: loop time value cannot be 1 
animation a1 {
	tick is 20
	loop 1 times
} */

