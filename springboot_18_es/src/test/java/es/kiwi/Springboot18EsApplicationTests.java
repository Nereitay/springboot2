package es.kiwi;

import com.alibaba.fastjson.JSON;
import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.ObjectMapper;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.List;


@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    /*@Autowired
    private ElasticsearchRestTemplate template;*/

    @Autowired
    private RestHighLevelClient restClient;

    @Test
    void contextLoads() {
        System.out.println(bookDAO.selectById(1));
    }

   /* @AfterEach
    void tearDown() throws IOException {
        restClient.close();
    }*/

    @Test
    void testCreateClient() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        restClient.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");

        String json = "{\n" +
                "    \"mappings\": {\n" +
                "        \"properties\": {\n" +
                "            \"id\": {\n" +
                "                \"type\": \"keyword\"\n" +
                "            },\n" +
                "            \"name\" : {\n" +
                "                \"type\" : \"text\",\n" +
                "                \"copy_to\": \"all\"\n" +
                "            },\n" +
                "            \"description\" : {\n" +
                "                \"type\" : \"text\",\n" +
                "                \"copy_to\": \"all\"\n" +
                "            },\n" +
                "            \"type\" : {\n" +
                "                \"type\" : \"keyword\"\n" +
                "            },\n" +
                "            \"all\" : {\n" +
                "                \"type\" : \"text\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        request.source(json, XContentType.JSON);
        restClient.indices().create(request, RequestOptions.DEFAULT);

    }

    /**
     * 添加文档
     */
    @Test
    void testCreateDoc() throws IOException {
        Book book = bookDAO.selectById(2);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        restClient.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void testBulk() throws IOException {
        List<Book> bookList =  bookDAO.selectList(null);
        BulkRequest bulk = new BulkRequest();

        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulk.add(request);
        }

        restClient.bulk(bulk, RequestOptions.DEFAULT);
    }

    @Test
    void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = restClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
    }

    /**
     * 按条件查询
     */
    @Test
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("name", "java"));
        request.source(builder);

        SearchResponse response = restClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        hits.forEach(h -> {
            String source = h.getSourceAsString();
//            System.out.println(source);
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        });
    }

}
