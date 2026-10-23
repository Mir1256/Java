package tasker;

import javax.naming.Name;

public class Human {
    private Names selfName;
    private int height;
    private Human father;

    public Human(String selfName, int height){
        this(new Names(selfName),height , null);
    }
    public Human(String selfName){
        this(new Names(selfName),0 , null);
    }

    public Human(Names selfName){
        this(selfName,0 , null);
    }

    public Human(String selfName, String fatherName){
        this(new Names(selfName),0, new Names(fatherName));
    }

    public Human(Names selfName,int height, Names fatherName){
        this.selfName = selfName;
        this.father = (fatherName == null) ? null : new Human(fatherName);
        this.height = height;
    }

    public Human getFather(){
        return this.father;
    }
    public String getSelfName(){
        return getSelfName();
    }
    public String getSelfSecondName(){
        return getSelfSecondName();
    }
    public String getLastName(){
        if (this.selfName.getLastName().isBlank() && this.father == null){
            return "";
//            this.selfName.setLastName("");
        } else if (this.selfName.getLastName().isBlank()) {
            Human nowFather = this.father;
            while(nowFather != null && nowFather.selfName.getLastName().isBlank()) {
                if (!nowFather.selfName.getLastName().isBlank()){
                    break;
                }
                nowFather = nowFather.father;
            }
            this.selfName = new Names(nowFather.selfName.getLastName(), this.selfName.getName(), this.selfName.getSecondName());
        }
        return this.selfName.getLastName();
    }

    public String toString(){
        getLastName();

        if(this.selfName.getSecondName().isBlank() && (this.father == null || this.father.selfName.getName().isBlank())){
            this.selfName = new Names(this.selfName.getLastName(), this.selfName.getName(), "");
        } else if (this.selfName.getSecondName().isBlank()) {
            this.selfName = new Names(this.selfName.getLastName(), this.selfName.getName(), this.father.selfName.getName() + "ович");
        }

        return "Человек с именем " + "\"" + selfName + "\"";
    }
}
