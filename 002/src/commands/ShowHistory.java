package commands;

import view.View;

public class ShowHistory implements Command{
    private View view;

    public ShowHistory (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать историю розыгрыша";
    }

    @Override
    public void execute() {
        view.showHistory();
    }
}
