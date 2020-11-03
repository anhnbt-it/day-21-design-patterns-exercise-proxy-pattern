import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 03/11/2020
 * Time: 10:07 SA
 */

public class FileDownloader implements Downloader {
    private String userAgent;
    private String url;

    public FileDownloader() {
    }

    public FileDownloader(String userAgent, String url) {
        this.userAgent = userAgent;
        this.url = url;
        System.out.println("Đang tải tệp... " + this.url + ", Trình duyệt: " + this.userAgent);
    }

    @Override
    public void download() throws IOException {
        String folder = "C:\\Users\\KhoaiTay\\OneDrive\\Documents\\codegym-apj\\module-2-java\\week-5\\day-21-design-patterns-exercise-proxy-pattern\\";
        String fileName = this.url.substring(this.url.lastIndexOf('/')+1);
        File file = new File(folder + fileName);
        if (!file.exists()) {
            // Create a url object
            URL url = new URL(this.url);
            // Connection to the file
            URLConnection urlConnection = url.openConnection();
            // Get output stream to download file
            InputStream inputStream = urlConnection.getInputStream();
            OutputStream outputStream = new FileOutputStream(folder + fileName);
            final byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("Tệp đã tải xuống: " + folder + fileName);
        } else {
            System.out.println("Tập tin đã tồn tại");
        }
    }
}
