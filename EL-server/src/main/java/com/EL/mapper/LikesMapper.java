package com.EL.mapper;

import com.EL.entity.Likes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LikesMapper {
    @Select("select * from likes where user_id = #{userId} and post_id = #{postId}")
    Likes getLike(Long userId, Long postId);

    @Insert("insert into likes (user_id, post_id, update_time) values (#{userId}, #{postId}, now())")
    void addLike(Long userId, Long postId);

    @Delete("delete from likes where user_id = #{userId} and post_id = #{postId}")
    void deleteLike(Long userId, Long postId);


}
