import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 03/11/2020
 * Time: 10:08 SA
 */

public class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;
    private String url;

    public FileDownloaderProxy(String url) {
        this.url = url;
        System.out.println("File unloaded: " + this.url);
    }

    @Override
    public void download() throws IOException {
        if (fileDownloader == null) {
            fileDownloader = new FileDownloader("FireFox", this.url);
        } else {
            System.out.println("File đã được tải về: " + this.url);
        }
        fileDownloader.download();
    }
}
