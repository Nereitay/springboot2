package es.kiwi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {



    @Test
    void testRandomPort() {

    }

    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        // http://localhost:8080/books
        /*创建虚拟请求，当前访问 /books*/
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行对应请求
        mvc.perform(builder);

        /*ResultActions resultActions = mvc.perform(builder);
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());*/
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books1");
        ResultActions actions = mvc.perform(builder);

        /*设定预期值与真实值进行比较，成功测试通过，失败调试失败*/
        //定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用时成功的状态：200
        ResultMatcher ok = status.isOk();

        actions.andExpect(ok);

    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/5");
        ResultActions actions = mvc.perform(builder);

        /*设定预期值与真实值进行比较，成功测试通过，失败调试失败*/
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "  \"id\": 1,\n" +
                "  \"type\": \"springboot\",\n" +
                "  \"name\": \"springboot\",\n" +
                "  \"description\": \"springboot\"\n" +
                "}");
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(result);

    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        /*设定预期值与真实值进行比较，成功测试通过，失败调试失败*/
        //定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        //添加预期值到本次调用过程中进行匹配
        actions.andExpect(contentType);

    }

    /**
     *
     * 基本上齐了，头信息，正文信息，状态信息都有了，就可以组合出一个完美的响应结果比对结果了。
     * 以下范例就是三种信息同时进行匹配校验，也是一个完整的信息匹配过程。
     * @param mvc
     * @throws Exception
     */
    @Test
    void testGetById(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/5");
        ResultActions actions = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        actions.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        actions.andExpect(contentType);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "  \"id\": 5,\n" +
                "  \"type\": \"springboot\",\n" +
                "  \"name\": \"springboot\",\n" +
                "  \"description\": \"springboot\"\n" +
                "}");
        actions.andExpect(result);

    }
}
