package ru.lobankov.geometry.attribute;

import java.util.ArrayList;
import java.util.List;

public class AttributePoint {
    private int x;
    private int y;
    private List<Attribute> attributes;

    public AttributePoint(int x, int y, Attribute... attributes) {
        this.x = x;
        this.y = y;
        this.attributes = new ArrayList<>();
        if(attributes==null){
            return;
        }
        for (Attribute a:attributes){
            putAttribute(a);
        }
    }

    public AttributePoint(AttributePoint original) {
        this.x = original.x;
        this.y = original.y;
        this.attributes = new ArrayList<>(original.attributes);
    }

    public void putAttribute(Attribute attribute) {
        if (attribute==null) return;
        for (int i = 0; i < attributes.size(); i++) {
            if (attribute.getName().equals(attributes.get(i).getName())){
                this.attributes.set(i,attribute);
                return;
            }
        }
        this.attributes.add(attribute);
    }

    public <T extends Attribute> T getAttribute(Class<T> type){
        for (Attribute attribute : attributes) {
            if (attribute.getClass() == type) {
                return (T) attribute;
            }
        }
        return null;
    }

    public List<Attribute> getAttributes() {
        return new ArrayList<>(attributes);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "AttributePoint{" +
                "x=" + x +
                ", y=" + y +
                ", attributes=" + attributes +
                '}';
    }
}
