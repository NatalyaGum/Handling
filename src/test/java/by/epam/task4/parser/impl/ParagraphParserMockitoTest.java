package by.epam.task4.parser.impl;

import by.epam.task4.entity.TextComposite;
import by.epam.task4.exception.HandlingException;
import by.epam.task4.reader.impl.TextReaderImpl;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class ParagraphParserMockitoTest {

    private TextReaderImpl readerMock;
    private ParagraphParser parser;
    private TextComposite actual;
    private String expected;
    private String text;


    @Test//(enabled = false)
    public void testParse() throws HandlingException {
        MockitoAnnotations.initMocks(this);
        parser = new ParagraphParser();
        readerMock = spy(new TextReaderImpl());//java.lang.ExceptionInInitializerError
        text = "Первый параграф. Первое предложение. Второе предложение.\n" +
                "Второй параграф. Первое предложение второго параграфа.";
        doReturn(text)
                .when(readerMock)
                .readText(any());
        actual = parser.parse(readerMock.readText(any()));
        expected = "PARAGRAPH, SENTENCE, LEXEME, WORD, SYMBOL, ПSYMBOL, еSYMBOL, рSYMBOL, вSYMBOL, ыSYMBOL, й LEXEME, WORD, SYMBOL, пSYMBOL, аSYMBOL, рSYMBOL, аSYMBOL, гSYMBOL, рSYMBOL, аSYMBOL, ф LEXEME, SYMBOL, . SENTENCE, LEXEME, WORD, SYMBOL, ПSYMBOL, еSYMBOL, рSYMBOL, вSYMBOL, оSYMBOL, е LEXEME, WORD, SYMBOL, пSYMBOL, рSYMBOL, еSYMBOL, дSYMBOL, лSYMBOL, оSYMBOL, жSYMBOL, еSYMBOL, нSYMBOL, иSYMBOL, е LEXEME, SYMBOL, . SENTENCE, LEXEME, WORD, SYMBOL, ВSYMBOL, тSYMBOL, оSYMBOL, рSYMBOL, оSYMBOL, е LEXEME, WORD, SYMBOL, пSYMBOL, рSYMBOL, еSYMBOL, дSYMBOL, лSYMBOL, оSYMBOL, жSYMBOL, еSYMBOL, нSYMBOL, иSYMBOL, е LEXEME, SYMBOL, . \n" +
                "PARAGRAPH, SENTENCE, LEXEME, WORD, SYMBOL, ВSYMBOL, тSYMBOL, оSYMBOL, рSYMBOL, оSYMBOL, й LEXEME, WORD, SYMBOL, пSYMBOL, аSYMBOL, рSYMBOL, аSYMBOL, гSYMBOL, рSYMBOL, аSYMBOL, ф LEXEME, SYMBOL, . SENTENCE, LEXEME, WORD, SYMBOL, ПSYMBOL, еSYMBOL, рSYMBOL, вSYMBOL, оSYMBOL, е LEXEME, WORD, SYMBOL, пSYMBOL, рSYMBOL, еSYMBOL, дSYMBOL, лSYMBOL, оSYMBOL, жSYMBOL, еSYMBOL, нSYMBOL, иSYMBOL, е LEXEME, WORD, SYMBOL, вSYMBOL, тSYMBOL, оSYMBOL, рSYMBOL, оSYMBOL, гSYMBOL, о LEXEME, WORD, SYMBOL, пSYMBOL, аSYMBOL, рSYMBOL, аSYMBOL, гSYMBOL, рSYMBOL, аSYMBOL, фSYMBOL, а LEXEME, SYMBOL, . \n";
        assertEquals(expected, actual.toString());
    }
}
