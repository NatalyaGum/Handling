package by.epam.task4.entity;

import by.epam.task4.exception.HandlingException;

import javax.management.openmbean.CompositeType;
import java.util.List;

public interface TextComponent {

    void add (TextComponent component) ;
    void remove (TextComponent component) ;
    List<TextComponent> getList() ;
    int size();
    ComponentType getType();
    String toString();

    void setComponents(List<TextComponent> components);
}
