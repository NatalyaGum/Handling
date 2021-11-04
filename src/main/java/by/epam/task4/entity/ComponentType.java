package by.epam.task4.entity;

public enum ComponentType {
    TEXT("\n\t"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(" "),
    WORD(""),
    SYMBOL("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
