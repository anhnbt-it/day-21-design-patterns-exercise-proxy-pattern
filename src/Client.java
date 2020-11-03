import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 03/11/2020
 * Time: 10:12 SA
 */

public class Client {
    public static void main(String[] args) {
        String url = "https://anhnbt.com/images/logo-anhnbt.png";
        System.out.println("Init proxy");
        FileDownloaderProxy fileDownloaderProxy = new FileDownloaderProxy(url);

        try {
            System.out.println("---");
            System.out.println("Call real service 1st: ");
            fileDownloaderProxy.download();

            System.out.println("---");
            System.out.println("Call real service 2nd: ");
            fileDownloaderProxy.download();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
