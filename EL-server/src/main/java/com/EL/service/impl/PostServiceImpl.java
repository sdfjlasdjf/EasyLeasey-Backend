package com.EL.service.impl;

import com.EL.constant.StatusConstant;
import com.EL.context.BaseContext;
import com.EL.dto.GetPostDTO;
import com.EL.dto.PostDTO;
import com.EL.dto.PostPageQueryDTO;
import com.EL.entity.Post;
import com.EL.mapper.PostMapper;
import com.EL.result.PageResult;
import com.EL.service.PostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void save(PostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        post.setStatus(StatusConstant.ENABLE);
        post.setCreateTime(LocalDateTime.now());
        post.setUpdateTime(LocalDateTime.now());

        //Get id from Threadlocal
        post.setUserId(BaseContext.getCurrentId());
        postMapper.insert(post);
    }

    /**
     * query page
     * @param postPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PostPageQueryDTO postPageQueryDTO){
        PageHelper.startPage(postPageQueryDTO.getPage(),postPageQueryDTO.getPageSize());
        Page<Post> page = postMapper.pageQuery(postPageQueryDTO);
        long total = page.getTotal();
        List<Post> records = page.getResult();
        return new PageResult(total,records);
    }

    @Override
    public List<Post> getPosts(GetPostDTO getPostDTO) {
        String location = getPostDTO.getLocation();
        String category = getPostDTO.getCategory();
        return postMapper.getPosts(location, category);
    }


    @Override
    public List<Post> getLikedPosts(Long userId) {
        return postMapper.getLikedPosts(userId);
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        return postMapper.getUserPostsByUserId(userId);
    }

    @Override
    public Post getPostDetail(Long postId) { return postMapper.getPostByPostId(postId); }

    @Override
    public void update(PostDTO postDTO){
        String location = postDTO.getLocation();
        Long id = postDTO.getId();
        String title = postDTO.getTitle();
        String content = postDTO.getContent();
        String image = postDTO.getImage();
        Integer price =postDTO.getPrice();


        postMapper.update(id,location,title,content,image,price);
    }

}
