package com.EL.service.impl;

import com.EL.dto.FurnitureDTO;
import com.EL.dto.GetFurnitureDTO;
import com.EL.entity.Furniture;
import com.EL.mapper.FurnitureMapper;
import com.EL.service.FurnitureService;
import com.EL.vo.FurnitureVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    @Autowired
    private FurnitureMapper furnitureMapper;

    @Override
    public void save(FurnitureDTO furnitureDTO) {
        Furniture furniture = new Furniture();
        BeanUtils.copyProperties(furnitureDTO, furniture);
        furniture.setCreateTime(LocalDateTime.now());
        furniture.setUpdateTime(LocalDateTime.now());
        furnitureMapper.insert(furniture);
    }

    @Override
    public List<FurnitureVO> showFurniture(GetFurnitureDTO getFurnitureDTO) {
        List<Furniture> furnitureList = furnitureMapper.getFurniture(getFurnitureDTO.getLocation(), getFurnitureDTO.getName());
        return furnitureList.stream().map(furniture -> {
            FurnitureVO vo = new FurnitureVO();
            BeanUtils.copyProperties(furniture, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        furnitureMapper.delete(id);
    }
}
