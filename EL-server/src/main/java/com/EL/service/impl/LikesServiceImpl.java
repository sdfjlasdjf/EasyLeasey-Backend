package com.EL.service.impl;

import com.EL.context.BaseContext;
import com.EL.dto.LikesDTO;
import com.EL.entity.Likes;
import com.EL.mapper.LikesMapper;
import com.EL.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesMapper likesMapper;

    @Override
    public void toggleLike(LikesDTO likesDTO) {
        Long postId = likesDTO.getPostId();
        Boolean isLiked = likesDTO.getIsLiked();
        Long userId = BaseContext.getCurrentId();
        if(!isLiked){
            likesMapper.addLike(userId,postId);
        }else{
            likesMapper.deleteLike(userId,postId);
        }

    }

    @Override
    public boolean isLiked(Long postId){
        Long userId = BaseContext.getCurrentId();
        return likesMapper.getLike(userId, postId) != null;
    }


}
