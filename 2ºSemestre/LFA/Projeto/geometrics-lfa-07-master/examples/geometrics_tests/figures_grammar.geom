geometrics: main
/* ------------ WORKS ------------ */

/* Should work */
figure f1 {
}

/* Should work */
figure f3{
	point p1 (3,0)
	figure f4 {
		line l1 (2,0) p1
		square s1 (3,0) 30 filled yes
	}
}

/* Should work */
figure f5 {
	add f3 to f5
	remove f4
}

/* Should work */
figure f7 {
	add f3 to f7
	add animation a1 {
		tick is 20
		translate f7 to (3,0)
	}
	to f7

}

/* ------------ ERRORS ------------ */

/* Should fail -> extraneous input '}' expecting NEWLINE 
figure f2 {}
*/

/* Should fail -> missing ID at '{' 
figure {
}
*/

/* Should fail -> mismatched input '(' expecting '{' 
figure f6 (
)
*/
