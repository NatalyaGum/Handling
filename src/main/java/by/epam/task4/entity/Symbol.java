package by.epam.task4.entity;

import by.epam.task4.exception.HandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent{
    static Logger logger = LogManager.getLogger();

    private ComponentType symbol;
    private char character;

    public Symbol (char character){
        this.character=character;
    };

    @Override
    public void add(TextComponent component)  {
        logger.info("Unsupported operation add symbol");
        throw new UnsupportedOperationException("Unsupported operation add symbol");
    }

    @Override
    public void remove(TextComponent component)  {
        logger.info("Unsupported operation remove symbol");
        throw new UnsupportedOperationException ("Unsupported operation remove symbol");
    }
    @Override
    public List<TextComponent> getList() {
        logger.warn("Hasn't got list");
        throw new UnsupportedOperationException("Unsupported operation remove symbol");
    }
    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
        }
    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(character)
				.toString();
}

    @Override
    public void setComponents(List<TextComponent> components) {
        throw new UnsupportedOperationException();
    }
}
