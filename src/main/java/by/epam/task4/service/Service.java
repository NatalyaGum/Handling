package by.epam.task4.service;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.exception.HandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Service {
    private static Logger logger = LogManager.getLogger();


    public List<TextComponent> sortParagraphs(TextComposite composite) throws HandlingException {
        if (composite == null) {
            logger.error("Composite is null");
            throw new HandlingException("Composite is null");
        } else if (!composite.getType().equals(ComponentType.PARAGRAPH)) {
            logger.error("Can't sort " + composite);
            throw new HandlingException("Can't sort " + composite);
        }
        List<TextComponent> sortedParagraphs = composite.getList();
        sortedParagraphs.sort(new Comparator<TextComponent>() {

            public int compare(TextComponent o1, TextComponent o2) {
                return o1.size() - o2.size();
            }
        });
        logger.info("Sorted paragraphs: " + sortedParagraphs);
        return sortedParagraphs;
    }

    //@Override
    public List<TextComponent> findSentencesWithLongWord(TextComposite composite)throws HandlingException {

    /*if (composite == null) {
            logger.error("Composite is null");
            throw new HandlingException("Composite is null");
        } else if (!composite.getType().equals(ComponentType.PARAGRAPH)) {
            logger.error("Can't found sentences in " + composite);
            throw new HandlingException("Can't found sentences in " + composite);
        }*/
        int maxLength = 0;
        List<TextComponent> sentencesWithWord = new ArrayList<>();
        List<TextComponent> paragraphs = composite.getList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsAndSymbols = lexeme.getList();
                    for (TextComponent word : wordsAndSymbols) {
                        if (word.size() > maxLength) {
                            maxLength = word.size();
                            sentencesWithWord.clear();
                            sentencesWithWord.add(sentence);
                            }/* else if (word.size() == maxLength && !sentencesWithWord.contains(sentence)) {
                                sentencesWithWord.add(sentence);*/
                              //  logger.info(" maxLength: " + maxLength);
                            }
                        }
                    }
                }
        logger.info("Sentences with the longest word: " + sentencesWithWord);
        return sentencesWithWord;
    }

    //@Override
    public void deleteSentencesWithLessWords(TextComposite composite, int wordsAmount)  {

      /*  return   composite.getList().stream()
                    .flatMap(p -> p.getList().stream())
                    .toList().stream()
                    .filter(s -> s.getList().stream()
                            .filter(l -> l.getType().equals(ComponentType.WORD)).count() >= minAmount).toList();}
*/

        List<TextComponent> sentencesAfterRemoving = new ArrayList<>();
        List<TextComponent> sentences=null;
        int count=0;
        List<TextComponent> paragraphs = composite.getList();
        for (TextComponent paragraph : paragraphs) {
             sentences = paragraph.getList();
            sentencesAfterRemoving.addAll(sentences);
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getList();
                for (TextComponent lexeme : lexemes) {
                    if (lexeme.getType().equals(ComponentType.WORD)) {
                        ++count;}
                }if (count<wordsAmount) {sentencesAfterRemoving.remove(sentence);
                    logger.info("Sentence was removed " + ": " + sentence);}
                count=0;

            }
            paragraph.setComponents(sentencesAfterRemoving);
            sentencesAfterRemoving.removeAll(sentences);
        }
        logger.info("Text without sentence with  words less than " + wordsAmount + ": " +composite);

    }

   // @Override
    public List<String> countRepeatWords(TextComposite composite)  {
        Map<String, Integer> textWords = new HashMap<>();
        List<TextComponent> paragraphs = composite.getList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getList();
                for (TextComponent lexeme : lexemes) {
                    if (lexeme.getType().equals(ComponentType.WORD))
                    {List<TextComponent> words = lexeme.getList();
                    for (TextComponent word : words) {
                            int counter = 1;
                            String wordWithoutCase = word.toString().toLowerCase();
                            if (textWords.containsKey(wordWithoutCase)) {
                                counter = textWords.get(wordWithoutCase) + 1;
                            }
                            textWords.put(wordWithoutCase, counter);
                        }
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> word : textWords.entrySet()) {
            if (word.getValue() > 1) {
                result.add(word.getKey());
            }
        }
        for (String word:result) {
            logger.info( "Words that repeat in text: " + word+"/n");}

        return result;
    }

    //@Override
    public int countVowels(TextComponent sentence) throws HandlingException {
        final String VOWEL_REGEX = "[aeiouyаеёиоуыэюя]";
        Pattern pattern = Pattern.compile(VOWEL_REGEX);
        Matcher matcher;

        int counter = 0;
        List<TextComponent> lexemes = sentence.getList();
        for (TextComponent lexeme : lexemes) {
            if (lexeme.getType().equals(ComponentType.WORD)){
            List<TextComponent> words = lexeme.getList();
            for (TextComponent word : words) {
                List<TextComponent> symbols = word.getList();
                for (TextComponent symbol : symbols) {
                    matcher = pattern.matcher(symbol.toString().toLowerCase());
                    if (matcher.matches()) {
                        counter++;
                        }
                    }
                }
            }
        }
        logger.info("Number of vowels in sentence " + sentence + ": " + counter);
        return counter;
    }

    //@Override
    public int countConsonants(TextComponent sentence) throws HandlingException {
        final String CONSONANT_REGEX = "[bcdfghjklmnpqrstvwxzбвгджзйклмнпрстфхцчшщ]";
        Pattern pattern = Pattern.compile(CONSONANT_REGEX);
        Matcher matcher;

        int counter = 0;
        List<TextComponent> lexemes = sentence.getList();
        for (TextComponent lexeme : lexemes) {
            if (lexeme.getType().equals(ComponentType.WORD)){
            List<TextComponent> words = lexeme.getList();
            for (TextComponent word : words) {
                List<TextComponent> symbols = word.getList();
                for (TextComponent symbol : symbols) {
                    matcher = pattern.matcher(symbol.toString().toLowerCase());
                    if (matcher.matches()) {
                        counter++;
                        }
                    }
                }
            }
        }
        logger.info("Number of consonants in sentence " + sentence + ": " + counter);
        return counter;
    }


}


