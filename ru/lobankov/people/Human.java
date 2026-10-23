package ru.lobankov.people;

public class Human {
    private Name selfName;
    private final Human father;

    public Human(String selfName){
        this(selfName, null);
    }

    public Human(Name selfName){
        this(selfName, null);
    }

    public Human(String selfName, Human father){
        this(new Name(selfName), father);
    }

    public Human(Name selfName, Human father) {
        this.selfName = selfName;
        this.father = father;
    }

    public Human getFather(){
        return this.father;
    }

    public String getSelfName(){
        return this.selfName.getName();
    }

    public String getSelfSecondName(){
        return this.selfName.getSecondName();
    }

    public Name getSelfFullName(){
        return selfName;
    }

    public String getLastName(){
        if (this.selfName.getLastName().isBlank() && this.father == null){
            return "";
        } else if (this.selfName.getLastName().isBlank()) {
            Human nowFather = this.father;
            while(nowFather != null && nowFather.selfName.getLastName().isBlank()) {
                if (nowFather.father == null) {
                    return "";
                }
                nowFather = nowFather.father;
            }
            this.selfName = new Name(this.selfName.getName(), nowFather.selfName.getLastName(), this.selfName.getSecondName());
        }
        return this.selfName.getLastName();
    }

    public String toString(){
        getLastName();

        if(this.selfName.getSecondName().isBlank() && (this.father == null || this.father.selfName.getName().isBlank())){
            this.selfName = new Name(this.selfName.getName(), this.selfName.getLastName(), "");
        } else if (this.selfName.getSecondName().isBlank()) {
            this.selfName = new Name(this.selfName.getName(), this.selfName.getLastName(), this.father.selfName.getName() + "ович");
        }

        return "Человек с именем " + "\"" + selfName + "\"";
    }
}
