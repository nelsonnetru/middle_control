package commands;

import view.View;

public class Finish implements Command{
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
