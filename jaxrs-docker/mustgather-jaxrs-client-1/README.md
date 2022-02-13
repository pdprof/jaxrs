# MustGather Hands-On JAXRS case 

## Start jaxrs container on docker or openshift

Follow steps described at parent folder's README 

## Access to the servlet to test jms operation send/receiveAll

Access to following URL by your browser

- http://localhost:9080/jaxrs.client/

![jaxrs.client](jaxrs.client.png)


### Connect timeout hands-on

Please set connet timeout value in millisecond and set IP Address which can not be reached.
And click submit button.

You can test connect timeout with this. Here's sample exception output.

```
[err] java.net.SocketTimeoutException: connect timed out
[err]   at java.base/java.net.PlainSocketImpl.socketConnect(Native Method)
[err]   at java.base/java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:399)
[err]   at java.base/java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:242)
[err]   at java.base/java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:224)
[err]   at java.base/java.net.Socket.connect(Socket.java:609)
[err]   at java.base/sun.net.NetworkClient.doConnect(NetworkClient.java:177)
[err]   at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:474)
[err]   at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:569)
[err]   at java.base/sun.net.www.http.HttpClient.<init>(HttpClient.java:242)
[err]   at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:341)
[err]   at java.base/sun.net.www.http.HttpClient.New(HttpClient.java:362)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(HttpURLConnection.java:1253)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1232)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1081)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.connect(HttpURLConnection.java:1015)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.getOutputStream0(HttpURLConnection.java:1367)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.getOutputStream(HttpURLConnection.java:1342)
[err]   at org.apache.cxf.transport.http.URLConnectionHTTPConduit$URLConnectionWrappedOutputStream.setupWrappedStream(URLConnectionHTTPConduit.java:315)
```


### Receive timeout hands-on

Please set receive timeout value lower than sleep time value. Sleep time is backend JAX-RS provider work time.

```
[err] java.net.SocketTimeoutException: Read timed out
[err]   at java.base/java.net.SocketInputStream.socketRead(SocketInputStream.java:115)
[err]   at java.base/java.net.SocketInputStream.read(SocketInputStream.java:168)
[err]   at java.base/java.net.SocketInputStream.read(SocketInputStream.java:140)
[err]   at java.base/java.io.BufferedInputStream.fill(BufferedInputStream.java:252)
[err]   at java.base/java.io.BufferedInputStream.read1(BufferedInputStream.java:292)
[err]   at java.base/java.io.BufferedInputStream.read(BufferedInputStream.java:351)
[err]   at java.base/sun.net.www.http.HttpClient.parseHTTPHeader(HttpClient.java:754)
[err]   at java.base/sun.net.www.http.HttpClient.parseHTTPHeader(HttpClient.java:892)
[err]   at java.base/sun.net.www.http.HttpClient.parseHTTP(HttpClient.java:689)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1615)
[err]   at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)
[err]   at java.base/java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:527)
[err]   at org.apache.cxf.transport.http.URLConnectionHTTPConduit$URLConnectionWrappedOutputStream$2.run(URLConnectionHTTPConduit.java:421)
```


