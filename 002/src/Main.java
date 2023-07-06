import model.Service;
import model.Shop;
import model.Toy;
import model.interfaces.ItemShop;
import presenter.Presenter;
import view.Console;
import view.interfaces.View;

public class Main {
    public static void main(String[] args) {
        Shop<ItemShop> myShop = new Shop<>();
        Service<ItemShop> service = new Service<>(myShop);
        View view = new Console();
        Presenter presenter = new Presenter(view, service);

        view.setPresenter(presenter);
        presenter.generateMinimalToys();

        view.start();
        view.finish();
    }
}