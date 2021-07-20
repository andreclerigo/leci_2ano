geometrics:main
/* ------------ WORKS ------------ */
import "file1.geom"

figure f2 {
}

import "../file2.geom"

/* ------------ ERRORS ------------ */
/* Should fail -> FigError: file1_f2 already defined 
figure file1_f2 {
} 
*/

/* Should fail -> ImportError: f2 is already defined 
import "file3.geom"
*/
