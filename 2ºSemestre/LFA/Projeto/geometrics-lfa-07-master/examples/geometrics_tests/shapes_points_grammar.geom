geometrics: main
/* ------------ WORKS ------------ */
/* Should Work */
x = -(10*3)

/* Should Work */
y = (-x + 2)/2

/* -------- POINT -------- */
/* Should Work */
point p1 (1,0)

/* Should Work */
point p2 (1,0)

/* Should Work */
point p3 (x, 0)

/* Should Work */
point p4 (x,   y)

/* Should Work */
point p5 (40, y)

/* Should Work */
point p6 (-(2*5), y-20)

/* -------- LINE -------- */
/* Should Work */
line l1 p1 p2 

/* Should Work */
line l2 (2,0) p2

/* Should Work */
line l3 p1 (2,0)

/* Should Work */
line l4 (x,x) (x,y)

/* -------- RECTANGLE -------- */
/* Should Work */
rectangle  r1 (2,0) 1 2

/* Should Work */
rectangle r2 p4 1 2

/* Should Work */
rectangle r3 (x, x) 1 2

/* Should Work */
rectangle r4 (x, 3) x*2 2

/* Should Work */
rectangle r5 (x*2, -20+10) y y*3

/* -------- SQUARE -------- */
/* Should Work */
square s1 (2,0) 1

/* Should Work */
square s2 p3 2

/* Should Work */
square s3 (y, x) 3

/* Should Work */
square s4 (x, 3) x*2

/* -------- ELLIPSE -------- */
/* Should Work */
ellipse e1 (2,0) 3 4

/* Should Work */
ellipse e2 p2 3 4

/* Should Work*/
ellipse e3 (x, y) 1 2

/* Should Work*/
ellipse e4 (x, 3) x*5 20-5

/* Should Work */
ellipse e5 (x*2, 20-2) y*x*10 y*6

/* -------- CIRCLE -------- */
/* Should Work */
circle c1 (2,0) 1

/* Should Work */
circle c2 p3 x

/* Should Work */
circle c3 (y, x) 6+2

/* Should Work */
circle c4 (10/2, -5*(-2)) x*y/10

/* ------------ WORKS BUT NEEDS TO THROW ERROR (IN RUNTIME) ------------ */ 
/* Every time a measure on one side is negative*/

/* ------------ ERRORS ------------ */
/* -------- POINT -------- */
/* Should fail -> missing '(' at 'x' 
point p7 x */

/* Should fail -> missing ')' at ','
point p8 ((2,0),(2,0) */

/* -------- RECTANGLE -------- */
/* Should fail -> extraneous input '2' expecting {'(', ID} 
rectangle r6 2 x y */

/* Should fail -> extraneous input '*' expecting {'+', '-', '(', Number, ID}
mismatched input 'y' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE} 
rectangle r7 p3*2 x*x y/2 */

/* -------- SQUARE -------- */
/* Should fail -> extraneous input '5' expecting {'(', ID} 
square s5 5 x y */

/* Should fail -> extraneous input '/' expecting {'+', '-', '(', Number, ID} 
square s6 p1/10 x+2 y- 10 */

/* -------- ELLIPSE -------- */
/* Should fail -> extraneous input '9' expecting {'(', ID}
mismatched input '\n' expecting {'+', '-', '(', Number, ID} 
ellipse e6 9 x y */

/* Should fail -> extraneous input '*' expecting {'+', '-', '(', Number, ID} 
ellipse e7 p5*2 x-y -y+1 */

/* -------- CIRCLE -------- */
/* Should fail -> extraneous input '10' expecting {'(', ID}
circle c5 10 x */

/* Should fail -> extraneous input '/' expecting {'+', '-', '(', Number, ID}
extraneous input 'y' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE} 
circle c6 ola/2 y */
