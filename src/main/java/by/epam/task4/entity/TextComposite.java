package by.epam.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components=new ArrayList<>();
    private ComponentType componentType;

    TextComposite (ComponentType componentType) {
        this.componentType = componentType;

    }
    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }
}
