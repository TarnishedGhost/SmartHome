package remote;

import commands.Command;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    private final List<Command> commandQueue = new ArrayList<>();

    // Додати команду до черги
    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    // Виконати всі команди
    public void executeAll() {
        System.out.println("\n🚀 Виконання команд:");
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}
