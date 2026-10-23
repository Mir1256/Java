package tasker;

public class ColorAttribute extends Attribute {

    public ColorAttribute(String value) {
        super("color", value);
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
