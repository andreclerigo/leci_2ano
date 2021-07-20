geometrics: main
figure f1 {
	point p1 (3,0)
	figure f2 {
		line l1 (2,0) p1
		square s1 (3,0) 30 filled yes
	}
}

figure f3 {
	add f1 to f3
}

line l2 p1 (4, 9)
line l3 (1, 0) (2, 0)

circle c1 (3, 0) 4
rectangle r1 (7, 1) 10 5

/* ------------ WORKS ------------ */

/* -------- ANIMATION -------- */
animation a1 {
	tick is 20
	rotate f1 10 over p1
	rotate f3 200 over p1


	/* -------- LINE -------- */
	rotate l1 360 over p1
	rotate l2 720 over p1

	/* -------- SHAPE -------- */
	rotate c1 70 over p1
	rotate r1 700 over p1
}

/* ------------ ERRORS ------------ */

/* -------- ANIMATION -------- */
animation a2 {
	tick is 20
	/* Should fail -> mismatched input 'over' expecting {'-', Number}
	mismatched input '\n' expecting '=' 
	rotate f1 over p1 */

	/* -------- LINE -------- */
	/* Should fail -> mismatched input '\n' expecting {'(', ID} 
	rotate l1 100 over */

	/* -------- SHAPE -------- */
	/* Should fail -> mismatched input 'p1' expecting {'over', NEWLINE}
	rotate c1 2000 p1 */
}
