package es.kiwi;

import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot15SqlApplicationJDBCTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testJdbcTemplate() {
        String sql = "select * from tb1_book where id = 1";
        /*List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);*/

        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book temp = new Book();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setType(resultSet.getString("type"));
                temp.setDescription(resultSet.getString("description"));
                return temp;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        System.out.println(list);
    }

    @Test
    void testJdbcTemplateSave() {
        String sql = "insert into tb1_book values (3, 'springboot1', 'springboot2', 'springboot3')";
        jdbcTemplate.update(sql);

    }

}
