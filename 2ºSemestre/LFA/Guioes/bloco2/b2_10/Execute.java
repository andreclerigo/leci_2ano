public class Execute extends QuestionBaseVisitor<String> {

    @Override public String visitFile(QuestionParser.FileContext ctx) {
        return visitChildren(ctx);
    }

    @Override public String visitQuestions(QuestionParser.QuestionsContext ctx) {
        return visitChildren(ctx);
    }

    @Override public String visitHead(QuestionParser.HeadContext ctx) {
        return visitChildren(ctx);
    }

    @Override public String visitAnswer(QuestionParser.AnswerContext ctx) {
        return visitChildren(ctx);
    }
}
