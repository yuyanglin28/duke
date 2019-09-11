public class DeadlineCommand extends Command {
    String content;
    String time;

    public DeadlineCommand(String content, String time){

        this.content = content;
        this.time = time;

    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.add(new Deadline(content, time));
        ui.showAdd(tasks);
    }
}
