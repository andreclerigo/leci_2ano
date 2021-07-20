// Generated from GeometricsAux.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeometricsAuxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, HTMLColor=38, 
		Number=39, ID=40, NEWLINE=41, WS=42, COMMENT=43;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_fig = 2, RULE_expr = 3, RULE_shape = 4, 
		RULE_feature = 5, RULE_point = 6, RULE_color = 7, RULE_alpha = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "fig", "expr", "shape", "feature", "point", "color", 
			"alpha"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'geometrics:'", "'database'", "'point'", "'is'", "'{'", "'}'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'line'", "'circle'", 
			"'rectangle'", "'square'", "'ellipse'", "'color'", "'thickness'", "'filled'", 
			"'yes'", "'no'", "'hidden'", "','", "'red'", "'blue'", "'green'", "'yellow'", 
			"'black'", "'white'", "'cyan'", "'orange'", "'purple'", "'pink'", "'brown'", 
			"'grey'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "HTMLColor", "Number", "ID", "NEWLINE", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GeometricsAux.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GeometricsAuxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GeometricsAuxParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GeometricsAuxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GeometricsAuxParser.NEWLINE, i);
		}
		public List<FigContext> fig() {
			return getRuleContexts(FigContext.class);
		}
		public FigContext fig(int i) {
			return getRuleContext(FigContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(18);
				match(NEWLINE);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(T__0);
			setState(25);
			match(T__1);
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(28);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(26);
					match(NEWLINE);
					}
					break;
				case ID:
					{
					setState(27);
					fig();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==NEWLINE );
			setState(32);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatNewlineContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(GeometricsAuxParser.NEWLINE, 0); }
		public StatNewlineContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterStatNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitStatNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitStatNewline(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatShapeContext extends StatContext {
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GeometricsAuxParser.NEWLINE, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public StatShapeContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterStatShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitStatShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitStatShape(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatFigContext extends StatContext {
		public FigContext fig() {
			return getRuleContext(FigContext.class,0);
		}
		public StatFigContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterStatFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitStatFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitStatFig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatPointContext extends StatContext {
		public TerminalNode ID() { return getToken(GeometricsAuxParser.ID, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GeometricsAuxParser.NEWLINE, 0); }
		public StatPointContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterStatPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitStatPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitStatPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				_localctx = new StatShapeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				shape();
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23))) != 0)) {
					{
					{
					setState(35);
					feature();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(NEWLINE);
				}
				break;
			case T__2:
				_localctx = new StatPointContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__2);
				setState(44);
				match(ID);
				setState(45);
				point();
				setState(46);
				match(NEWLINE);
				}
				break;
			case ID:
				_localctx = new StatFigContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				fig();
				}
				break;
			case NEWLINE:
				_localctx = new StatNewlineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FigContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GeometricsAuxParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GeometricsAuxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GeometricsAuxParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitFig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigContext fig() throws RecognitionException {
		FigContext _localctx = new FigContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fig);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(ID);
			setState(53);
			match(T__3);
			setState(54);
			match(T__4);
			setState(55);
			match(NEWLINE);
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				stat();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID) | (1L << NEWLINE))) != 0) );
			setState(61);
			match(T__5);
			setState(62);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprAddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterExprAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitExprAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitExprAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParentContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterExprParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitExprParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitExprParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNumberContext extends ExprContext {
		public TerminalNode Number() { return getToken(GeometricsAuxParser.Number, 0); }
		public ExprNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterExprNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitExprNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitExprNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPlusMinusContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprPlusMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterExprPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitExprPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitExprPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterExprMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitExprMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitExprMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
				{
				_localctx = new ExprPlusMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(65);
				((ExprPlusMinusContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
					((ExprPlusMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(66);
				expr(5);
				}
				break;
			case Number:
				{
				_localctx = new ExprNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(Number);
				}
				break;
			case T__11:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(T__11);
				setState(69);
				expr(0);
				setState(70);
				match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(75);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShapeContext extends ParserRuleContext {
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
	 
		public ShapeContext() { }
		public void copyFrom(ShapeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShapeEllipseContext extends ShapeContext {
		public ExprContext a;
		public ExprContext b;
		public List<TerminalNode> ID() { return getTokens(GeometricsAuxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsAuxParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ShapeEllipseContext(ShapeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterShapeEllipse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitShapeEllipse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitShapeEllipse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeCircleContext extends ShapeContext {
		public ExprContext radius;
		public List<TerminalNode> ID() { return getTokens(GeometricsAuxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsAuxParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ShapeCircleContext(ShapeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterShapeCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitShapeCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitShapeCircle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeSquareContext extends ShapeContext {
		public ExprContext side;
		public List<TerminalNode> ID() { return getTokens(GeometricsAuxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsAuxParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ShapeSquareContext(ShapeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterShapeSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitShapeSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitShapeSquare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeLineContext extends ShapeContext {
		public List<TerminalNode> ID() { return getTokens(GeometricsAuxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsAuxParser.ID, i);
		}
		public List<PointContext> point() {
			return getRuleContexts(PointContext.class);
		}
		public PointContext point(int i) {
			return getRuleContext(PointContext.class,i);
		}
		public ShapeLineContext(ShapeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterShapeLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitShapeLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitShapeLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeRectContext extends ShapeContext {
		public ExprContext height;
		public ExprContext width;
		public List<TerminalNode> ID() { return getTokens(GeometricsAuxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsAuxParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ShapeRectContext(ShapeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterShapeRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitShapeRect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitShapeRect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_shape);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new ShapeLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__13);
				setState(86);
				match(ID);
				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(87);
					point();
					}
					break;
				case ID:
					{
					setState(88);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(91);
					point();
					}
					break;
				case ID:
					{
					setState(92);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__14:
				_localctx = new ShapeCircleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(T__14);
				setState(96);
				match(ID);
				setState(99);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(97);
					point();
					}
					break;
				case ID:
					{
					setState(98);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(101);
				((ShapeCircleContext)_localctx).radius = expr(0);
				}
				break;
			case T__15:
				_localctx = new ShapeRectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(T__15);
				setState(103);
				match(ID);
				setState(106);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(104);
					point();
					}
					break;
				case ID:
					{
					setState(105);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(108);
				((ShapeRectContext)_localctx).height = expr(0);
				setState(109);
				((ShapeRectContext)_localctx).width = expr(0);
				}
				break;
			case T__16:
				_localctx = new ShapeSquareContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(T__16);
				setState(112);
				match(ID);
				setState(115);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(113);
					point();
					}
					break;
				case ID:
					{
					setState(114);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117);
				((ShapeSquareContext)_localctx).side = expr(0);
				}
				break;
			case T__17:
				_localctx = new ShapeEllipseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				match(T__17);
				setState(119);
				match(ID);
				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(120);
					point();
					}
					break;
				case ID:
					{
					setState(121);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(124);
				((ShapeEllipseContext)_localctx).a = expr(0);
				setState(125);
				((ShapeEllipseContext)_localctx).b = expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FeatureFilledContext extends FeatureContext {
		public Token op;
		public FeatureFilledContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterFeatureFilled(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitFeatureFilled(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitFeatureFilled(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureThickContext extends FeatureContext {
		public TerminalNode Number() { return getToken(GeometricsAuxParser.Number, 0); }
		public FeatureThickContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterFeatureThick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitFeatureThick(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitFeatureThick(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureColorContext extends FeatureContext {
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public FeatureColorContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterFeatureColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitFeatureColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitFeatureColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureHiddenContext extends FeatureContext {
		public Token op;
		public FeatureHiddenContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterFeatureHidden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitFeatureHidden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitFeatureHidden(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_feature);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				_localctx = new FeatureColorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(T__18);
				setState(130);
				color();
				}
				break;
			case T__19:
				_localctx = new FeatureThickContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__19);
				setState(132);
				match(Number);
				}
				break;
			case T__20:
				_localctx = new FeatureFilledContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(T__20);
				setState(134);
				((FeatureFilledContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((FeatureFilledContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__23:
				_localctx = new FeatureHiddenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(T__23);
				setState(136);
				((FeatureHiddenContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((FeatureHiddenContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__11);
			setState(140);
			expr(0);
			setState(141);
			match(T__24);
			setState(142);
			expr(0);
			setState(143);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColorContext extends ParserRuleContext {
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
	 
		public ColorContext() { }
		public void copyFrom(ColorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColorRGBAContext extends ColorContext {
		public Token red;
		public Token green;
		public Token blue;
		public List<TerminalNode> Number() { return getTokens(GeometricsAuxParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(GeometricsAuxParser.Number, i);
		}
		public AlphaContext alpha() {
			return getRuleContext(AlphaContext.class,0);
		}
		public ColorRGBAContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterColorRGBA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitColorRGBA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitColorRGBA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorHexContext extends ColorContext {
		public TerminalNode HTMLColor() { return getToken(GeometricsAuxParser.HTMLColor, 0); }
		public ColorHexContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterColorHex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitColorHex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitColorHex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorNameContext extends ColorContext {
		public TerminalNode Number() { return getToken(GeometricsAuxParser.Number, 0); }
		public ColorNameContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterColorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitColorName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitColorName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_color);
		int _la;
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTMLColor:
				_localctx = new ColorHexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(HTMLColor);
				}
				break;
			case Number:
				_localctx = new ColorRGBAContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				((ColorRGBAContext)_localctx).red = match(Number);
				setState(147);
				match(T__24);
				setState(148);
				((ColorRGBAContext)_localctx).green = match(Number);
				setState(149);
				match(T__24);
				setState(150);
				((ColorRGBAContext)_localctx).blue = match(Number);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(151);
					alpha();
					}
				}

				}
				break;
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
				_localctx = new ColorNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Number) {
					{
					setState(155);
					match(Number);
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__10) {
						{
						setState(156);
						match(T__10);
						}
					}

					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlphaContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(GeometricsAuxParser.Number, 0); }
		public AlphaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alpha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).enterAlpha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsAuxListener ) ((GeometricsAuxListener)listener).exitAlpha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsAuxVisitor ) return ((GeometricsAuxVisitor<? extends T>)visitor).visitAlpha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlphaContext alpha() throws RecognitionException {
		AlphaContext _localctx = new AlphaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_alpha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__24);
			setState(164);
			match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00a9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2"+
		"\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2"+
		"\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\4\3\4\3\4\3\4\3\4\6\4<\n\4\r\4\16\4=\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5S\n\5\f\5"+
		"\16\5V\13\5\3\6\3\6\3\6\3\6\5\6\\\n\6\3\6\3\6\5\6`\n\6\3\6\3\6\3\6\3\6"+
		"\5\6f\n\6\3\6\3\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"v\n\6\3\6\3\6\3\6\3\6\3\6\5\6}\n\6\3\6\3\6\3\6\5\6\u0082\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u008c\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u009b\n\t\3\t\3\t\3\t\5\t\u00a0\n\t\5\t\u00a2\n"+
		"\t\5\t\u00a4\n\t\3\n\3\n\3\n\3\n\2\3\b\13\2\4\6\b\n\f\16\20\22\2\6\3\2"+
		"\t\n\3\2\13\r\3\2\30\31\3\2\34\'\2\u00bd\2\27\3\2\2\2\4\64\3\2\2\2\6\66"+
		"\3\2\2\2\bJ\3\2\2\2\n\u0081\3\2\2\2\f\u008b\3\2\2\2\16\u008d\3\2\2\2\20"+
		"\u00a3\3\2\2\2\22\u00a5\3\2\2\2\24\26\7+\2\2\25\24\3\2\2\2\26\31\3\2\2"+
		"\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\3\2"+
		"\2\33\36\7\4\2\2\34\37\7+\2\2\35\37\5\6\4\2\36\34\3\2\2\2\36\35\3\2\2"+
		"\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2"+
		"$(\5\n\6\2%\'\5\f\7\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2"+
		"\2*(\3\2\2\2+,\7+\2\2,\65\3\2\2\2-.\7\5\2\2./\7*\2\2/\60\5\16\b\2\60\61"+
		"\7+\2\2\61\65\3\2\2\2\62\65\5\6\4\2\63\65\7+\2\2\64$\3\2\2\2\64-\3\2\2"+
		"\2\64\62\3\2\2\2\64\63\3\2\2\2\65\5\3\2\2\2\66\67\7*\2\2\678\7\6\2\28"+
		"9\7\7\2\29;\7+\2\2:<\5\4\3\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>"+
		"?\3\2\2\2?@\7\b\2\2@A\7+\2\2A\7\3\2\2\2BC\b\5\1\2CD\t\2\2\2DK\5\b\5\7"+
		"EK\7)\2\2FG\7\16\2\2GH\5\b\5\2HI\7\17\2\2IK\3\2\2\2JB\3\2\2\2JE\3\2\2"+
		"\2JF\3\2\2\2KT\3\2\2\2LM\f\6\2\2MN\t\3\2\2NS\5\b\5\7OP\f\5\2\2PQ\t\2\2"+
		"\2QS\5\b\5\6RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\t\3\2"+
		"\2\2VT\3\2\2\2WX\7\20\2\2X[\7*\2\2Y\\\5\16\b\2Z\\\7*\2\2[Y\3\2\2\2[Z\3"+
		"\2\2\2\\_\3\2\2\2]`\5\16\b\2^`\7*\2\2_]\3\2\2\2_^\3\2\2\2`\u0082\3\2\2"+
		"\2ab\7\21\2\2be\7*\2\2cf\5\16\b\2df\7*\2\2ec\3\2\2\2ed\3\2\2\2fg\3\2\2"+
		"\2g\u0082\5\b\5\2hi\7\22\2\2il\7*\2\2jm\5\16\b\2km\7*\2\2lj\3\2\2\2lk"+
		"\3\2\2\2mn\3\2\2\2no\5\b\5\2op\5\b\5\2p\u0082\3\2\2\2qr\7\23\2\2ru\7*"+
		"\2\2sv\5\16\b\2tv\7*\2\2us\3\2\2\2ut\3\2\2\2vw\3\2\2\2w\u0082\5\b\5\2"+
		"xy\7\24\2\2y|\7*\2\2z}\5\16\b\2{}\7*\2\2|z\3\2\2\2|{\3\2\2\2}~\3\2\2\2"+
		"~\177\5\b\5\2\177\u0080\5\b\5\2\u0080\u0082\3\2\2\2\u0081W\3\2\2\2\u0081"+
		"a\3\2\2\2\u0081h\3\2\2\2\u0081q\3\2\2\2\u0081x\3\2\2\2\u0082\13\3\2\2"+
		"\2\u0083\u0084\7\25\2\2\u0084\u008c\5\20\t\2\u0085\u0086\7\26\2\2\u0086"+
		"\u008c\7)\2\2\u0087\u0088\7\27\2\2\u0088\u008c\t\4\2\2\u0089\u008a\7\32"+
		"\2\2\u008a\u008c\t\4\2\2\u008b\u0083\3\2\2\2\u008b\u0085\3\2\2\2\u008b"+
		"\u0087\3\2\2\2\u008b\u0089\3\2\2\2\u008c\r\3\2\2\2\u008d\u008e\7\16\2"+
		"\2\u008e\u008f\5\b\5\2\u008f\u0090\7\33\2\2\u0090\u0091\5\b\5\2\u0091"+
		"\u0092\7\17\2\2\u0092\17\3\2\2\2\u0093\u00a4\7(\2\2\u0094\u0095\7)\2\2"+
		"\u0095\u0096\7\33\2\2\u0096\u0097\7)\2\2\u0097\u0098\7\33\2\2\u0098\u009a"+
		"\7)\2\2\u0099\u009b\5\22\n\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u00a4\3\2\2\2\u009c\u00a1\t\5\2\2\u009d\u009f\7)\2\2\u009e\u00a0\7\r"+
		"\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u0093\3\2"+
		"\2\2\u00a3\u0094\3\2\2\2\u00a3\u009c\3\2\2\2\u00a4\21\3\2\2\2\u00a5\u00a6"+
		"\7\33\2\2\u00a6\u00a7\7)\2\2\u00a7\23\3\2\2\2\27\27\36 (\64=JRT[_elu|"+
		"\u0081\u008b\u009a\u009f\u00a1\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}