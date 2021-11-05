package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.Symbol;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements TextParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public TextComposite parse(String text) {
        TextComposite symbolComposite = new TextComposite(ComponentType.SYMBOL);
        char[] symbols = text.toCharArray();
        logger.info(text);
        for (char symbol : symbols) {
            Symbol leaf = new Symbol(symbol);
            symbolComposite.add(leaf);
           logger.info(leaf);
        }
        return symbolComposite;
    }
}
