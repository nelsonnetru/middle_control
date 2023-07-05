package commands;

import view.View;

public class RunLottery implements Command{
    private View view;

    public RunLottery (View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Начать розыгрыш";
    }

    @Override
    public void execute() {
        view.doLottery();
    }
}
