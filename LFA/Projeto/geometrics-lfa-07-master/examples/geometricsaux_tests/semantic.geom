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

f3 is {
    point p6 (7,7)

    square q1 (2,0) 3 
    square q2 p6 3*5
    square q3 (3,0) 4*5*5

    ellipse e1 (7,0) 4 3
    ellipse e2 p6 3*5 4
    ellipse e3 p6 3*5 4*5*5
} 


/* ------------ ERRORS ------------ */
/* Should fail -> FigError: f3 already defined 
f3 is {
    point p7 (7,7)
    point p8 (7,7)
} */

/* Should fail -> ShapeLineError: f5 not defined 
f5 is {
    point p7 (7,7)
    line l7 p7 f5
} */


/* Should fail -> FigError: f6 already defined 
f6 is {
    f6 is {
        circle c8 (2,0) 3
    }
} */
