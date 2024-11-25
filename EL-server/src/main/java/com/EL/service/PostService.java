package com.EL.service;

import com.EL.dto.GetPostDTO;
import com.EL.dto.PostDTO;
import com.EL.dto.PostPageQueryDTO;
import com.EL.entity.Post;
import com.EL.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    /**
     * Add post
     * @param postDTO
     */
    void save(PostDTO postDTO);

    /**
     * Query Page
     * @return
     */
    PageResult pageQuery(PostPageQueryDTO postPageQueryDTO);

    /**
     * Show Posts
     * @param getPostDTO
     */
    List<Post> getPosts(GetPostDTO getPostDTO);

    List<Post> getUserPosts(Long userId);

    List<Post> getLikedPosts(Long userId);

    Post getPostDetail(Long postid);

    void update(PostDTO postDTO);
}
