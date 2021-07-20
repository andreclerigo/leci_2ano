geometrics: database
/* ------------ WORKS ------------ */
f1 is {
    point p1 (1,0)
    point p2 (2,0)
    point p3 (2*4-5, -(10/2))

    line l1 (2,0) (3,3)
    line l2 p3 (3,0)
    line l3 p3 p3
    line l4 (0,0) p3
    line l5 (2,0) (3,0)
}

f2 is {
    point p5 (6,0)
    line l6 p5 p5

    circle c1 (0,0) 4
    circle c2 p5 3

    rectangle r1 (0,0) 4 4
    rectangle r2 p5 3*5 4
    rectangle r3 p5 3*5 4*5*5
} 

f3 is{
    point p6 (7,7)

    square q1 (2,0) 3 
    square q2 p6 3*5
    square q3 (3,0) 4*5*5

    ellipse e1 (7,0) 4 3
    ellipse e2 p6 3*5 4
    ellipse e3 p6 3*5 4*5*5
     } 


/* ------------ ERRORS ------------ */
/* Should fail -> missing 'is {' at '\n' 
f4 {
	square s1 p1 4
} */

/* Should fail -> extraneous input 'f5' expecting 'is {' 
figure f5 is {
	square s1 p1 4
} */

/* Should fail -> mismatched input 'quatro' expecting {'+', '-', '(', Number} 
f6 is {
	square s1 p1 quatro
} */

/* Should fail -> token recognition error at: '='
mismatched input '4' expecting 'is'
mismatched input 'quatro' expecting {'+', '-', '(', Number} 
f7 is {
	quatro = 4
	point p1 (2,0)
	square s1 p1 quatro
} */

/* Should fail -> mismatched input 's1' expecting 'is'
mismatched input 'to' expecting 'is'
mismatched input 'f6' expecting 'is'
mismatched input '\n' expecting 'is' 
f8 is {
	point p1 (2,0)
	square s1 p1 4
	add s1 to f6
} */

/* Should fail -> mismatched input 'a1' expecting 'is'
missing 'is' at '{'
mismatched input '20' expecting '{' 
f9 is {
	point p1 (2,0)
	square s1 p1 4
	animation a1 {
		tick is 20
	}
} */

/* Should fail -> mismatched input 'p1' expecting 'is'
mismatched input '\n' expecting 'is' 
f10 is {
	point p1 (2,0)
	square s1 p1 4
	remove p1
} */

