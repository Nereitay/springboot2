package es.kiwi.mapper;

import es.kiwi.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 3.数据库SQL映射需要添加@Mapper被容器识别到
 */
@Mapper
public interface BookDAO {

    @Select("select * from tb1_book where id = #{id}")
    Book getById(Integer id);
}
