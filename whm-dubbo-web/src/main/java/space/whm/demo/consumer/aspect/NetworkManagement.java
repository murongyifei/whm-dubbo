package space.whm.demo.consumer.aspect;

import java.awt.*;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://blog.csdn.net/qq378741744/article/details/8940934
 * @Description:本类开启一个线程检测网络是否连通
 */
public class NetworkManagement implements Runnable {
    private int htmlCodeSize;
    private int sleepMillisecond;
    private int sleepMillisecondWhenNetWorkUnLinked;
    private boolean isSpontaneousNotice;
    private static final AtomicBoolean networkIsLinked = new AtomicBoolean(false);
    private Thread thread = new Thread(this);
    private String[] urls;

    public NetworkManagement() {
        this.urls = new String[]{"http://www.baidu.com"};
        this.htmlCodeSize = 50;
        this.sleepMillisecond = 5000;
        this.sleepMillisecondWhenNetWorkUnLinked = 10000;
        thread.start();
    }

    public void setURLs(String[] urls) {
        if (urls != null && urls.length > 0) {
            this.urls = urls;
        }
    }

    public void setHtmlCodeSize(int htmlCodeSize) {
        if (htmlCodeSize > 0) {
            this.htmlCodeSize = htmlCodeSize;
        }
    }

    public void isSpontaneousNotice(boolean isSpontaneousNotice) {
        this.isSpontaneousNotice = isSpontaneousNotice;
    }

    public void setSleepMillisecont(int sleepMillisecont) {
        if (sleepMillisecont > 100) {
            this.sleepMillisecond = sleepMillisecont;
        }
    }

    public void setSleepMillisecondWhenNetWorkUnLinked(int sleepMillisecont) {
        if (sleepMillisecont > 100) {
            this.sleepMillisecondWhenNetWorkUnLinked = sleepMillisecont;
        }
    }

    @Override
    public void run() {
        while (!NetworkManagement.networkIsLinked.get()) {
            try {
                this.isNetWorkLinked();
                if (!NetworkManagement.networkIsLinked.get()) {
                    this.isPrintMessage(this.isSpontaneousNotice);
                    Thread.sleep(this.sleepMillisecondWhenNetWorkUnLinked);
                }
//                System.out.println(this.networkIsLinked.get());
//                Thread.sleep(this.sleepMillisecond);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
        }
    }

    private boolean canGetHtmlCode(String httpUrl) {
        String htmlCode = "";
        try {
            InputStream in;
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0");
            connection.connect();
            in = connection.getInputStream();
            byte[] buffer = new byte[this.htmlCodeSize];
            in.read(buffer);
            htmlCode = new String(buffer);
        } catch (Exception e) {
        }
        if (htmlCode == null || htmlCode.equals("")) {
            return false;
        } else {
            System.out.println(htmlCode);
        }
        return true;
    }

    private void isNetWorkLinked() {
        boolean tempIsNetWorkLinked = false;
        for (int urlsCount = 0; urlsCount < this.urls.length; urlsCount++) {
            if (this.canGetHtmlCode(this.urls[urlsCount])) {
                tempIsNetWorkLinked = true;
                break;
            }
        }
        NetworkManagement.networkIsLinked.set(tempIsNetWorkLinked);
    }

    private void isPrintMessage(boolean isPrint) {
        if (isPrint) {
            StringBuffer message = new StringBuffer();
            message.append("------------->");
            message.append("网络中断, ");
            message.append(this.sleepMillisecondWhenNetWorkUnLinked);
            message.append(" 毫秒后再次检测!<-------------");
            System.out.println(message.toString());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        NetworkManagement n = new NetworkManagement();
        n.isSpontaneousNotice(true);
        System.out.println("start:" + NetworkManagement.networkIsLinked.get());
        System.out.println("sleep 7000ms");
        Thread.sleep(7000);
        System.out.println("end:" + NetworkManagement.networkIsLinked.get());
    }
}
