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

/* ------------ WORKS ------------ */

/* -------- FIGURE -------- */
remove f3
remove f2

/* -------- POINT -------- */
remove p1

/* -------- SHAPE -------- */
remove s1


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

/* ------------ ERRORS ------------ */

/* -------- FIGURE -------- */
/* Should fail -> missing ID at 'figure'
mismatched input '\n' expecting ID 
remove figure */

/* -------- POINT -------- */
/* Should fail -> extraneous input 'point' expecting ID
remove point p1 (3,0) */

/* -------- SHAPE -------- */
/* Should fail -> extraneous input 'square' expecting ID
remove square s1 (3,0) 30 filled yes */
