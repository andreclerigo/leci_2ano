geometrics: main
figure f1 {
	point p1 (3,0)
	figure f2 {
		line l1 (2,0) p1
		square s1 (3,0) 30 filled yes
	}
}

figure f2 {
	add f3 to f5
	remove f4
}

animation a1 {
    tick is 30
    translate f1 to (2,0)
    rotate f1 30
} 

point p2 (4, 3)

/* ------------ WORKS ------------ */

/* -------- SHAPE -------- */
add square s2 (-9,0) 3 color #f08020 to f1
add circle c1 p2 2 to f1

/* -------- POINT -------- */
add p2 to f1

/* -------- FIGURE -------- */
add f1 to t1

add figure f2 {
	add f3 to f5
	remove f4
}
to f1

/* -------- ANIMATION -------- */
add animation a2 {
    tick is 10
} 
to f1

add a1 to f1

/* -------- FEATURE -------- */
add thickness 10 to f1
add hidden yes to f1

/* -------- NUMBER -------- */
add 20 to f1
add -5 to f1

/* -------- ID -------- */
add f1 to f1
add s1 to f1

/* ------------ ERRORS ------------ */

/* -------- SHAPE -------- */
/* Should fail -> extraneous input 'to' expecting ID
mismatched input '\n' expecting {'(', ID} 
add square to f1 */

/* -------- POINT -------- */
/* Should fail -> no viable alternative at input 'addpoint'
mismatched input 'to' expecting {'+', '-', '*', '/', '%', ')'}
mismatched input '\n' expecting {'+', '-', '*', '/', '%', ')'}
add point p3 (4, 3) to f1 */

/* -------- FIGURE -------- */
/* Should fail -> missing NEWLINE at 'to'
add figure f3 {
	add f3 to f5
	remove f4
} to f1 */

/* -------- ANIMATION -------- */
/* Should fail -> missing NEWLINE at 'to' 
add animation a3 {
    tick is 10
} to f1 */

/* -------- FEATURE -------- */
/* Should fail -> mismatched input 'to' expecting {'red', 'blue', 'green', 'yellow', 'black', 
'white', 'cyan', 'orange', 'purple', 'pink', 'brown', 'grey', HTMLColor, Number} 
add color to f1 */

/* Should fail -> extraneous input '\n' expecting 'to' 
add thickness 10 
to f1 */
