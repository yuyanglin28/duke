public class TodoCommand extends Command {

    String content;

    public TodoCommand(String content){

       this.content = content;

    }
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.add(new Todo(content));
        ui.showAdd(tasks);
    }
}
