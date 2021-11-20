package by.epam.task4.main;

import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.exception.HandlingException;
import by.epam.task4.parser.impl.ParagraphParser;
import by.epam.task4.reader.impl.TextReaderImpl;
import by.epam.task4.service.impl.CompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws HandlingException {

        TextReaderImpl reader = new TextReaderImpl();
        String text = reader.readText("src/main/resources/text.txt");
        ParagraphParser paragraphParser = new ParagraphParser();
        TextComposite composite = paragraphParser.parse(text);
        CompositeService service = new CompositeService();
        //service.sortParagraphs(composite);
        // service.findSentencesWithLongWord(composite);
        //service.deleteSentencesWithLessWords(composite,3);

         logger.info("text: "+composite);
        //  service.countRepeatWords(composite);

      /*  List<TextComponent> paragraphs = composite.getChild();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChild();
            for (TextComponent sentence : sentences) {
                service.countVowels(sentence);
                service.countConsonants(sentence);
            }
        }*/
    }}