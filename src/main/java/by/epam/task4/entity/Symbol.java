package by.epam.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Symbol implements TextComponent{
    static Logger logger = LogManager.getLogger();

    private ComponentType symbol;
    private char character;

    public Symbol (char character){
        this.character=character;
    };

    @Override
    public void add(TextComponent component) {


    }

    @Override
    public void remove(TextComponent component) {

    }
}
