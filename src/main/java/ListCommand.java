public class ListCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage){

        ui.showList();
        for (int j = 0; j < tasks.getSize(); j++) {
            System.out.println(j + 1 + "." + tasks.get(j));
        }

    }

}
