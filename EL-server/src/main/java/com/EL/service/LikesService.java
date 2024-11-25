package com.EL.service;

import com.EL.dto.LikesDTO;
import com.EL.entity.Likes;

import java.util.List;

public interface LikesService {
    void toggleLike(LikesDTO likesDTO);

    boolean isLiked(Long postId);

}
