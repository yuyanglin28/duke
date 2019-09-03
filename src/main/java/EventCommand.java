public class EventCommand extends Command {
    String content;
    String time;

    public EventCommand(String content, String time){

        this.content = content;
        this.time = time;

    }
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.add(new Event(content, time));
        ui.showAdd(tasks);
    }
}
