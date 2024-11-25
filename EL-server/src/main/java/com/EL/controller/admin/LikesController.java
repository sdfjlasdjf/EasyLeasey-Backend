package com.EL.controller.admin;

import com.EL.dto.LikesDTO;
import com.EL.entity.Likes;
import com.EL.result.Result;
import com.EL.service.LikesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/likes")
public class LikesController {
    @Autowired
    private LikesService likeservice;

    @ApiOperation("Toggle Likes")
    @PutMapping("/togglelike")
    public Result toggleLike(LikesDTO likesDTO){
        likeservice.toggleLike(likesDTO);
        return Result.success();
    }

    @ApiOperation("Check if the post is liked by the user")
    @GetMapping("/isliked")
    public Result<Boolean> isLiked(Long postId){
        boolean result = likeservice.isLiked(postId);
        return Result.success(result);
    }


}
