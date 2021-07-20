geometrics: main
/* ------------ WORKS ------------ */
/* -------- POINT -------- */
point p1 (1,0)
point p2 (2,0)

/* -------- LINE -------- */
line l1 p1 p2 color red 80
line l2 p1 p2 color red 80%
line l3 p1 p2 color red

/* -------- RECTANGLE -------- */
rectangle r1 (4,0) 2 9 color #8f8f88

/* -------- SQUARE -------- */
square s1 (-9,0) 3 color #f08020

/* -------- ELLIPSE -------- */
ellipse e1 (8,0) 2 4 color 255, 255, 255
ellipse e2 (8,0) 2 4 color 255, 255, 255, 50

/* ------------ WORKS BUT NEEDS TO THROW ERROR (IN RUNTIME) ------------ */

/* -------- CIRCLE -------- */
circle c2 p1 2 color grey 200

/* -------- ELLIPSE -------- */
ellipse e3 (8,0) 2 4 color 300, 255, 255

/* ------------ ERRORS ------------ */

/* -------- LINE -------- */
/* Should fail -> mismatched input '\n' expecting {'red', 'blue', 'green', 'yellow', 'black', 'white', 
'cyan', 'orange', 'purple', 'pink', 'brown', 'grey', HTMLColor, Number} 
line l4 p1 p2 color */

/* -------- CIRCLE -------- */
/* Should fail -> extraneous input '-' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE}
circle c3 p1 2 color grey -20 */

/* -------- RECTANGLE -------- */
/* Should fail -> token recognition error at "#8f8fG8" 
rectangle r2 p2 2 9 color #8f8fG8 */

/* -------- SQUARE -------- */
/* Should fail -> extraneous input '0000' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE}
square s2 (-9,0) 3 color #0000000000 */

/* -------- ELLIPSE -------- */
/* Should fail -> extraneous input ',' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE} 
ellipse e4 (8,0) 2 4 color 255, 255, 255, 10, 10 */

/* Should fail -> extraneous input '-' expecting Number 
ellipse e5 (8,0) 2 4 color 255, 255, -255, -50 */

/* Should fail -> mismatched input 'Red' expecting {'red', 'blue', 'green', 'yellow', 'black', 'white', 
'cyan', 'orange', 'purple', 'pink', 'brown', 'grey', HTMLColor, Number} 
ellipse e6 (8,0) 2 4 color Red */

