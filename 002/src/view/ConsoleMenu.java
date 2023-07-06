package view;

import commands.*;
import commands.interfaces.Command;

import java.util.ArrayList;

public class ConsoleMenu {
    private Console view;
    private ArrayList<Command> commandList;

    public ConsoleMenu (Console view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddToy(view));
        commandList.add(new EditToy(view));
        commandList.add(new DeleteToy(view));
        commandList.add(new ShowAllToys(view));
        commandList.add(new RunLottery(view));
        commandList.add(new ShowHistory(view));
        commandList.add(new Finish(view));
    }

    public String printMain () {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            result.append(i+1).append(". ").append(commandList.get(i).getDescription()).append("\n");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public ArrayList<Command> getCommandList() {
        return commandList;
    }

    public void executeCommand (int numberCommand) {
        commandList.get(numberCommand -1 ).execute();
    }
}
