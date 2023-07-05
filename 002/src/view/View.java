package view;

import presenter.Presenter;

public interface View {
    void start();
    void finish();
    void print(String text);
    void doLottery();
    void addToy();
    void showHistory();
    void showAllToys();
    void editToyinfo();

    void deleteToy();
    void setPresenter(Presenter presenter);
}
