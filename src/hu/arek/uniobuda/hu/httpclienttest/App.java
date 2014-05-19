package hu.arek.uniobuda.hu.httpclienttest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class App {

    private static final String URL = "http://freecode.hu/hunveyor/message.php?msg=message";
    private static ObjectMapper mapper;
    private static Data d;

    public static void main(final String[] args) throws ClientProtocolException, IOException {
        for (int i = 0; i < 10; i++) {
            final long start = System.nanoTime();

            d = new Data("foo", 100, 1000.21, true);
            mapper = new ObjectMapper();

            final CloseableHttpClient httpclient = HttpClients.createDefault();
            final HttpPost httpPost = new HttpPost(URL);
            final List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("code", mapper.writeValueAsString(d)));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            final CloseableHttpResponse response2 = httpclient.execute(httpPost);
            try {
                System.out.println(response2.getStatusLine());
                final HttpEntity entity2 = response2.getEntity();
                EntityUtils.consume(entity2);
            } finally {
                response2.close();
            }
            final long end = System.nanoTime();
            System.out.println(end - start);
        }

    }
}
