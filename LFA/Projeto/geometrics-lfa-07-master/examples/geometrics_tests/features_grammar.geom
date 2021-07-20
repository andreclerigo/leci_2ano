geometrics: main
point p1 (1,0)
point p2 (2,0)

/*
Color Feature tested on color_grammar.txt
*/

/* ------------ WORKS ------------ */

/* -------- LINE -------- */
line l1 p1 p2 thickness 3000000
line l2 p1 p2 thickness 0

/* -------- CIRCLE -------- */
circle c1 p1 2 filled yes
circle c2 p1 2 filled no

/* -------- SQUARE -------- */
square s1 (-9,0) 3 hidden yes

/* -------- ELLIPSE -------- */
ellipse e1 (8,0) 2 4 hidden no
ellipse e5 (8,0) 2 4 thickness 30 filled yes hidden no

/* ------------ ERRORS ------------ */

/* -------- LINE -------- */
/* Should fail -> extraneous input '-' expecting Number 
line l3 p1 p2 thickness -10 */

/* Should fail -> missing Number at '\n' 
line l4 p1 p2 thickness */

/* Should fail -> mismatched input 'ola' expecting Number 
line l5 p1 p2 thickness ola */

/* -------- CIRCLE -------- */
/* Should fail ->  missing {'yes', 'no'} at '\n' 
circle c3 p1 2 filled */

/* -------- RECTANGLE -------- */
/* Should fail -> mismatched input 'No' expecting {'yes', 'no'} 
rectangle r1 (4,0) 2 9 filled No */

/* Should fail -> mismatched input 'ola' expecting {'yes', 'no'} 
rectangle r2 p2 2 9 filled ola */

/* -------- ELLIPSE -------- */
/* Should fail -> missing {'yes', 'no'} at '\n' 
ellipse e2 (8,0) 2 4 hidden */

/* Should fail -> mismatched input 'No' expecting {'yes', 'no'} 
ellipse e3 (8,0) 2 4 hidden No */

/* Should fail -> mismatched input 'ola' expecting {'yes', 'no'} */
ellipse e4 (8,0) 2 4 hidden ola 

/* Should fail -> mismatched input 'ola' expecting {'yes', 'no'} 
ellipse e6 (8,0) 2 4 thickness 30 filled ola */
