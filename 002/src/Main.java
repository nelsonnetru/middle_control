import model.Service;
import model.Shop;
import model.Toy;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) {
        Shop<Toy> myShop = new Shop<>();
        Service service = new Service(myShop);
        View view = new Console();
        Presenter presenter = new Presenter(view, service);

        view.setPresenter(presenter);
        presenter.generateMinimalToys();

        view.start();
        view.finish();
    }
}