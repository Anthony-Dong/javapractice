package com.net;

import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * http工具类
 *
 * @author kingston
 */
public class HttpUtil {

    /**
     * 拼接字符串的  例如 a,1,b,2 结果就是 a=1&b=2
     *
     * @param params
     * @return
     */
    public static String buildUrlParam(Object... params) {
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("参数个数必须为偶数");
        }
        StringBuffer result = new StringBuffer("");
        try {
            for (int i = 0; i < params.length; i += 2) {
                if (result.length() > 0) {
                    result.append("&");
                }
                result.append(params[i]);
                String value = URLEncoder.encode(params[i + 1].toString(), "UTF-8");
                result.append("=" + value);
            }
        } catch (Exception e) {
        }
        return result.toString();
    }

    /**
     * 发送请求的
     *
     * @param urlAddr
     * @param method
     * @return
     * @throws IOException
     */
    public static String doServer(String urlAddr, String method) throws IOException {
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urlAddr);
            uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setRequestMethod("GET");
            uc.setConnectTimeout(5000);
            uc.setReadTimeout(5000);
            uc.connect();

            StringBuffer result = new StringBuffer("");
            if (uc.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()))) {
                    while (reader.ready()) {
                        result.append(reader.readLine());

                    }
                }
            }
            return result.toString();
        } catch (IOException e1) {
            throw e1;
        } catch (Exception e) {
            throw new IOException(e);
        } finally {
            if (null != uc && null != uc.getInputStream()) {
                uc.getInputStream().close();
            }
        }
    }


    public static String doGet(String path) throws IOException {
        return doServer(path, "GET");
    }


    public static String doPost(String path) throws IOException {
        return doServer(path, "POST");
    }


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        IntStream.range(0, 2000).forEach(e -> {
            executorService.execute(() -> {
                String s = null;
                try {
                    s = doGet("http://localhost:8087");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                System.out.println("s = " + s + ":  " + e);
            });
        });
        long memory = Runtime.getRuntime().totalMemory() / 1000 / 1000;
        System.out.println(memory);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
