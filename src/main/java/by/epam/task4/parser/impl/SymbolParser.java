package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.LetterAndSymbol;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.TextParser;

public class SymbolParser implements TextParser {

    @Override
    public TextComposite parse(String text) {
        TextComposite symbolComposite = new TextComposite(ComponentType.SYMBOL);
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            LetterAndSymbol leaf = new LetterAndSymbol(symbol);
            symbolComposite.add(leaf);
        }
        return symbolComposite;
    }
}
