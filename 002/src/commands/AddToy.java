package commands;

import view.View;

public class AddToy implements Command{
    private View view;

    public AddToy (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить игрушку";
    }

    @Override
    public void execute() {
        view.addToy();
    }
}
