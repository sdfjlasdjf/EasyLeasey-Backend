package com.EL.mapper;

import com.EL.entity.Furniture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FurnitureMapper {

    @Insert("INSERT INTO furniture (id, user_id, title, description, price, condition, create_time, update_time, location) " +
            "VALUES (#{id}, #{userId}, #{title}, #{description}, #{price}, #{condition}, #{createTime}, #{updateTime}, #{location})")
    void insert(Furniture furniture);

    @Select("SELECT * FROM furniture WHERE location = #{location} AND (user_id = #{userId} OR #{userId} IS NULL)")
    List<Furniture> getFurniture(@Param("location") String location, @Param("name") String name);

    @Delete("DELETE FROM furniture WHERE id = #{id}")
    void delete(Long id);
}
