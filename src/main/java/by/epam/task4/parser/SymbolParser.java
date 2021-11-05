package by.epam.task4.parser;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.Symbol;
import by.epam.task4.entity.TextComposite;

public class SymbolParser implements TextParser{

    @Override
    public TextComposite parse(String text) {
        TextComposite symbolComposite = new TextComposite(ComponentType.SYMBOL);
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            Symbol leaf = new Symbol(symbol);
            symbolComposite.add(leaf);
        }
        return symbolComposite;
    }
}
