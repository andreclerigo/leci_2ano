// Generated from Geometrics.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeometricsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, HTMLColor=51, Number=52, 
		ID=53, NEWLINE=54, STRING=55, WS=56, COMMENT=57;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_animStat = 2, RULE_aux = 3, RULE_assig = 4, 
		RULE_expr = 5, RULE_add = 6, RULE_remove = 7, RULE_translate = 8, RULE_rotate = 9, 
		RULE_fig = 10, RULE_anim = 11, RULE_tick = 12, RULE_loop = 13, RULE_waitms = 14, 
		RULE_shape = 15, RULE_feature = 16, RULE_point = 17, RULE_color = 18, 
		RULE_alpha = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "animStat", "aux", "assig", "expr", "add", "remove", 
			"translate", "rotate", "fig", "anim", "tick", "loop", "waitms", "shape", 
			"feature", "point", "color", "alpha"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'geometrics:'", "'main'", "'import'", "'point'", "'='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'('", "')'", "'add'", "'to'", "'remove'", 
			"'translate'", "'rotate'", "'over'", "'figure'", "'{'", "'}'", "'animation'", 
			"'tick is'", "'loop'", "'times'", "'wait'", "'line'", "'circle'", "'rectangle'", 
			"'square'", "'ellipse'", "'color'", "'thickness'", "'filled'", "'yes'", 
			"'no'", "'hidden'", "','", "'red'", "'blue'", "'green'", "'yellow'", 
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
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "HTMLColor", "Number", "ID", "NEWLINE", "STRING", "WS", 
			"COMMENT"
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
	public String getGrammarFileName() { return "Geometrics.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GeometricsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GeometricsParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GeometricsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GeometricsParser.NEWLINE, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(40);
				match(NEWLINE);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(T__0);
			setState(47);
			match(T__1);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__12) | (1L << T__14) | (1L << T__18) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(48);
				stat();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
		public String var;
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class StatNewlineContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public StatNewlineContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterStatNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitStatNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitStatNewline(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAuxContext extends StatContext {
		public AuxContext aux() {
			return getRuleContext(AuxContext.class,0);
		}
		public StatAuxContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterStatAux(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitStatAux(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitStatAux(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAddContext extends StatContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public StatAddContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterStatAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitStatAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitStatAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAssigContext extends StatContext {
		public AssigContext assig() {
			return getRuleContext(AssigContext.class,0);
		}
		public StatAssigContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterStatAssig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitStatAssig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitStatAssig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatRemoveContext extends StatContext {
		public RemoveContext remove() {
			return getRuleContext(RemoveContext.class,0);
		}
		public StatRemoveContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterStatRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitStatRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitStatRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__18:
			case T__21:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case ID:
				_localctx = new StatAssigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				assig();
				}
				break;
			case T__12:
				_localctx = new StatAddContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				add();
				}
				break;
			case T__14:
				_localctx = new StatRemoveContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				remove();
				}
				break;
			case T__2:
				_localctx = new StatAuxContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				aux();
				}
				break;
			case NEWLINE:
				_localctx = new StatNewlineContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
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

	public static class AnimStatContext extends ParserRuleContext {
		public AnimStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animStat; }
	 
		public AnimStatContext() { }
		public void copyFrom(AnimStatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnimStatRotateContext extends AnimStatContext {
		public RotateContext rotate() {
			return getRuleContext(RotateContext.class,0);
		}
		public AnimStatRotateContext(AnimStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAnimStatRotate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAnimStatRotate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAnimStatRotate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnimStatTranslateContext extends AnimStatContext {
		public TranslateContext translate() {
			return getRuleContext(TranslateContext.class,0);
		}
		public AnimStatTranslateContext(AnimStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAnimStatTranslate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAnimStatTranslate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAnimStatTranslate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnimStatWaitmsContext extends AnimStatContext {
		public WaitmsContext waitms() {
			return getRuleContext(WaitmsContext.class,0);
		}
		public AnimStatWaitmsContext(AnimStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAnimStatWaitms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAnimStatWaitms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAnimStatWaitms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnimStatContext animStat() throws RecognitionException {
		AnimStatContext _localctx = new AnimStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_animStat);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				_localctx = new AnimStatTranslateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				translate();
				}
				break;
			case T__16:
				_localctx = new AnimStatRotateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				rotate();
				}
				break;
			case T__25:
				_localctx = new AnimStatWaitmsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				waitms();
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

	public static class AuxContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GeometricsParser.STRING, 0); }
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public AuxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aux; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAux(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAux(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAux(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuxContext aux() throws RecognitionException {
		AuxContext _localctx = new AuxContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aux);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__2);
			setState(69);
			match(STRING);
			setState(70);
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

	public static class AssigContext extends ParserRuleContext {
		public String var;
		public AssigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assig; }
	 
		public AssigContext() { }
		public void copyFrom(AssigContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class AssigAnimationContext extends AssigContext {
		public AnimContext anim() {
			return getRuleContext(AnimContext.class,0);
		}
		public AssigAnimationContext(AssigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAssigAnimation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAssigAnimation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAssigAnimation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigPointContext extends AssigContext {
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public AssigPointContext(AssigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAssigPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAssigPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAssigPoint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigFigureContext extends AssigContext {
		public FigContext fig() {
			return getRuleContext(FigContext.class,0);
		}
		public AssigFigureContext(AssigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAssigFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAssigFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAssigFigure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigExprContext extends AssigContext {
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public AssigExprContext(AssigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAssigExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAssigExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAssigExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigShapeContext extends AssigContext {
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public AssigShapeContext(AssigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAssigShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAssigShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAssigShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssigContext assig() throws RecognitionException {
		AssigContext _localctx = new AssigContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assig);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
				_localctx = new AssigShapeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				shape();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__36))) != 0)) {
					{
					{
					setState(73);
					feature();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(NEWLINE);
				}
				break;
			case T__3:
				_localctx = new AssigPointContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__3);
				setState(82);
				match(ID);
				setState(83);
				point();
				setState(84);
				match(NEWLINE);
				}
				break;
			case T__21:
				_localctx = new AssigAnimationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				anim();
				}
				break;
			case T__18:
				_localctx = new AssigFigureContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				fig();
				}
				break;
			case ID:
				_localctx = new AssigExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(ID);
				setState(89);
				match(T__4);
				setState(90);
				expr(0);
				setState(91);
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

	public static class ExprContext extends ParserRuleContext {
		public String var;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprAddSub(this);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNumberContext extends ExprContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public ExprNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprNumber(this);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public ExprIDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprID(this);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterExprMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitExprMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitExprMultDivMod(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
				{
				_localctx = new ExprPlusMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(96);
				((ExprPlusMinusContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
					((ExprPlusMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				expr(6);
				}
				break;
			case Number:
				{
				_localctx = new ExprNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(Number);
				}
				break;
			case T__10:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(T__10);
				setState(100);
				expr(0);
				setState(101);
				match(T__11);
				}
				break;
			case ID:
				{
				_localctx = new ExprIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(107);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(110);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(116);
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

	public static class AddContext extends ParserRuleContext {
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
	 
		public AddContext() { }
		public void copyFrom(AddContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddShapeContext extends AddContext {
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public AddShapeContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddShape(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddPointContext extends AddContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public AddPointContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddPoint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddFeatureContext extends AddContext {
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public AddFeatureContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddFeature(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddFigureContext extends AddContext {
		public FigContext fig() {
			return getRuleContext(FigContext.class,0);
		}
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public AddFigureContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddFigure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddAnimContext extends AddContext {
		public AnimContext anim() {
			return getRuleContext(AnimContext.class,0);
		}
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public AddAnimContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddAnim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddAnim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddAnim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddNumberContext extends AddContext {
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public AddNumberContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddIDContext extends AddContext {
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
		}
		public AddIDContext(AddContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAddID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAddID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAddID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_add);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new AddShapeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(T__12);
				setState(118);
				shape();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__36))) != 0)) {
					{
					{
					setState(119);
					feature();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(T__13);
				setState(126);
				match(ID);
				}
				break;
			case 2:
				_localctx = new AddPointContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__12);
				setState(129);
				point();
				setState(130);
				match(T__13);
				setState(131);
				match(ID);
				}
				break;
			case 3:
				_localctx = new AddFigureContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(T__12);
				setState(134);
				fig();
				setState(135);
				match(T__13);
				setState(136);
				match(ID);
				}
				break;
			case 4:
				_localctx = new AddAnimContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(T__12);
				setState(139);
				anim();
				setState(140);
				match(T__13);
				setState(141);
				match(ID);
				}
				break;
			case 5:
				_localctx = new AddFeatureContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				match(T__12);
				setState(144);
				feature();
				setState(145);
				match(T__13);
				setState(146);
				match(ID);
				}
				break;
			case 6:
				_localctx = new AddNumberContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(T__12);
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Number:
					{
					setState(149);
					match(Number);
					}
					break;
				case T__6:
					{
					setState(150);
					match(T__6);
					setState(151);
					match(Number);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154);
				match(T__13);
				setState(155);
				match(ID);
				}
				break;
			case 7:
				_localctx = new AddIDContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				match(T__12);
				setState(157);
				match(ID);
				setState(158);
				match(T__13);
				setState(159);
				match(ID);
				}
				break;
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

	public static class RemoveContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemoveContext remove() throws RecognitionException {
		RemoveContext _localctx = new RemoveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_remove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__14);
			setState(163);
			match(ID);
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

	public static class TranslateContext extends ParserRuleContext {
		public Token obj;
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
		}
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TranslateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterTranslate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitTranslate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitTranslate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslateContext translate() throws RecognitionException {
		TranslateContext _localctx = new TranslateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_translate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__15);
			setState(166);
			((TranslateContext)_localctx).obj = match(ID);
			setState(167);
			match(T__13);
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(168);
				point();
				}
				break;
			case ID:
				{
				setState(169);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(172);
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

	public static class RotateContext extends ParserRuleContext {
		public Token obj;
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
		}
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public RotateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterRotate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitRotate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitRotate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotateContext rotate() throws RecognitionException {
		RotateContext _localctx = new RotateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rotate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__16);
			setState(175);
			((RotateContext)_localctx).obj = match(ID);
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(176);
				match(Number);
				}
				break;
			case T__6:
				{
				setState(177);
				match(T__6);
				setState(178);
				match(Number);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(181);
				match(T__17);
				setState(184);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(182);
					point();
					}
					break;
				case ID:
					{
					setState(183);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(188);
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

	public static class FigContext extends ParserRuleContext {
		public String var = null;
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GeometricsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GeometricsParser.NEWLINE, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterFig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitFig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitFig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigContext fig() throws RecognitionException {
		FigContext _localctx = new FigContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fig);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__18);
			setState(191);
			match(ID);
			setState(192);
			match(T__19);
			setState(193);
			match(NEWLINE);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__12) | (1L << T__14) | (1L << T__18) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(194);
				stat();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			match(T__20);
			setState(201);
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

	public static class AnimContext extends ParserRuleContext {
		public String var;
		public TerminalNode ID() { return getToken(GeometricsParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GeometricsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GeometricsParser.NEWLINE, i);
		}
		public TickContext tick() {
			return getRuleContext(TickContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public List<AnimStatContext> animStat() {
			return getRuleContexts(AnimStatContext.class);
		}
		public AnimStatContext animStat(int i) {
			return getRuleContext(AnimStatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public AnimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAnim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAnim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAnim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnimContext anim() throws RecognitionException {
		AnimContext _localctx = new AnimContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_anim);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__21);
			setState(204);
			match(ID);
			setState(205);
			match(T__19);
			setState(206);
			match(NEWLINE);
			setState(207);
			tick();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(208);
				loop();
				}
			}

			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__21) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NEWLINE))) != 0)) {
				{
				setState(213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__15:
				case T__16:
				case T__25:
					{
					setState(211);
					animStat();
					}
					break;
				case T__2:
				case T__3:
				case T__12:
				case T__14:
				case T__18:
				case T__21:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
				case T__30:
				case ID:
				case NEWLINE:
					{
					setState(212);
					stat();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			match(T__20);
			setState(219);
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

	public static class TickContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public TickContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tick; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterTick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitTick(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitTick(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TickContext tick() throws RecognitionException {
		TickContext _localctx = new TickContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tick);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__22);
			setState(222);
			match(Number);
			setState(223);
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__23);
			setState(226);
			match(Number);
			setState(227);
			match(T__24);
			setState(228);
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

	public static class WaitmsContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public TerminalNode NEWLINE() { return getToken(GeometricsParser.NEWLINE, 0); }
		public WaitmsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterWaitms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitWaitms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitWaitms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitmsContext waitms() throws RecognitionException {
		WaitmsContext _localctx = new WaitmsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_waitms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__25);
			setState(231);
			match(Number);
			setState(232);
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

	public static class ShapeContext extends ParserRuleContext {
		public String var;
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
	 
		public ShapeContext() { }
		public void copyFrom(ShapeContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class ShapeEllipseContext extends ShapeContext {
		public ExprContext a;
		public ExprContext b;
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterShapeEllipse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitShapeEllipse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitShapeEllipse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeCircleContext extends ShapeContext {
		public ExprContext radius;
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterShapeCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitShapeCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitShapeCircle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeSquareContext extends ShapeContext {
		public ExprContext side;
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterShapeSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitShapeSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitShapeSquare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeLineContext extends ShapeContext {
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterShapeLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitShapeLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitShapeLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShapeRectContext extends ShapeContext {
		public ExprContext height;
		public ExprContext width;
		public List<TerminalNode> ID() { return getTokens(GeometricsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GeometricsParser.ID, i);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterShapeRect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitShapeRect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitShapeRect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_shape);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				_localctx = new ShapeLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__26);
				setState(235);
				match(ID);
				setState(238);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(236);
					point();
					}
					break;
				case ID:
					{
					setState(237);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(242);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(240);
					point();
					}
					break;
				case ID:
					{
					setState(241);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__27:
				_localctx = new ShapeCircleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(T__27);
				setState(245);
				match(ID);
				setState(248);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(246);
					point();
					}
					break;
				case ID:
					{
					setState(247);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(250);
				((ShapeCircleContext)_localctx).radius = expr(0);
				}
				break;
			case T__28:
				_localctx = new ShapeRectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				match(T__28);
				setState(252);
				match(ID);
				setState(255);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(253);
					point();
					}
					break;
				case ID:
					{
					setState(254);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(257);
				((ShapeRectContext)_localctx).height = expr(0);
				setState(258);
				((ShapeRectContext)_localctx).width = expr(0);
				}
				break;
			case T__29:
				_localctx = new ShapeSquareContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(260);
				match(T__29);
				setState(261);
				match(ID);
				setState(264);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(262);
					point();
					}
					break;
				case ID:
					{
					setState(263);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266);
				((ShapeSquareContext)_localctx).side = expr(0);
				}
				break;
			case T__30:
				_localctx = new ShapeEllipseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(267);
				match(T__30);
				setState(268);
				match(ID);
				setState(271);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(269);
					point();
					}
					break;
				case ID:
					{
					setState(270);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(273);
				((ShapeEllipseContext)_localctx).a = expr(0);
				setState(274);
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
		public String var;
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class FeatureFilledContext extends FeatureContext {
		public Token op;
		public FeatureFilledContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterFeatureFilled(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitFeatureFilled(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitFeatureFilled(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureThickContext extends FeatureContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public FeatureThickContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterFeatureThick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitFeatureThick(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitFeatureThick(this);
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterFeatureColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitFeatureColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitFeatureColor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureHiddenContext extends FeatureContext {
		public Token op;
		public FeatureHiddenContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterFeatureHidden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitFeatureHidden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitFeatureHidden(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_feature);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				_localctx = new FeatureColorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(T__31);
				setState(279);
				color();
				}
				break;
			case T__32:
				_localctx = new FeatureThickContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(T__32);
				setState(281);
				match(Number);
				}
				break;
			case T__33:
				_localctx = new FeatureFilledContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				match(T__33);
				setState(283);
				((FeatureFilledContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__34 || _la==T__35) ) {
					((FeatureFilledContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__36:
				_localctx = new FeatureHiddenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(284);
				match(T__36);
				setState(285);
				((FeatureHiddenContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__34 || _la==T__35) ) {
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
		public String var;
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
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__10);
			setState(289);
			expr(0);
			setState(290);
			match(T__37);
			setState(291);
			expr(0);
			setState(292);
			match(T__11);
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
		public String var;
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
	 
		public ColorContext() { }
		public void copyFrom(ColorContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class ColorRGBAContext extends ColorContext {
		public Token red;
		public Token green;
		public Token blue;
		public List<TerminalNode> Number() { return getTokens(GeometricsParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(GeometricsParser.Number, i);
		}
		public AlphaContext alpha() {
			return getRuleContext(AlphaContext.class,0);
		}
		public ColorRGBAContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterColorRGBA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitColorRGBA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitColorRGBA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorHexContext extends ColorContext {
		public TerminalNode HTMLColor() { return getToken(GeometricsParser.HTMLColor, 0); }
		public ColorHexContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterColorHex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitColorHex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitColorHex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorNameContext extends ColorContext {
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public ColorNameContext(ColorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterColorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitColorName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitColorName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_color);
		int _la;
		try {
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTMLColor:
				_localctx = new ColorHexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(HTMLColor);
				}
				break;
			case Number:
				_localctx = new ColorRGBAContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				((ColorRGBAContext)_localctx).red = match(Number);
				setState(296);
				match(T__37);
				setState(297);
				((ColorRGBAContext)_localctx).green = match(Number);
				setState(298);
				match(T__37);
				setState(299);
				((ColorRGBAContext)_localctx).blue = match(Number);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__37) {
					{
					setState(300);
					alpha();
					}
				}

				}
				break;
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
				_localctx = new ColorNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Number) {
					{
					setState(304);
					match(Number);
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
						setState(305);
						match(T__9);
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
		public TerminalNode Number() { return getToken(GeometricsParser.Number, 0); }
		public AlphaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alpha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).enterAlpha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GeometricsListener ) ((GeometricsListener)listener).exitAlpha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GeometricsVisitor ) return ((GeometricsVisitor<? extends T>)visitor).visitAlpha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlphaContext alpha() throws RecognitionException {
		AlphaContext _localctx = new AlphaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_alpha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__37);
			setState(313);
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
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u013e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2"+
		"\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\4"+
		"\3\4\3\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6`\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7s\n\7"+
		"\f\7\16\7v\13\7\3\b\3\b\3\b\7\b{\n\b\f\b\16\b~\13\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u009b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3\n"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ad\n\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00b6\n\13\3\13\3\13\3\13\5\13\u00bb\n\13\5\13\u00bd\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u00c6\n\f\f\f\16\f\u00c9\13\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\r\3\r\7\r\u00d8\n\r"+
		"\f\r\16\r\u00db\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00f1\n\21\3\21"+
		"\3\21\5\21\u00f5\n\21\3\21\3\21\3\21\3\21\5\21\u00fb\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0102\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u010b\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u0112\n\21\3\21\3\21\3\21\5"+
		"\21\u0117\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0121\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0130\n\24\3\24\3\24\3\24\5\24\u0135\n\24\5\24\u0137\n\24\5\24\u0139"+
		"\n\24\3\25\3\25\3\25\3\25\2\3\f\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(\2\6\3\2\b\t\3\2\n\f\3\2%&\3\2)\64\2\u015d\2-\3\2\2\2\4?\3\2"+
		"\2\2\6D\3\2\2\2\bF\3\2\2\2\n_\3\2\2\2\fj\3\2\2\2\16\u00a2\3\2\2\2\20\u00a4"+
		"\3\2\2\2\22\u00a7\3\2\2\2\24\u00b0\3\2\2\2\26\u00c0\3\2\2\2\30\u00cd\3"+
		"\2\2\2\32\u00df\3\2\2\2\34\u00e3\3\2\2\2\36\u00e8\3\2\2\2 \u0116\3\2\2"+
		"\2\"\u0120\3\2\2\2$\u0122\3\2\2\2&\u0138\3\2\2\2(\u013a\3\2\2\2*,\78\2"+
		"\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61"+
		"\7\3\2\2\61\65\7\4\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63"+
		"\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2"+
		":@\5\n\6\2;@\5\16\b\2<@\5\20\t\2=@\5\b\5\2>@\78\2\2?:\3\2\2\2?;\3\2\2"+
		"\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\5\3\2\2\2AE\5\22\n\2BE\5\24\13\2CE\5"+
		"\36\20\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\7\3\2\2\2FG\7\5\2\2GH\79\2\2H"+
		"I\78\2\2I\t\3\2\2\2JN\5 \21\2KM\5\"\22\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\78\2\2R`\3\2\2\2ST\7\6\2\2TU\7\67\2\2"+
		"UV\5$\23\2VW\78\2\2W`\3\2\2\2X`\5\30\r\2Y`\5\26\f\2Z[\7\67\2\2[\\\7\7"+
		"\2\2\\]\5\f\7\2]^\78\2\2^`\3\2\2\2_J\3\2\2\2_S\3\2\2\2_X\3\2\2\2_Y\3\2"+
		"\2\2_Z\3\2\2\2`\13\3\2\2\2ab\b\7\1\2bc\t\2\2\2ck\5\f\7\bdk\7\66\2\2ef"+
		"\7\r\2\2fg\5\f\7\2gh\7\16\2\2hk\3\2\2\2ik\7\67\2\2ja\3\2\2\2jd\3\2\2\2"+
		"je\3\2\2\2ji\3\2\2\2kt\3\2\2\2lm\f\7\2\2mn\t\3\2\2ns\5\f\7\bop\f\6\2\2"+
		"pq\t\2\2\2qs\5\f\7\7rl\3\2\2\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2"+
		"u\r\3\2\2\2vt\3\2\2\2wx\7\17\2\2x|\5 \21\2y{\5\"\22\2zy\3\2\2\2{~\3\2"+
		"\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\20\2\2\u0080"+
		"\u0081\7\67\2\2\u0081\u00a3\3\2\2\2\u0082\u0083\7\17\2\2\u0083\u0084\5"+
		"$\23\2\u0084\u0085\7\20\2\2\u0085\u0086\7\67\2\2\u0086\u00a3\3\2\2\2\u0087"+
		"\u0088\7\17\2\2\u0088\u0089\5\26\f\2\u0089\u008a\7\20\2\2\u008a\u008b"+
		"\7\67\2\2\u008b\u00a3\3\2\2\2\u008c\u008d\7\17\2\2\u008d\u008e\5\30\r"+
		"\2\u008e\u008f\7\20\2\2\u008f\u0090\7\67\2\2\u0090\u00a3\3\2\2\2\u0091"+
		"\u0092\7\17\2\2\u0092\u0093\5\"\22\2\u0093\u0094\7\20\2\2\u0094\u0095"+
		"\7\67\2\2\u0095\u00a3\3\2\2\2\u0096\u009a\7\17\2\2\u0097\u009b\7\66\2"+
		"\2\u0098\u0099\7\t\2\2\u0099\u009b\7\66\2\2\u009a\u0097\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\20\2\2\u009d\u00a3\7"+
		"\67\2\2\u009e\u009f\7\17\2\2\u009f\u00a0\7\67\2\2\u00a0\u00a1\7\20\2\2"+
		"\u00a1\u00a3\7\67\2\2\u00a2w\3\2\2\2\u00a2\u0082\3\2\2\2\u00a2\u0087\3"+
		"\2\2\2\u00a2\u008c\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2"+
		"\u009e\3\2\2\2\u00a3\17\3\2\2\2\u00a4\u00a5\7\21\2\2\u00a5\u00a6\7\67"+
		"\2\2\u00a6\21\3\2\2\2\u00a7\u00a8\7\22\2\2\u00a8\u00a9\7\67\2\2\u00a9"+
		"\u00ac\7\20\2\2\u00aa\u00ad\5$\23\2\u00ab\u00ad\7\67\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\78\2\2\u00af"+
		"\23\3\2\2\2\u00b0\u00b1\7\23\2\2\u00b1\u00b5\7\67\2\2\u00b2\u00b6\7\66"+
		"\2\2\u00b3\u00b4\7\t\2\2\u00b4\u00b6\7\66\2\2\u00b5\u00b2\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00bc\3\2\2\2\u00b7\u00ba\7\24\2\2\u00b8\u00bb\5"+
		"$\23\2\u00b9\u00bb\7\67\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\78\2\2\u00bf\25\3\2\2\2\u00c0\u00c1\7\25\2\2\u00c1\u00c2"+
		"\7\67\2\2\u00c2\u00c3\7\26\2\2\u00c3\u00c7\78\2\2\u00c4\u00c6\5\4\3\2"+
		"\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\27\2\2"+
		"\u00cb\u00cc\78\2\2\u00cc\27\3\2\2\2\u00cd\u00ce\7\30\2\2\u00ce\u00cf"+
		"\7\67\2\2\u00cf\u00d0\7\26\2\2\u00d0\u00d1\78\2\2\u00d1\u00d3\5\32\16"+
		"\2\u00d2\u00d4\5\34\17\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d9\3\2\2\2\u00d5\u00d8\5\6\4\2\u00d6\u00d8\5\4\3\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7\27"+
		"\2\2\u00dd\u00de\78\2\2\u00de\31\3\2\2\2\u00df\u00e0\7\31\2\2\u00e0\u00e1"+
		"\7\66\2\2\u00e1\u00e2\78\2\2\u00e2\33\3\2\2\2\u00e3\u00e4\7\32\2\2\u00e4"+
		"\u00e5\7\66\2\2\u00e5\u00e6\7\33\2\2\u00e6\u00e7\78\2\2\u00e7\35\3\2\2"+
		"\2\u00e8\u00e9\7\34\2\2\u00e9\u00ea\7\66\2\2\u00ea\u00eb\78\2\2\u00eb"+
		"\37\3\2\2\2\u00ec\u00ed\7\35\2\2\u00ed\u00f0\7\67\2\2\u00ee\u00f1\5$\23"+
		"\2\u00ef\u00f1\7\67\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f5\5$\23\2\u00f3\u00f5\7\67\2\2\u00f4\u00f2\3"+
		"\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u0117\3\2\2\2\u00f6\u00f7\7\36\2\2\u00f7"+
		"\u00fa\7\67\2\2\u00f8\u00fb\5$\23\2\u00f9\u00fb\7\67\2\2\u00fa\u00f8\3"+
		"\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0117\5\f\7\2\u00fd"+
		"\u00fe\7\37\2\2\u00fe\u0101\7\67\2\2\u00ff\u0102\5$\23\2\u0100\u0102\7"+
		"\67\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\5\f\7\2\u0104\u0105\5\f\7\2\u0105\u0117\3\2\2\2\u0106\u0107\7 "+
		"\2\2\u0107\u010a\7\67\2\2\u0108\u010b\5$\23\2\u0109\u010b\7\67\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0117\5\f"+
		"\7\2\u010d\u010e\7!\2\2\u010e\u0111\7\67\2\2\u010f\u0112\5$\23\2\u0110"+
		"\u0112\7\67\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0113\3"+
		"\2\2\2\u0113\u0114\5\f\7\2\u0114\u0115\5\f\7\2\u0115\u0117\3\2\2\2\u0116"+
		"\u00ec\3\2\2\2\u0116\u00f6\3\2\2\2\u0116\u00fd\3\2\2\2\u0116\u0106\3\2"+
		"\2\2\u0116\u010d\3\2\2\2\u0117!\3\2\2\2\u0118\u0119\7\"\2\2\u0119\u0121"+
		"\5&\24\2\u011a\u011b\7#\2\2\u011b\u0121\7\66\2\2\u011c\u011d\7$\2\2\u011d"+
		"\u0121\t\4\2\2\u011e\u011f\7\'\2\2\u011f\u0121\t\4\2\2\u0120\u0118\3\2"+
		"\2\2\u0120\u011a\3\2\2\2\u0120\u011c\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"#\3\2\2\2\u0122\u0123\7\r\2\2\u0123\u0124\5\f\7\2\u0124\u0125\7(\2\2\u0125"+
		"\u0126\5\f\7\2\u0126\u0127\7\16\2\2\u0127%\3\2\2\2\u0128\u0139\7\65\2"+
		"\2\u0129\u012a\7\66\2\2\u012a\u012b\7(\2\2\u012b\u012c\7\66\2\2\u012c"+
		"\u012d\7(\2\2\u012d\u012f\7\66\2\2\u012e\u0130\5(\25\2\u012f\u012e\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0139\3\2\2\2\u0131\u0136\t\5\2\2\u0132"+
		"\u0134\7\66\2\2\u0133\u0135\7\f\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3"+
		"\2\2\2\u0135\u0137\3\2\2\2\u0136\u0132\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0139\3\2\2\2\u0138\u0128\3\2\2\2\u0138\u0129\3\2\2\2\u0138\u0131\3\2"+
		"\2\2\u0139\'\3\2\2\2\u013a\u013b\7(\2\2\u013b\u013c\7\66\2\2\u013c)\3"+
		"\2\2\2\"-\65?DN_jrt|\u009a\u00a2\u00ac\u00b5\u00ba\u00bc\u00c7\u00d3\u00d7"+
		"\u00d9\u00f0\u00f4\u00fa\u0101\u010a\u0111\u0116\u0120\u012f\u0134\u0136"+
		"\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}