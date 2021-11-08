package by.epam.task4.main;

import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.exception.HandlingException;
import by.epam.task4.parser.impl.ParagraphParser;
import by.epam.task4.reader.impl.TextReaderImpl;
import by.epam.task4.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws HandlingException {

        TextReaderImpl reader = new TextReaderImpl();
        String text = reader.readText("src/main/resources/text.txt");


    ParagraphParser paragraphParser = new ParagraphParser();
  /*  SentenceParser sentenceParser = new SentenceParser();
    LexemeParser lexemeParser = new LexemeParser();
    WordParser wordParser = new WordParser();
    SymbolParser symbolParser = new SymbolParser();*/
    /* paragraphParser.setNextParser(sentenceParser);
     sentenceParser.setNextParser(lexemeParser);
     lexemeParser.setNextParser(wordParser);
     wordParser.setNextParser(symbolParser);*/
    TextComposite composite = paragraphParser.parse(text);

       // logger.info(composite);

        Service service=new Service();
        //service.sortParagraphs(composite);
        //service.findSentencesWithLongWord(composite);
       // service.deleteSentencesWithLessWords(composite,3);
      // logger.info(composite);
       //service.countRepeatWords(composite);

        List<TextComponent> paragraphs = composite.getList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getList();
            for (TextComponent sentence : sentences) {
        service.countVowels(sentence);

                service.countConsonants(sentence);}
}}}

