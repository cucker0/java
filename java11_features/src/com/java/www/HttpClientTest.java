package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * HttpClient接口
 *
 *
 *
 */
public class HttpClientTest {
    /**
     * 同步请求
     *
     */
    @Test
    public void test1() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
            HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, bodyHandler); // 同步请求方法
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步请求
     *
     */
    @Test
    public void test2() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, bodyHandler); // 异步请求
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
    }
}
