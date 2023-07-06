package commands;

import commands.interfaces.Command;
import view.interfaces.View;

public class DeleteToy implements Command {
    private View view;

    public DeleteToy (View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Удалить игрушку";
    }

    @Override
    public void execute() {
        view.deleteToy();
    }
}
