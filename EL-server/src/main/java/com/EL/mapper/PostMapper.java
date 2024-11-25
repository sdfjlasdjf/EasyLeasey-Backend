package com.EL.mapper;

import com.EL.dto.PostPageQueryDTO;
import com.EL.entity.Post;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PostMapper {
    /**
     * add new post
     * @param post
     */
    @Insert("insert into post (id, user_id, title, content, create_time, update_time, status, location, category)"+
            "values"
            +"(#{id},#{userId},#{title},#{content},#{createTime},#{updateTime},#{status},#{location},#{category})")
    void insert(Post post);

    /**
     * Query records in a page
     * @param postPageQueryDTO
     * @return
     */
    Page<Post> pageQuery(PostPageQueryDTO postPageQueryDTO);

    @Select("SELECT * FROM post WHERE location = #{location} AND category = #{category}")
    List<Post> getPosts(String location, String category);


    @Select("SELECT * FROM post WHERE id IN (SELECT post_id FROM likes WHERE user_id = #{userId})")
    List<Post> getLikedPosts(Long userId);

    @Select("SELECT * FROM post WHERE user_id = #{userId}")
    List<Post> getUserPostsByUserId(Long userId);

    @Select("SELECT * FROM post WHERE id = #{postId}")
    Post getPostByPostId(Long postId);

    @Update("""
        UPDATE post
        SET 
            location = #{location},
            title = #{title},
            content = #{content},
            image = #{image},
            price = #{price},
            update_time = NOW()
        WHERE id = #{id}
    """)
    void update(Long id, String location, String title, String content, String image, Integer price);
}
