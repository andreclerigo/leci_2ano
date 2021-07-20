## Group members
&nbsp;

| NMec | Name | email | Contribution (%) | Detailed contribution [1]
|:-:|:--|:--|:-:|:--|
| 98485 | André Clérigo | andreclerigo@ua.pt | 30% | primary-grammar (65%)<br>primary-semantic-analysis (80%)<br>secondary-grammar (100%)<br>secondary-semantic-analysis (100%)<br>examples (20%)<br>testing (30%)<br>python-classes (5%)<br>python-testing (10%)<br>report-and-documentation (10%)|
| 101077 | Bruno Acioli | baal@ua.pt | 17,5% |  primary-grammar (10%)<br>examples (20%)<br>python-classes (25%)<br>python-testing (40%)<br>code-generation (50%) |
| 97512 | João Silva | joaocastanheira@ua.pt | 20% | <br>examples(20%)<br>python-classes (70%)<br>python-testing (50%)<br>code-generation (20%) |
| 93278 | Pedro Coutinho | pmacoutinho@ua.pt | 15% | primary-grammar (5%)<br>examples (20%)<br>testing (40%)<br>report-and-documentation (90%)|
| 98256 | Pedro Rocha | pedro.lebrerocha@ua.pt | 17,5% |  primary-grammar (20%)<br>primary-semantic-analysis (20%)<br>examples (20%)<br>code-generation (30%)<br>testing (30%)|

[1] Topics:<br>
   primary-grammar (%)<br>primary-semantic-analysis (%)<br>code-generation (%)<br>secondary-grammar (%)<br>secondary-semantic-analysis (%)<br>secondary-interpretation/secondary-code-generation (%)<br>examples (%)<br>testing (%)<br>other (%) (explain)

- Beware that within the group the sum for each topic must be 100% (obviously).

###Other topics
<br>python-classes (%)
<br>python-testing (%)
<br>report-and-documentation (%)

## Material to be evaluated

- Beware that **only** the code in the **master** branch will be considered for evaluation.

## Compilation & Run

### Run:  
java GeometricsMain input.geom

java GeometricsAux input.geom

There is a script that performs this line located in `geometrics-lfa-07/src/run.sh`, it takes either "Main" or "Aux" as the first argument and the file you wish to run as the second argument.

## Working examples

Examples to show the language functionalities. 

Input for grammar tests can be either .txt or .geom 

Many of the examples also include error scenarios in a commented block.

### Testing:
antlr4-test grammar-name test-symbol [-gui] < input.geom

**examples:** 

antlr4-test GeometricsAux program -gui < input.geom

antlr4-test Geometrics program -gui < input.geom

There is a script that performs this line located in `geometrics-lfa-07/src/testing.sh`, it takes the test file as the first argument (with the correct path) if you wish to test something with the primary grammar; and it takes Aux as the first argumnt and the test file as the second one if you wish to thet a file with the secondary grammar.

### Primary Grammar Examples:


1. `geometrics-lfa-07/examples/geometrics_tests/add_grammar.geom`

    Tests the add statement in various scenarios, such as adding a point to a figure and adding an animation to a figure, among others. 

2. `geometrics-lfa-07/examples/geometrics_tests/animation_grammar.geom`

    Creates multiple animations with different commands assigned to them. 
    
3. `geometrics-lfa-07/examples/geometrics_tests/color_grammar.geom`

    Tests the color property in various scenarios, such as assigning a color to a line with 80% opacity and assigning color to an ellipse using an RGB code, among others.

4. `geometrics-lfa-07/examples/geometrics_tests/features_grammar.geom`

    Tests the application of features to different types of geometrics primitives and shapes; the features tested are "thickness", "filled" and "hidden".
    
5. `geometrics-lfa-07/examples/geometrics_tests/figures_grammar.geom`

    Creates multiple figures with different geometric primitives, shapes, animations, statements and even other figures assigned to them.

6. `geometrics-lfa-07/examples/geometrics_tests/import_grammar.geom`

    Tests the "import" command.
    
7. `geometrics-lfa-07/examples/geometrics_tests/import_semantic.geom`

    Does a semantic test of the "import" command. It requires the use of file1.geom
    
8. `geometrics-lfa-07/examples/geometrics_tests/remove_grammar.geom`

    Tests the "remove" statement in various scenarios, such as a figure, a point and a shape. 
    
9. `geometrics-lfa-07/examples/geometrics_tests/rotate_grammar.geom`

    Tests the "rotate" statement in various animation, various geometric primitives are rotated over points by multiple angles.
    
10. `geometrics-lfa-07/examples/geometrics_tests/semantics.geom`

    Tests various semantic commands.
    
11. `geometrics-lfa-07/examples/geometrics_tests/shapes_point_grammar.geom`

    Creates various points, lines and every geometric primitive.
    
12. `geometrics-lfa-07/examples/geometrics_tests/translate_grammar.geom`

    Tests the "translate" statement in various animation, various geometric primitives, shapes and figures are translated to multiple points.
    

### Seondary Grammar Examples:

1. `geometrics-lfa-07/examples/geometricsaux_tests/grammar.geom`
   
   Tests various geometrics aux statements.
   
2. `geometrics-lfa-07/examples/geometricsaux_tests/semantics.geom`
   
   Tests various semantic commands.

## Semantic error examples

### Primary Grammar Examples:

1. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_add`

    extraneous input '-' expecting Number
    
2. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_add2`

    mismatched input 'color' expecting {'(', ID} 
    
3. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_add3`

    mismatched input '*' expecting 'to' 
    
4. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_animation`

    LoopError: loop time value cannot be 1 animation a1 {
    
5. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_circle`

    mismatched input '1' expecting {'(', ID} 
    
6. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_figure`

    missing 'to' at 'f2' 
    
7. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_line`

    p not defined 
    
8. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_line2`

    missing ',' at '0' 
    
9. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_rectangle`

    mismatched input '(' expecting {'color', 'thickness', 'filled', 'hidden', NEWLINE} 
    
10. `geometrics-lfa-07/examples/geometrics_tests/semantic_errors/semantic_error_remove`

    token recognition error at: '?'; extraneous input '2' expecting NEWLINE 

    
### Secondary Grammar Examples:

1. `geometrics-lfa-07/examples/geometricsaux_tests/semantic_errors/semantic_error_1`

    FigError: f3 already defined
    
2. `geometrics-lfa-07/examples/geometricsaux_tests/semantic_errors/semantic_error_2`

    ShapeLineError: f5 not defined
    
3. `geometrics-lfa-07/examples/geometricsaux_tests/semantic_errors/semantic_error_3`

    FigError: f6 already defined

## Extra Information

`geometrics-lfa-07/doc/documentation.pdf`

   Includes the documentation of the devoloped language.

