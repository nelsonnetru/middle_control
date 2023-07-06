package commands;

import commands.interfaces.Command;
import view.interfaces.View;

public class EditToy implements Command {
    private View view;

    public EditToy (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Редактировать игрушку";
    }

    @Override
    public void execute() {
        view.editToyinfo();
    }
}
