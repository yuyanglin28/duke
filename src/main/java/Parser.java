public class Parser {


    public static Command parse(String command) throws DukeException {

        String[] commands = command.split("\\s");

        if (commands[0].equals("list")) {
            return new ListCommand();
        }

        else if (commands[0].equals("bye")) {
            return new ExitCommand();
        }

        else if (commands[0].equals("done")) {
            if (commands.length > 1){
                int index = Integer.parseInt(commands[1]);
                return new DoneCommand(index);
            }else{
                throw new DukeException("The index of this command can't be empty");
            }

        }

        else if (commands[0].equals("todo")) {
            String content = "";
            if (commands.length > 1){
                for (int i=1; i<commands.length - 1; i++){
                    content = content + commands[i] + " ";
                }
                content += commands[commands.length -1 ];
            }else{
                throw new DukeException("The description of todo command cannot be empty.");
            }
            return new TodoCommand(content);
        }
        else if (commands[0].equals("deadline")) {
            String content = "";
            String time = "";

            if (commands[1] != null) {
                int i = 1;
                while (commands.length > i+1 && (! commands[i + 1].equals("/by"))){
                    content = content + commands[i] + " ";
                    i += 1;
                }
                content += commands[i];
                if (commands.length > i+2){
                    for (int j = i+2; j<commands.length-1; j++)
                        time = time + commands[j] + " ";
                }
                time += commands[commands.length - 1];
            }
            if (content == ""){
                throw new DukeException("The description of deadline command cannot be empty.");
            }
            else if (time == ""){
                throw new DukeException("The deadline of this command cannot be empty.");
            }else{
                return new DeadlineCommand(content, time);
            }
        }

        else if (commands[0].equals("event")) {
            String content = "";
            String time = "";

            if (commands[1] != null) {
                int i = 1;
                while (commands.length > i+1 && (! commands[i + 1].equals("/at"))){
                    content = content + commands[i] + " ";
                    i += 1;
                }
                content += commands[i];
                if (commands.length > i+2){
                    for (int j = i+2; j<commands.length-1; j++)
                        time = time + commands[j] + " ";
                }
                time += commands[commands.length - 1];
            }

            if (content == ""){
                throw new DukeException("The description of event command cannot be empty.");
            }
            else if (time == ""){
                throw new DukeException("The time of this command cannot be empty.");
            }else{
                return new EventCommand(content, time);
            }

        }

        else if (commands[0].equals("delete")){
            if (commands.length > 1){
                int index = Integer.parseInt(commands[1]);
                return new DeleteCommand(index);
            }else{
                throw new DukeException("The index of this command can't be empty");
            }
        }
        else if (commands[0].equals("find")){
            String key;
            if (commands.length == 2){
                key = commands[1];
            }else{
                throw new DukeException("The number of key of this command should be one");
            }
            return new FindCommand(key);
        }

        else {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
