package by.epam.task4.service.impl;

import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.impl.ParagraphParser;
import by.epam.task4.parser.impl.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CompositeServiceTest {


    TextComposite parseText(String text) {
        ParagraphParser paragraphParser = new ParagraphParser();
        TextComposite composite = paragraphParser.parse(text);
        return composite;
    }

    @Test
    public void testSortParagraphs() {
        List<TextComponent> expectedSortedParagraphs = parseText(
                "Второй параграф. Первое предложение второго параграфа.\n" +
                        "Первый параграф. Первое предложение. Второе предложение.\n" +
                        "Третий параграф. Первое предложение третьего параграфа. Второе предложение третьего параграфа. Третье предложение третьего параграфа.").getList();
        TextComposite composite = parseText("Первый параграф. Первое предложение. Второе предложение.\n" +
                "Второй параграф. Первое предложение второго параграфа.\n" +
                "Третий параграф. Первое предложение третьего параграфа. Второе предложение третьего параграфа. Третье предложение третьего параграфа.");
        CompositeService service = new CompositeService();
        List<TextComponent> actualSortedParagraphs = service.sortParagraphs(composite);
        Assert.assertEquals(actualSortedParagraphs.toString(), expectedSortedParagraphs.toString());

    }

    @Test
    public void testFindSentencesWithLongWord() {
        TextComposite composite = parseText("Первый параграф. Первое предложение. Второе предложение.\n" +
                "Второй параграф. Первое предложение второго параграфа.\n" +
                "Третий параграф. Первое предложение третьего параграфа. Второе предложение третьего параграфа. Третье предложение третьего параграфа.");
        CompositeService service = new CompositeService();
        List<TextComponent> actualSentences = service.findSentencesWithLongWord(composite);
        SentenceParser sentenceParser = new SentenceParser();
        TextComposite expectedComposite = sentenceParser.parse("Первое предложение.");
        List<TextComponent> expectedSentences = expectedComposite.getList();
        Assert.assertEquals(expectedSentences.toString(), actualSentences.toString());


    }

    @Test
    public void testDeleteSentencesWithLessWords() {
        TextComposite actualcomposite = parseText("Первый параграф. Первое предложение. Второе и последнее предложение.\n" +
                "Второй параграф. Первое предложение второго параграфа.");
        CompositeService service = new CompositeService();
        service.deleteSentencesWithLessWords(actualcomposite, 3);
        TextComposite expectedcomposite = parseText("Второе и последнее предложение.\n" +
                "Первое предложение второго параграфа.");
        Assert.assertEquals(actualcomposite.toString(), expectedcomposite.toString());


    }

    @Test
    public void testCountRepeatWords() {
        TextComposite composite = parseText("Первый параграф. Первое предложение. Второе предложение.");
        CompositeService service = new CompositeService();
        List<String> actualWords = service.countRepeatWords(composite);
        List<String> expectedWords = new ArrayList<>();
        expectedWords.add(" symbol- п symbol- р symbol- е symbol- д symbol- л symbol- о symbol- ж symbol- е symbol- н symbol- и symbol- е");
        Assert.assertEquals(actualWords, expectedWords);

    }

    @Test //(enabled = false)
    public void testCountVowels() {
        TextComposite composite = parseText("Первый параграф. Первое предложение. Второе предложение.");
        CompositeService service = new CompositeService();
        List<TextComponent> paragraphs = composite.getList();
        List<TextComponent> sentences = paragraphs.get(0).getList();
        int actualCount = service.countVowels(sentences.get(0));
        int expectedCount = 5;
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Test
    public void testCountConsonants() {
        TextComposite composite = parseText("Первый параграф. Первое предложение. Второе предложение.");
        CompositeService service = new CompositeService();
        List<TextComponent> paragraphs = composite.getList();
        List<TextComponent> sentences = paragraphs.get(0).getList();
        int actualCount = service.countConsonants(sentences.get(0));
        int expectedCount = 9;
        Assert.assertEquals(actualCount, expectedCount);
    }
}