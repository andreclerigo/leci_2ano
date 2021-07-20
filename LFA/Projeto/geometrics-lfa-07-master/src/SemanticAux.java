import java.util.HashMap;

public class SemanticAux extends GeometricsAuxBaseVisitor<String> {
    HashMap<String, String> map = new HashMap<>();
    
    /**
     * Returns the HashMap created by the Semantic visitor
     * This is will be merged later with the HashMap from the Geometrics Main language visitor
     * @return HashMap<String, String>
     */
	public HashMap<String, String> getMap() {
		return map;
	}
	
    /**
     * Visits every statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitProgram(GeometricsAuxParser.ProgramContext ctx) {
        for (GeometricsAuxParser.FigContext figt : ctx.fig()) {
            String res = visit(figt);
            if (res == null) {
                System.out.println(res);    // DEBUG
                return null;
            }
        }

        return "";
    }

    /**
     * Visits every shape statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatShape(GeometricsAuxParser.StatShapeContext ctx) {
        if (visit(ctx.shape()) == null) return null;
        
        // If the shape has 1 or more features
        if (ctx.feature() != null)
            // Check if any feature has an error
            for (GeometricsAuxParser.FeatureContext feature : ctx.feature())
                if (visit(feature) == null) return null;
                
        return "";
    }

    /**
     * Visits every point statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatPoint(GeometricsAuxParser.StatPointContext ctx) {
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {         
            if (visit(ctx.point()) == null) return null;
			map.put(ID, "point");

            return "";
		}

        System.err.println("StatPointError: " + ID + " already defined");
        return null;
    }

    /**
     * Visits every figure statement
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitStatFig(GeometricsAuxParser.StatFigContext ctx) {
        if (visit(ctx.fig()) == null) return null;
        
        return "";
    }

    /**
     * Visits every NEWLINE statement
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitStatNewline(GeometricsAuxParser.StatNewlineContext ctx) {
        return "";
    }

    /**
     * Visits every figure
     * @param ctx
     * @return "figure" if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitFig(GeometricsAuxParser.FigContext ctx) {
        // Check if there are features and if those have any error
        for (GeometricsAuxParser.StatContext stat : ctx.stat())
            if (visit(stat) == null) return null;
        
        String ID = ctx.ID().getText();

        // Check if the ID is not already defined
		if (!map.containsKey(ID)) {
			map.put(ID, "figure");
			return "";	
		}

        System.err.println("FigError: " + ID + " already defined");
        return null;
    }

    /**
     * Visits every AddSub expression
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprAddSub(GeometricsAuxParser.ExprAddSubContext ctx) {
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
    @Override public String visitExprParent(GeometricsAuxParser.ExprParentContext ctx) {
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
    @Override public String visitExprNumber(GeometricsAuxParser.ExprNumberContext ctx) {
        return "number";
    }
	
    /**
     * Visits every expression that is preceded by a '+' or '-'
     * @param ctx
     * @return ""   if no Errors are found
     *         null if there was an Error
     */
    @Override public String visitExprPlusMinus(GeometricsAuxParser.ExprPlusMinusContext ctx) {
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
    @Override public String visitExprMultDivMod(GeometricsAuxParser.ExprMultDivModContext ctx) {
        if (visit(ctx.expr(0)) == null) return null;    // If the first expression has errors return null
        if (visit(ctx.expr(1)) == null) return null;    // If the second expression has errors return null
        return "number";
    }

     /**
     * Visits every line
     * @param ctx
     * @return "shape"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitShapeLine(GeometricsAuxParser.ShapeLineContext ctx) {
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
    @Override public String visitShapeCircle(GeometricsAuxParser.ShapeCircleContext ctx) {
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
    @Override public String visitShapeRect(GeometricsAuxParser.ShapeRectContext ctx) {
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
    @Override public String visitShapeSquare(GeometricsAuxParser.ShapeSquareContext ctx) {
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
    @Override public String visitShapeEllipse(GeometricsAuxParser.ShapeEllipseContext ctx) {
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
    @Override public String visitFeatureColor(GeometricsAuxParser.FeatureColorContext ctx) {
        // Check if the color is valid
        if (visit(ctx.color()) == null) return null;

        return "";
    }

    /**
     * Visits every thickness feature
     * @param ctx
     * @return "" the number is always semantically valid
     */
    @Override public String visitFeatureThick(GeometricsAuxParser.FeatureThickContext ctx) {
        return "";
    }

    /**
     * Visits every filled feature
     * @param ctx
     * @return "" choice is always semantically valid
     */
    @Override public String visitFeatureFilled(GeometricsAuxParser.FeatureFilledContext ctx) {
        return "";
    }

    /**
     * Visits every hidden feature
     * @param ctx
     * @return "" choice is always semantically valid
     */
    @Override public String visitFeatureHidden(GeometricsAuxParser.FeatureHiddenContext ctx) {
        return "";
    }

    /**
     * Visits every points
     * @param ctx
     * @return "point"  if no Errors are found
     *         null     if there was an Error
     */
    @Override public String visitPoint(GeometricsAuxParser.PointContext ctx) {
        // Check if the expression is valid
        if (visit(ctx.expr(0)) == null || visit(ctx.expr(1)) == null) return null;
		return "point";
    }

    /**
     * Visits every Hexadecimal color
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorHex(GeometricsAuxParser.ColorHexContext ctx) {
        return "";
    }

    /**
     * Visits every RGBA color
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorRGBA(GeometricsAuxParser.ColorRGBAContext ctx) {
        return "";
    }

    /**
     * Visits every color name
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitColorName(GeometricsAuxParser.ColorNameContext ctx) {
        return "";
    }

    /**
     * Visits every alpha
     * @param ctx
     * @return "" it's always semantically valid
     */
    @Override public String visitAlpha(GeometricsAuxParser.AlphaContext ctx) {
        return "";
    }
}
