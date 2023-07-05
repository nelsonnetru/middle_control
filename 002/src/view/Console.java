package view;

import presenter.Presenter;

import java.util.HashMap;
import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scan;
    private ConsoleMenu consoleMenu;
    boolean work;
    String errorTextInt = "Ошибка! Необходимо ввести номер!";
    String errorOutOfBoundCommandInt = "Ошибка! Невозможно выполнить команду!";

    public Console () {
        this.consoleMenu = new ConsoleMenu(this);
        this.scan = new Scanner(System.in);
        this.work = true;
    }


    @Override
    public void start() {
        while (work) {
            print(consoleMenu.printMain());
            inputCommand();
        }
    }

    public void addToy() {
        print("Введите наименование игрушки:");
        String newToyName = scan.nextLine();
        print("Введите количество игрушек:");
        String newToyCount = scan.nextLine();
        int netToyCountInt = 0;
        if (checkTextForInt(newToyCount))
            netToyCountInt = Integer.parseInt(newToyCount);

        print("Введите частоту выпадания игрушки от 0 до 100:");
        String newToyFrequency = scan.nextLine();
        int newToyFrequencyInt = 0;
        if (checkTextForInt(newToyCount))
            newToyFrequencyInt = Integer.parseInt(newToyFrequency);

        presenter.addToyToShop(newToyName, netToyCountInt, newToyFrequencyInt);
    }

    public void doLottery() {
        if (presenter.totalToysUnits() == 0) {
            print("В магазине нет игрушек. Невозможно провести розыгрыш!");
            return;
        }

        print("Доступно игрушек: " + presenter.totalToysUnits());
        print("Сколько игрушек разыграть:");
        String iterationStr = scan.nextLine();
        int iterationsInt = 0;
        if (checkTextForInt(iterationStr))
            iterationsInt = Integer.parseInt(iterationStr);

        int x = 0;
        while (x < iterationsInt && presenter.totalToysUnits() > 0) {
            Integer idToy = presenter.makePrize(); // произвести розыгрыш игрушки
            if (idToy > 0) {
                print ((x + 1) + ": Выпала игрушка: " + presenter.getNameToyByID(idToy));
                x++;
            }
        }
        print("");
    }

    public void showAllToys() {
        print (presenter.showAllToys());
    }

    public void editToyinfo() {
        print("Введите ID игрушки для редактирования: ");
        String toyIdStr = scan.nextLine();
        int toyId = 0;
        if (checkTextForInt(toyIdStr))
            toyId = Integer.parseInt(toyIdStr);

        if (toyId == 0) {
            print("Ошибка! Игрушка с таким ID не найдена!");
            return;
        }

        HashMap<String, String> toyItem = presenter.getToyMapById(toyId);

        print("Введите новое имя игрушки (оставьте пустым чтобы оставить \"" + toyItem.get("name") + "\"): ");
        String newName = scan.nextLine();
        if (newName == "") newName = toyItem.get("name");

        print("Введите новое количество (оставьте пустым чтобы сохранить \"" + toyItem.get("count") + "\"): ");
        String newCountStr = scan.nextLine();
        int newCount;
        if (newCountStr == "" || !checkTextForInt(newCountStr)) newCount = Integer.parseInt(toyItem.get("count"));
        else newCount = Integer.parseInt(newCountStr);

        print("Введите новое имя игрушки (оставьте пустым чтобы сохранить \"" + toyItem.get("frequency") + "\"): ");
        String newFreqStr = scan.nextLine();
        int newFrequency;
        if (newFreqStr == "" || !checkTextForInt(newFreqStr)) newFrequency = Integer.parseInt(toyItem.get("frequency"));
        else newFrequency = Integer.parseInt(newFreqStr);

        presenter.updateToy(toyId, newName, newCount, newFrequency);
        print("Данный обновлены");
    }

    public void deleteToy() {
        print("Введите ID игрушки для удаления: ");
        String toyIdStr = scan.nextLine();
        int toyId = 0;
        if (checkTextForInt(toyIdStr))
            toyId = Integer.parseInt(toyIdStr);

        if (toyId == 0) {
            print("Ошибка! Игрушка с таким ID не найдена!");
            return;
        }

        presenter.deleteToy(toyId);
        print("Игрушка удалена.");
    }

    public void showHistory () {
        if (presenter.getHistoryPrize().size() > 0)
            print ("История розыгрышей: " + presenter.getHistoryPrize().toString());
        else
            print ("Нет разыгранных игрушек");
    }

    private void inputCommand() {
        String commandStr = scan.nextLine();
        if (checkTextForInt(commandStr)) {
            int commandNumber = Integer.parseInt(commandStr);
            if (checkCommand(commandNumber)) {
                consoleMenu.executeCommand(commandNumber);
            }
            else print(errorOutOfBoundCommandInt);
        }
        else print(errorTextInt);
    }

    private boolean checkTextForInt(String text){
        return (text.matches("[0-9]+"));
    }

    private boolean checkCommand(int numCommand){
        return (numCommand < consoleMenu.getCommandList().size() + 1);
    }

    @Override
    public void finish() {
        this.work = false;
        this.scan.close();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
