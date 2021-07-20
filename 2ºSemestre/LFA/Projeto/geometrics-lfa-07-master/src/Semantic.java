import java.util.*;
import java.io.IOException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Semantic extends GeometricsBaseVisitor<String> {
	// Map the variable types
	HashMap<String, String> map = new HashMap<>();
	
    // List that contains compatible pairs for addition (point-point) -> addind point to point
    String[] pairs = {"number-number", "point-point", "point-figure", "point-animation", "shape-figure", "shape-animation", "feature-shape", "figure-figure", "figure-animation", "animation-animation", "animation-figure"};	
	List<String> compatible = new LinkedList<> (Arrays.asList(pairs));		
	
	String path = "";

    /**
     * Visits every statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitProgram(GeometricsParser.ProgramContext ctx) {
        // If there is at least one statement
        if (ctx.stat() != null) {   
            // Visit all the statements that exist
            for (GeometricsParser.StatContext stat : ctx.stat()) {
                String res = visit(stat);
                if (res == null) {
                    System.out.println(res);    // DEBUG
                    return null;
                }
            }
        }
        
        return "";
    }
	
    /**
     * Visits every import statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
	@Override public String visitStatAux(GeometricsParser.StatAuxContext ctx) {
		return visit(ctx.aux());
	}
	
    /**
     * Set the relative path for imports
     */
	public void setPath(String in) {
		path = in + "/";
		if (in == null) path = "";
	}
	
    /**
     * Visits every import from aux language
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAux(GeometricsParser.AuxContext ctx) {
        try {
            // create a CharStream that reads from standard input:
            String fileName = ctx.STRING().getText();
            CharStream input = CharStreams.fromFileName(path + fileName.substring(1, fileName.length() - 1));
            // create a lexer that feeds off of input CharStream:
            GeometricsAuxLexer lexer = new GeometricsAuxLexer(input);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            GeometricsAuxParser parser = new GeometricsAuxParser(tokens);
            // begin parsing at program rule:
            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
                SemanticAux visitor0 = new SemanticAux();
                // See if semantic visitor didn't find any error
                if (visitor0.visit(tree) == null) return null;

                // Get the HashMap produced from the imported file
                HashMap<String, String> auxMap = visitor0.getMap();

                // Check if there are colliding figure names
                for (Map.Entry<String, String> entry : auxMap.entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        System.err.println("ImportError: " + entry.getKey() + " is already defined");
                        return null;
                    }
                }
                // Merge the HashMaps
                map.putAll(auxMap);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
        catch(RecognitionException e) {
            e.printStackTrace();
            return null;
        }

        return "";
    }

    /**
     * Visits every assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatAssig(GeometricsParser.StatAssigContext ctx) {
        String res = visit(ctx.assig());
        if (res == null) return null;
        System.out.println(res);        // DEBUG
        return "";
    }

    /**
     * Visits every add statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatAdd(GeometricsParser.StatAddContext ctx) {
        String res = visit(ctx.add());
        if (res == null) return null;
		System.out.println(res);        // DEBUG
		return "";
    }

    /**
     * Visits every remove statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatRemove(GeometricsParser.StatRemoveContext ctx) {
        return visit(ctx.remove());
    }

    /**
     * Visits every NEWLINE statement
     * @param ctx
     * @return "" NEWLINE statement is ignored
     */
    @Override public String visitStatNewline(GeometricsParser.StatNewlineContext ctx) {
        return "";
    }

    /**
     * Visits every translate statement for animation
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAnimStatTranslate(GeometricsParser.AnimStatTranslateContext ctx) {
        return visit(ctx.translate());
    }

    /**
     * Visits every rotate statement
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAnimStatRotate(GeometricsParser.AnimStatRotateContext ctx) {
        return visit(ctx.rotate());
    }

    /**
     * Visits every wait statement for animation
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAnimStatWaitms(GeometricsParser.AnimStatWaitmsContext ctx) {
        return visit(ctx.waitms());
    }

    /**
     * Visits every shape assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAssigShape(GeometricsParser.AssigShapeContext ctx) {
        if (visit(ctx.shape()) == null) return null;
        
        // If the shape has 1 or more features
        if (ctx.feature() != null)
            // Check if any feature has an error
            for (GeometricsParser.FeatureContext feature : ctx.feature())
                if (visit(feature) == null) return null;
                
        return "";
    }

    /**
     * Visits every point assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAssigPoint(GeometricsParser.AssigPointContext ctx) {
    	String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {         
            if (visit(ctx.point()) == null) return null;
			map.put(ID, "point");

            return "";
		}

        System.err.println("AssigPointError: " + ID + " already defined");
        return null;
	}

    /**
     * Visits every animation assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAssigAnimation(GeometricsParser.AssigAnimationContext ctx) {
        if (visit(ctx.anim()) == null) return null;
        
        return "";
    }

    /**
     * Visits every figure assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAssigFigure(GeometricsParser.AssigFigureContext ctx) {
        if (visit(ctx.fig()) == null) return null;
        
        return "";
    }

    /**
     * Visits every expression assignment
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAssigExpr(GeometricsParser.AssigExprContext ctx) {
    	String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {
            if (visit(ctx.expr()) == null) return null;
			map.put(ID, "number");

			return "";	
		}

        System.err.println("AssigExprError: " + ID + " already defined");
        return null;
	}  

    /**
     * Visits every AddSub expression
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprAddSub(GeometricsParser.ExprAddSubContext ctx) {
        if (visit(ctx.expr(0)) == null) return null;    // If the first expression has errors return null
        if (visit(ctx.expr(1)) == null) return null;    // If the second expression has errors return null

        return "number";
    }

    /**
     * Visits every parentheses expression
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprParent(GeometricsParser.ExprParentContext ctx) {
        // If the expression has an error return null
        if (visit(ctx.expr()) == null) return null;
        return "number";
    }

    /**
     * Visits every number expression
     * @param ctx
     * @return "number", because semantically all numbers are valid
     *         
     */
    @Override public String visitExprNumber(GeometricsParser.ExprNumberContext ctx) {
        return "number";
    }
	
    /**
     * Visits every expression that is an ID
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
	@Override public String visitExprID(GeometricsParser.ExprIDContext ctx) {
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {
			System.err.println("ExprIDError: " + ID + " not defined");
			return null;

        // Check if the ID is a number
		} else if (!map.get(ID).equals("number")) {
			System.err.println("ExprIDError: " + ID + " is not a number");
			return null;
		}

		return "number";
	}

    /**
     * Visits every expression that is preceded by a '+' or '-'
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprPlusMinus(GeometricsParser.ExprPlusMinusContext ctx) {
        // If the expression has an error return null
        if (visit(ctx.expr()) == null) return null; 
        return "number";
    }

    /**
     * Visits every MultDivMod expression
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprMultDivMod(GeometricsParser.ExprMultDivModContext ctx) {
        if (visit(ctx.expr(0)) == null) return null;    // If the first expression has errors return null
        if (visit(ctx.expr(1)) == null) return null;    // If the second expression has errors return null
        return "number";
    }

    /**
     * Visits every addition of a shape
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddShape(GeometricsParser.AddShapeContext ctx) {
        String typeShape = visit(ctx.shape());
		if (typeShape == null) return null;

        // Check if the ID is not already defined
		String ID = ctx.ID().getText();
		if (!map.containsKey(ID)) {
			System.err.println("AddShapeError: " + ID + " is not defined");
			return null;
		}
		
		String typeID = map.get(ID);
		String pair = typeShape + "-" + typeID;
		
        // Check if the shape is being added to a valid target
		if (!compatible.contains(pair)) {
			System.err.println("AddShapeError: Can't add shape to " + ID + " (" + typeID + ")");
			return null;
		} 
        
        // Check if there are features and if those have any error
        if (ctx.feature() != null)
            for (GeometricsParser.FeatureContext feature : ctx.feature())
                if (visit(feature) == null) return null;

        return "";
    }

    /**
     * Visits every addition of a point
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddPoint(GeometricsParser.AddPointContext ctx) {
        String typePoint = visit(ctx.point());
		if (typePoint == null) return null;

        // Check if the ID is not already defined
		String ID = ctx.ID().getText();
		if (!map.containsKey(ID)) {
			System.err.println("AddPointError: " + ID + " is not defined");
			return null;
		}
		
		String typeID = map.get(ID);
		String pair = typePoint + "-" + typeID;
		
        // Check if the point is being added to a point
		if (!pair.equals("point-point")) {
			System.err.println("AddPointError: Can't add point to " + ID + " (" + typeID + ")");
			return null;
		} 
		
        return "";
    }

    /**
     * Visits every addition of a figure
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddFigure(GeometricsParser.AddFigureContext ctx) {
        String fig = visit(ctx.fig());
		if (fig == null) return null;

        // Check if the ID is not already defined
		String ID = ctx.ID().getText();
		if (!map.containsKey(ID)) {
			System.err.println("AddFigureError: " + ID + " is not defined");
			return null;
		}
		
		String typeID = map.get(ID);
		String pair = fig + "-" + typeID;

        // Check if the figure is being added to a valid target
		if (!compatible.contains(pair)) {
			System.err.println("AddFigureError: Can't add figure to " + ID + " (" + typeID + ")");
			return null;
		} else 
			return "";
    }

    /**
     * Visits every addition of a number
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddNumber(GeometricsParser.AddNumberContext ctx) {
        String ID = ctx.ID().getText();
		
        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {
			System.err.println("AddExprError: " + ID + " not defined");
			return null;
        }

		String typeID = map.get(ID);
    	String pair = "number-" + typeID;
		
        // Check if the number is being added to another number
		if (!compatible.contains(pair)) {
			System.err.println("AddNumberError: Can't add number to " + ID + " (" + typeID + ")");
			return null;
		} 
		
        return "";
    }

    /**
     * Visits every addition of a animation
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddAnim(GeometricsParser.AddAnimContext ctx) {
        String anim = visit(ctx.anim());
		if (anim == null) return null;

        // Check if the ID is not already defined
		String ID = ctx.ID().getText();
		if (!map.containsKey(ID)) {
			System.err.println("AddAnimationError: " + ID + " is not defined");
			return null;
		}
		
		String typeID = map.get(ID);
		String pair = anim + "-" + typeID;

        // Check if the animation is being added to a valid target
		if (!compatible.contains(pair)) {
			System.err.println("AddAnimationError: Can't add animation to " + ID + " (" + typeID + ")");
			return null;
		} else 
			return "";
    }

    /**
     * Visits every addition of a figure
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddFeature(GeometricsParser.AddFeatureContext ctx) {
        if (visit(ctx.feature()) == null) return null;
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
        if (!map.containsKey(ID)) {
            System.err.println("AddFeatureError: " + ID + " not defined");
            return null;

        // Check if the ID is a shape
        } else if (!map.get(ID).equals("shape")) {
            System.err.println("AddFeatureError: " + ID + " is not a shape");
            return null;
        }

        return "";
    }

    /**
     * Visits every addition of an ID
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitAddID(GeometricsParser.AddIDContext ctx) {
        String ID1 = ctx.ID(0).getText();
		String ID2 = ctx.ID(1).getText();
		
        // Check if the ID1 is not already defined
		if (!map.containsKey(ID1)) {
			System.err.println("AddIDError: " + ID1 + " not defined");
			return null;
        
        // Check if the ID2 is not already defined
		} else if (!map.containsKey(ID2)) {
			System.err.println("AddIDError: " + ID2 + " not defined");
			return null;
		} else if (ID1.equals(ID2)) {
            System.err.println("AddIDError: can't add " + ID1 + " to itself");
            return null;
        }
		
		String typeID1 = map.get(ID1);
		String typeID2 = map.get(ID2);	
    	String pair = typeID1 + "-" + typeID2;
		
        // Check if the ID is being added to a valid target
		if (!compatible.contains(pair)) {
			System.err.println("AddIDError: Can't add " + ID1 + " (" + typeID1 + ") to " + ID2 + " (" + typeID2 + ")");
			return null;
		} 
		
        return "";
	}

    /**
     * Visits every remove
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitRemove(GeometricsParser.RemoveContext ctx) {
        String ID = ctx.ID().getText();

        // Check if the ID was initialized
        if (!map.containsKey(ID)) {
            System.err.println("RemoveError: " + ID + " not found");
            return null;
        }

        map.remove(ID);
        return "";
    }

    /**
     * Visits every figure
     * @param ctx
     * @return "figure" if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitFig(GeometricsParser.FigContext ctx) {
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (map.containsKey(ID)) {
            System.err.println("FigError: " + ID + " already defined");
            return null;
		}
        
        map.put(ID, "figure");

        // Check if there are features and if those have any error
        if (ctx.stat() != null) {
            for (GeometricsParser.StatContext stat : ctx.stat())
                if (visit(stat) == null) {
                    map.remove(ID);
                    return null;
                }
        }
        
        return "figure";	
    }

    /**
     * Visits every animation
     * @param ctx
     * @return "animation"  if no Errors are found
     *         null         if there was an Error
     */
    @Override public String visitAnim(GeometricsParser.AnimContext ctx) {
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) 
            map.put(ID, "animation");
        else {
            System.err.println("AnimError: " + ID + " already defined");
            return null;
        }

        // Check if the animation is going to be repeated
        if (ctx.loop() != null) 
            if (visit(ctx.loop()) == null)
                return null;
			    
        // Check if there are anim statements and if those have any error
        if (ctx.animStat() != null) {
            for (GeometricsParser.AnimStatContext stat : ctx.animStat())
                if (visit(stat) == null) {
                    map.remove(ID);         // Make the ID avaiable
                    return null;
                }
        }
        
        // Check if there are statements and if those have any error
        if (ctx.stat() != null) {
            for (GeometricsParser.StatContext stat : ctx.stat())
                if (visit(stat) == null) {
                    map.remove(ID);         // Make the ID avaiable
                    return null;
                }
        }

        return "animation";	
    }

    /**
     * Visits every translate command
     * @param ctx
     * @return ""       if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitTranslate(GeometricsParser.TranslateContext ctx) {
        // Verify if the ID is defined 
        String ID0 = ctx.obj.getText();
        if (!map.containsKey(ID0)) {
            System.err.println("TranslateError: " + ID0 + " not defined");
            return null;
        }

        // See if the object is a Shape or a Figure
        String typeObj = map.get(ID0);
        if (!(typeObj.equals("shape") || typeObj.equals("figure"))) {
            System.err.println("TranslateError: " + ID0 + " is not a shape or figure");
            return null;
        }

        // See if the target is a point or an ID
        if (ctx.point() == null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {
                System.err.println("TranslateError: " + ID1 + " not defined");
                return null;
            }

            String typeID1 = map.get(ID1);
            if (!typeID1.equals("point")) {
                System.err.println("TranslateError: " + ID1 + " is not a point");
                return null;
            }
        } else
            if (visit(ctx.point()) == null) return null;
        
        return "";
    }

    /**
     * Visits every rotate command
     * @param ctx
     * @return ""       if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitRotate(GeometricsParser.RotateContext ctx) {
        // Verify if the ID is defined 
        String ID0 = ctx.obj.getText();
        if (!map.containsKey(ID0)) {
            System.err.println("RotateError: " + ID0 + " not defined");
            return null;
        }

        // See if the object is a Shape or a Figure
        String typeObj = map.get(ID0);
        if (!(typeObj.equals("shape") || typeObj.equals("figure"))) {
            System.err.println("RotateError: " + ID0 + " is not a shape or figure");
            return null;
        }

        // See if the target is a point or an ID
        if (ctx.point() == null) {
            if (ctx.ID(1) == null) return "";    // No fixed point center will be chosen
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {
                System.err.println("RotateError: " + ID1 + " not defined");
                return null;
            }

            String typeID1 = map.get(ID1);
            if (!typeID1.equals("point")) {
                System.err.println("RotateError: " + ID1 + " is not a point");
                return null;
            }
        } else 
            if (visit(ctx.point()) == null) return null;
        
        return "";
    }

    /**
     * Visits every wait command
     * @param ctx
     * @return ""       it's always semantically valid
     */
    @Override public String visitWaitms(GeometricsParser.WaitmsContext ctx) {
        return "";
    }

    /**
     * Visits every loop
     * @return ""       if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitLoop(GeometricsParser.LoopContext ctx) {
        // There's no need to specify that the animation is going to be executed one time
        if (ctx.Number().getText().equals("1")) {
            System.err.println("LoopError: loop time value cannot be 1");
            return null;
        }

        return "";
    }

    /**
     * Visits every tick
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitTick(GeometricsParser.TickContext ctx) {
        return "";
    }

    /**
     * Visits every line
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeLine(GeometricsParser.ShapeLineContext ctx) {
        // Verify if the ID is already defined and if not put it on the map
		String ID0 = ctx.ID(0).getText();
		if (map.containsKey(ID0)) {
			System.err.println("ShapeLineError: " + ID0 + " already defined");
			return null;
		}
        
        // Check if the 1st parameter is an ID
        if (ctx.ID(1) != null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {                // Check if the ID is defined
                System.err.println("ShapeLineError: " + ID1 + " not defined");
                return null;
            } else if (!map.get(ID1).equals("point")) { // Check if the ID is a point
                System.err.println("ShapeLineError: " + ID1 + " not a point");
                return null;
            }
        } else {
            String typePoint0 = visit(ctx.point(0));
            if (typePoint0 == null) return null;
            if (!typePoint0.equals("point")) {          // Check if the point is valid
                System.err.println("ShapeLineError: point not defined");
                return null;
            }
        }
        
        // Check if the 2nd parameter is an ID
        if (ctx.ID(2) != null) {
            String ID2 = ctx.ID(2).getText();
            if (!map.containsKey(ID2)) {                // Check if the ID is defined
                System.err.println("ShapeLineError: " + ID2 + " not defined");
                return null;
            } else if (!map.get(ID2).equals("point")) { // Check if the ID is a point
                System.err.println("ShapeLineError: " + ID2 + " not a point");
                return null;
            }
        } else {                                        
            // Check if the points are valid
            if (ctx.point(1) != null) {
                String typePoint1 = visit(ctx.point(1));
                if (typePoint1 == null) return null;
                                    
                if(!typePoint1.equals("point")) {
                    System.err.println("ShapeLineError: point not defined");
                    return null;
                }
            }
            
            if (ctx.point(0) != null) {
                String typePoint0 = visit(ctx.point(0));
                if (typePoint0 == null) return null;
                if (!typePoint0.equals("point")) {
                    System.err.println("ShapeLineError: point not defined");
                    return null;
                }
            }
        }

        map.put(ID0, "shape");
        return "shape";
    }

    /**
     * Visits every circle
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeCircle(GeometricsParser.ShapeCircleContext ctx) {
        // Verify if the ID is already defined and if not put it on the map
		String ID0 = ctx.ID(0).getText();
		if (map.containsKey(ID0)) {
			System.err.println("ShapeCircleError: " + ID0 + " already defined");
			return null;
		}
        
        // Check if the 1st parameter is an ID
        if (ctx.ID(1) != null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {                // Check if the ID is defined
                System.err.println("ShapeCircleError: " + ID1 + " not defined");
                return null;
            } else if (!map.get(ID1).equals("point")) { // Check if the ID is a point
                System.err.println("ShapeCircleError: " + ID1 + " not a point");
                return null;
            }
        } else {
            String typePoint = visit(ctx.point());
            if (typePoint == null) return null;
            if (!typePoint.equals("point")) {           // Check if the point is valid
                System.err.println("ShapeCircleError: point not defined");
                return null;
            }
        }
        
        // Check if the radius has no errors and if it is a number
        String typeRadius = visit(ctx.radius);
        if (typeRadius == null) return null;
        if (!typeRadius.equals("number")) {
            System.err.println("ShapeCircleError: radius is not a number");
            return null;
        }

        map.put(ID0, "shape");
        return "shape";
    }

    /**
     * Visits every rectangle
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeRect(GeometricsParser.ShapeRectContext ctx) {
        // Verify if the ID is already defined and if not put it on the map
		String ID0 = ctx.ID(0).getText();
		if (map.containsKey(ID0)) {
			System.err.println("ShapeRectError: " + ID0 + " already defined");
			return null;
		}
        
        // Check if the 1st parameter is an ID
        if (ctx.ID(1) != null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {                // Check if the ID is defined
                System.err.println("ShapeRectError: " + ID1 + " not defined");
                return null;
            } else if (!map.get(ID1).equals("point")) { // Check if the ID is a point
                System.err.println("ShapeRectError: " + ID1 + " not a point");
                return null;
            }
        } else {
            String typePoint = visit(ctx.point());
            if (typePoint == null) return null;
            if (!typePoint.equals("point")) {           // Check if the point is valid
                System.err.println("ShapeRectError: point not defined");
                return null;
            }
        }
        
        // Check if the height has no errors and if it is a number
        String typeHeight = visit(ctx.height);
        if (typeHeight == null) return null;
        // Check if height and width are numbers
        if (!typeHeight.equals("number")) {
            System.err.println("ShapeRectError: height is not a number");
            return null;
        }

        // Check if the width has no errors and if it is a number
        String typeWidth = visit(ctx.width);
        if (typeWidth == null) return null;
        if (!typeWidth.equals("number")) {
            System.err.println("ShapeRectError: width is not a number");
            return null;
        }

        map.put(ID0, "shape");
        return "shape";
    }

    /**
     * Visits every square
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeSquare(GeometricsParser.ShapeSquareContext ctx) {
        // Verify if the ID is already defined and if not put it on the map
		String ID0 = ctx.ID(0).getText();
		if (map.containsKey(ID0)) {
			System.err.println("ShapeSquareError: " + ID0 + " already defined");
			return null;
		}
        
        // Check if the 1st parameter is an ID
        if (ctx.ID(1) != null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {                // Check if the ID is defined
                System.err.println("ShapeSquareError: " + ID1 + " not defined");
                return null;
            } else if (!map.get(ID1).equals("point")) { // Check if the ID is a point
                System.err.println("ShapeSquareError: " + ID1 + " not a point");
                return null;
            }
        } else {
            String typePoint = visit(ctx.point());
            if (typePoint == null) return null;
            if (!typePoint.equals("point")) {           // Check if the point is valid
                System.err.println("ShapeSquareError: point not defined");
                return null;
            }
        }

        // Check if the side has no errors and if it is a number
        String typeSide = visit(ctx.side);
        if (typeSide == null) return null;
        if (!typeSide.equals("number")) {
            System.err.println("ShapeSquareError: side is not a number");
            return null;
        }

        map.put(ID0, "shape");
        return "shape";
    }

    /**
     * Visits every ellipse
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeEllipse(GeometricsParser.ShapeEllipseContext ctx) {
        // Verify if the ID is already defined and if not put it on the map
		String ID0 = ctx.ID(0).getText();
		if (map.containsKey(ID0)) {
			System.err.println("ShapeEllipseError: " + ID0 + " already defined");
			return null;
		}
        
        // Check if the 1st parameter is an ID
        if (ctx.ID(1) != null) {
            String ID1 = ctx.ID(1).getText();
            if (!map.containsKey(ID1)) {                // See if the ID is defined
                System.err.println("ShapeEllipseError: " + ID1 + " not defined");
                return null;
            } else if (!map.get(ID1).equals("point")) { // See if the ID is a point
                System.err.println("ShapeEllipseError: " + ID1 + " not a point");
                return null;
            }
        } else {
            String typePoint = visit(ctx.point());
            if (typePoint == null) return null;
            if (!typePoint.equals("point")) {           // See if the point is valid
                System.err.println("ShapeEllipseError: point not defined");
                return null;
            }
        }
        
        // Check if the axes have no errors and are numbers
        String typeA = visit(ctx.a);
        if (typeA == null) return null;
        if (!typeA.equals("number")) {
            System.err.println("ShapeEllipseError: major axis is not a number");
            return null;
        }
        
        String typeB = visit(ctx.b);
        if (typeB == null) return null;
        if (!visit(ctx.b).equals("number")) {
            System.err.println("ShapeEllipseError: minor axis is not a number");
            return null;
        }

        map.put(ID0, "shape");
        return "shape";
    }

    /**
     * Visits every color feature
     * @param ctx
     * @return ""        if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitFeatureColor(GeometricsParser.FeatureColorContext ctx) {
        // Check if the color is valid
        if (visit(ctx.color()) == null) return null;

        return "";
    }

    /**
     * Visits every thickness feature
     * @param ctx
     * @return "" the number is always semantically valid
     */
    @Override public String visitFeatureThick(GeometricsParser.FeatureThickContext ctx) {
        return "";
    }

    /**
     * Visits every filled feature
     * @param ctx
     * @return "" choice is always semantically valid
     */
    @Override public String visitFeatureFilled(GeometricsParser.FeatureFilledContext ctx) {
        return "";
    }

    /**
     * Visits every hidden feature
     * @param ctx
     * @return "" choice is always semantically valid
     */
    @Override public String visitFeatureHidden(GeometricsParser.FeatureHiddenContext ctx) {
        return "";
    }

    /**
     * Visits every points
     * @param ctx
     * @return "point"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitPoint(GeometricsParser.PointContext ctx) {
        // Check if the expression is valid
        if (visit(ctx.expr(0)) == null || visit(ctx.expr(1)) == null) return null;
		return "point";
    }

    /**
     * Visits every Hexadecimal color
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorHex(GeometricsParser.ColorHexContext ctx) {
        return "";
    }

    /**
     * Visits every RGBA color
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorRGBA(GeometricsParser.ColorRGBAContext ctx) {
        return "";
    }

    /**
     * Visits every color name
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorName(GeometricsParser.ColorNameContext ctx) {
        return "";
    }

    /**
     * Visits every alpha
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitAlpha(GeometricsParser.AlphaContext ctx) {
        return "";
    }
}
