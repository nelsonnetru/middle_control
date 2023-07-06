package commands;

import commands.interfaces.Command;
import view.interfaces.View;

public class ShowAllToys implements Command {
    private View view;

    public ShowAllToys (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать все игрушки магазина";
    }

    @Override
    public void execute() {
        view.showAllToys();
    }
}
