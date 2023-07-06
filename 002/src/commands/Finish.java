package commands;

import commands.interfaces.Command;
import view.interfaces.View;

public class Finish implements Command {
    private View view;

    public Finish (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Выход";
    }

    @Override
    public void execute() {
        view.finish();
    }
}
