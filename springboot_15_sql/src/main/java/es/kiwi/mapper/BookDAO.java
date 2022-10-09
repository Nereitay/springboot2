package es.kiwi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import es.kiwi.model.Book;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BookDAO extends BaseMapper<Book> {


}
