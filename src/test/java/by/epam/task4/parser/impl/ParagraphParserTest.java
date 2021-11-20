package by.epam.task4.parser.impl;

import by.epam.task4.entity.TextComposite;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {


    @Test//(enabled = false)
    public void testParser() {
        String expected = " PARAGRAPH [ SENTENCE [ LEXEME [ WORD [ SYMBOL [П] SYMBOL [е] SYMBOL [р] SYMBOL [в] SYMBOL [ы] SYMBOL [й]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [а] SYMBOL [р] SYMBOL [а] SYMBOL [г] SYMBOL [р] SYMBOL [а] SYMBOL [ф]]]  LEXEME [ SYMBOL [.]] ] SENTENCE [ LEXEME [ WORD [ SYMBOL [П] SYMBOL [е] SYMBOL [р] SYMBOL [в] SYMBOL [о] SYMBOL [е]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [р] SYMBOL [е] SYMBOL [д] SYMBOL [л] SYMBOL [о] SYMBOL [ж] SYMBOL [е] SYMBOL [н] SYMBOL [и] SYMBOL [е]]]  LEXEME [ SYMBOL [.]] ] SENTENCE [ LEXEME [ WORD [ SYMBOL [В] SYMBOL [т] SYMBOL [о] SYMBOL [р] SYMBOL [о] SYMBOL [е]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [р] SYMBOL [е] SYMBOL [д] SYMBOL [л] SYMBOL [о] SYMBOL [ж] SYMBOL [е] SYMBOL [н] SYMBOL [и] SYMBOL [е]]]  LEXEME [ SYMBOL [.]] ]]\n" +
                " PARAGRAPH [ SENTENCE [ LEXEME [ WORD [ SYMBOL [В] SYMBOL [т] SYMBOL [о] SYMBOL [р] SYMBOL [о] SYMBOL [й]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [а] SYMBOL [р] SYMBOL [а] SYMBOL [г] SYMBOL [р] SYMBOL [а] SYMBOL [ф]]]  LEXEME [ SYMBOL [.]] ] SENTENCE [ LEXEME [ WORD [ SYMBOL [П] SYMBOL [е] SYMBOL [р] SYMBOL [в] SYMBOL [о] SYMBOL [е]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [р] SYMBOL [е] SYMBOL [д] SYMBOL [л] SYMBOL [о] SYMBOL [ж] SYMBOL [е] SYMBOL [н] SYMBOL [и] SYMBOL [е]]]  LEXEME [ WORD [ SYMBOL [в] SYMBOL [т] SYMBOL [о] SYMBOL [р] SYMBOL [о] SYMBOL [г] SYMBOL [о]]]  LEXEME [ WORD [ SYMBOL [п] SYMBOL [а] SYMBOL [р] SYMBOL [а] SYMBOL [г] SYMBOL [р] SYMBOL [а] SYMBOL [ф] SYMBOL [а]]]  LEXEME [ SYMBOL [.]] ]]\n";
        String text = "Первый параграф. Первое предложение. Второе предложение.\n" +
                "Второй параграф. Первое предложение второго параграфа.";
        ParagraphParser paragraphParser = new ParagraphParser();
        TextComposite actualComposite = paragraphParser.parse(text);
        assertEquals(actualComposite.toString(), expected);
    }
}
