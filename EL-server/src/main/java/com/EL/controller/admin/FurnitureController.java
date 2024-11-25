package com.EL.controller.admin;

import com.EL.dto.GetFurnitureDTO;
import com.EL.dto.FurnitureDTO;
import com.EL.result.Result;
import com.EL.service.FurnitureService;
import com.EL.entity.Furniture;
import com.EL.vo.FurnitureVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/furniture")
@Slf4j
@Api(tags = "Furniture Related Interface")
public class FurnitureController {

    @Autowired
    private FurnitureService furnitureService;

    /**
     * Add Furniture
     */
    @ApiOperation("Add Furniture")
    @PostMapping
    public Result save(@RequestBody FurnitureDTO furnitureDTO) {
        furnitureService.save(furnitureDTO);
        return Result.success();
    }

    /**
     * Show Furniture by Location or UserId
     */
    @ApiOperation("Get Furniture by Location or UserId")
    @GetMapping("/show")
    public Result<List<FurnitureVO>> showFurniture(GetFurnitureDTO getFurnitureDTO) {
        List<FurnitureVO> furnitureList = furnitureService.showFurniture(getFurnitureDTO);
        return Result.success(furnitureList);
    }

    /**
     * Delete Furniture by ID
     */
    @ApiOperation("Delete Furniture")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        furnitureService.delete(id);
        return Result.success();
    }
}
