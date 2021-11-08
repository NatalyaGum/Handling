package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextParser {
   static Logger logger = LogManager.getLogger();

    private final String MATH_REGEX = "([-+/*|%$&~><^.)(\\d]+){2,}";//"^([-+/*|]\d+(\.\d+)?)*";
    private final String LEXEME_REGEX = "\\s";
    private final String WORD_DELIMITER_REGEX = "[А-я\\p{Alpha}]+";
    final String PRE_PUNCTUATION_REGEX = "^\\p{Punct}(?!\\d)";
    final String POST_PUNCTUATION_REGEX =   "(?<!\\d)\\p{Punct}$";
    private final TextParser wordParser = new WordParser();
    private final TextParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String data) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] lexemes = data.split(LEXEME_REGEX);

        for (String lexeme : lexemes) {

            Pattern pattern = Pattern.compile(MATH_REGEX);
            Matcher matcher = pattern.matcher(lexeme);
            List<String> math = new ArrayList<>();
            while (matcher.find()) {
                math.add(matcher.group());
            }
            if (!math.isEmpty()){
            for (String symbol : math) {
                TextComposite punctuationComposite = symbolParser.parse(symbol);
                lexemeComposite.add(punctuationComposite);
             }}

           pattern = Pattern.compile(PRE_PUNCTUATION_REGEX);
            matcher = pattern.matcher(lexeme);
            List<String> punctuation = new ArrayList<>();
            while (matcher.find()) {
                punctuation.add(matcher.group());
            }
            for (String symbol : punctuation) {
                TextComposite punctuationComposite = symbolParser.parse(symbol);
                //logger.info("preComposite"+punctuationComposite);
                lexemeComposite.add(punctuationComposite);
            }

            pattern = Pattern.compile(WORD_DELIMITER_REGEX);
            matcher = pattern.matcher(lexeme);
            if (matcher.find()){
            TextComposite nextComposite = wordParser.parse(matcher.group());
            lexemeComposite.add(nextComposite);
           // logger.info("wordParser"+nextComposite);
                }


            pattern = Pattern.compile(POST_PUNCTUATION_REGEX);
            matcher = pattern.matcher(lexeme);
            punctuation = new ArrayList<>();

            if (lexeme.length()>1){
            while (matcher.find()) {
                punctuation.add(matcher.group());
            }
            for (String symbol : punctuation) {

                TextComposite punctuationComposite = symbolParser.parse(symbol);
                lexemeComposite.add(punctuationComposite);
               // logger.info("postComposite"+punctuationComposite);
            }}

        }return lexemeComposite;
    }

}




