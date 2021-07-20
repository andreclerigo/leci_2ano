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

point p2 (7, 7)

line l2 p1 (4, 9)
line l3 (1, 0) (2, 0)

circle c1 (3, 0) 4
rectangle r1 (7, 1) 10 5

/* ------------ WORKS ------------ */
animation a1 {
	tick is 30
	/* -------- FIGURE -------- */
	translate f1 to p2
	translate f2 to p2

	/* -------- LINE -------- */
	translate l1 to p2
	translate l2 to (20, 20)


	/* -------- SHAPE -------- */
	translate c1 to p2
	translate r1 to p2
}

/* ------------ ERRORS ------------ */

animation a2 {
	tick is 20
	/* -------- FIGURE -------- */
	/* Should fail -> extraneous input 'point' expecting {'(', ID}
	translate f1 to point p3 (3, 0) */

	/* -------- LINE -------- */
	/* Should fail -> mismatched input '(' expecting {'+', '-', '*', '/', '%', ')'} 
	translate l1 to (8, 9) (9, 5) */

	/* -------- SHAPE -------- */
	/* Should fail -> missing 'to' at 'p1'
	translate r1 p1 */
}
