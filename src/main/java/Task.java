public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


    public void changeStatusIcon(){
        if (this.isDone == false){
            this.isDone = true;
        }
    }

    public String getDescription(){
        return this.description;
    }

    public int getStatus(){
        if (isDone) return 1;
    else return 0;}

    public String toString(){
        return "["+getStatusIcon()+"] "+ getDescription();
    }



}

