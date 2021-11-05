package by.epam.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components=new ArrayList<>();
    private ComponentType componentType;

    public TextComposite() {

    }
    public TextComposite(ComponentType componentType) {
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

    /*@Override
    public String toString() {
        return "TextComposite{" +
                "components=" + components + "\n"+
                ", componentType=" + componentType +
                '}';
    }*/
  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = componentType.getDelimiter();
        for (TextComponent textComponent : components) {
            sb.append(componentType+", ").append(textComponent.toString()).append(delimiter).append("\n");
        }
        return sb.toString();
    }
}
