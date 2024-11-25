package com.EL.service;

import com.EL.dto.FurnitureDTO;
import com.EL.dto.GetFurnitureDTO;
import com.EL.vo.FurnitureVO;

import java.util.List;

public interface FurnitureService {

    void save(FurnitureDTO furnitureDTO);

    List<FurnitureVO> showFurniture(GetFurnitureDTO getFurnitureDTO);

    void delete(Long id);
}
