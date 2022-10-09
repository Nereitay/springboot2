package es.kiwi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.print.Book;


@Mapper
public interface BookDAO {

    @Select("select * from tb1_book where id = #{id}")
    Book getById(Integer id);
}
