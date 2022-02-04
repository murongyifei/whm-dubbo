package space.whm.demo.consumer.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {

    /**
     * 数据中心的日期格式化字符串
     */
    public final static String DATA_CENTER_TIME_FORMAT = "yyyyMMddHHmm";

    public static String default_sheme = "http://";

    public static ThreadLocal<RequestRecorder> currentRequest = new ThreadLocal<RequestRecorder>();

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    public static String getCurrentRequestId() {
        if (CommonUtil.currentRequest.get() == null) {
        	String requestId = generateUUID();
        	RequestRecorder recorder = new RequestRecorder();
        	recorder.setRequestId(requestId);
        	CommonUtil.currentRequest.set(recorder);
        	return requestId;
        }
        return CommonUtil.currentRequest.get().getRequestId();
    }

    public static String getExceptionStack(Throwable e) {
        StringBuilder builder = new StringBuilder();
        builder.append(e.toString() + "\n");
        for (StackTraceElement elem : e.getStackTrace()) {
            builder.append("\t" + elem + "\n");
        }
        return builder.toString();

    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer = new StringBuffer();
        buffer.append(stringWriter.getBuffer());
        return buffer.toString();
    }

    public static boolean validUrl(String url) {
        url = url.replace("*", "-");
        Pattern p = Pattern.compile("^(http|https):\\/\\/([\\w-]+(\\.[\\w-]+)+(:[0-9]{1,5})?(\\/[\\w-.\\/\\?%()&+=\u4e00-\u9fa5]*)?)?$");

        Matcher match = p.matcher(url);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static String addSheme(String urlString) {
        if (!urlString.startsWith("http://") && !urlString.startsWith("https://"))
            urlString = CommonUtil.default_sheme + urlString;
        return urlString;
    }

}
