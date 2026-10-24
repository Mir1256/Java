package ru.lobankov.people;

public class Name {
    private final String lastName;
    private final String name;
    private final String secondName;

    public Name(String name, String lastName, String secondName){
        if (isBlank(name) && isBlank(lastName) && isBlank(secondName)) {
            throw new IllegalArgumentException("One element must be valid");
        }
        else {
            this.lastName = validConverter(lastName);
            this.name =  validConverter(name);
            this.secondName = validConverter(secondName);
        }
    }

    public Name(String name, String lastName){
        this(name, lastName, null);
    }

    public Name(String name) {
        this(name, null,null);
    }

    private boolean isBlank(String s){
        return s == null || s.isBlank();
    }

    private String validConverter(String s){
        if (isBlank(s)) {
            return "";
        }
        return s;
    }


    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString(){
        String res = "";
        if (!lastName.isEmpty()) {
            res += lastName + " ";
        }
        if (!name.isEmpty()) {
            res += name + " ";
        }
        if (!secondName.isEmpty()) {
            res += secondName;
        }
        return res.trim();
    }
}
