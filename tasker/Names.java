package Java.tasker;

public class Names {
    private  String lastName;
    private String name;
    private String secondName;

    public Names(String lastName, String name, String secondName){
        if (lastName != null || name != null || secondName != null) {
            this.lastName = lastName == null ? "" : lastName;
            this.name = name == null ? "" : name;
            this.secondName = secondName == null ? "" : secondName;
        }
        else {
            throw new IllegalArgumentException("One element must be not null");
        }
    }

    public Names(String lastName, String name){
        this(lastName, name, null);
    }


    public String getLastName() {
        return lastName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName == null ? "" : lastName;
//    }
//    public void setSecondName(String secondName) {
//        this.secondName = secondName == null ? "" : secondName;;
//    }
//    public void setName(String name) {
//        this.name = name == null ? "" : name;;
//    }

    public String getName() {
        return name;
    }


    public String getSecondName() {
        return secondName;
    }

    public Names(String string){

        String[] words = string.split("\\s+");

        if (words.length == 1) {
            this.lastName = "";
            this.name = words[0];
            this.secondName = "";
        } else if (words.length == 2) {
            this.lastName = words[0];
            this.name = words[1];
            this.secondName = "";
        } else if (words.length == 3) {
            this.lastName = words[0];
            this.name = words[1];
            this.secondName = words[2];
        }
    }
    public String toString(){
        return (lastName.isBlank() ? "" : (lastName + " ") ) +
                (secondName.isBlank() ? name  : (name + " ") ) +
                secondName;
    }
}
