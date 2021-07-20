geometrics: main
/* Declarar figura */
figure fig1 {
	line line1 (1,0) (3,0)		/* Declarar linha com pontos */
	point point1 (5,0)			/* Declara ponto da firgura */
}


point p1 (2,0)
point p2 (3,0)
line l p1 p2					/* Declarar linha com pontos declarados */	

circle circle1 p1 2 

ellipse el1 p2 2 3 color #af096d 

/* Color testing feature */
square s1 (-9,0) 4 color 255,255,255		/* Rgb */
square s2 (-18,0) 4 color 255,255,255,50	/* RGBA */
square s3 (-18,0) 4 color grey 80			/* Color + Opacity */
square s4 (-18,0) 4 color blue				/* Color */

/* Multiple features */
rectangle rec1 (6,6) 2 4 thickness 30 filled yes color blue


animation a1 {
	tick is 50
}
