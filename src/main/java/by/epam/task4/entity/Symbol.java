package by.epam.task4.entity;

import by.epam.task4.exception.HandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements TextComponent{
    static Logger logger = LogManager.getLogger();

    private ComponentType symbol;
    private char character;

    public Symbol (char character){
        this.character=character;
    };

    @Override
    public void add(TextComponent component) throws HandlingException {
        logger.info("Unsupported operation add symbol");
        throw new HandlingException("Unsupported operation add symbol");
    }

    @Override
    public void remove(TextComponent component) throws HandlingException {
        logger.info("Unsupported operation remove symbol");
        throw new HandlingException("Unsupported operation remove symbol");
    }
}
