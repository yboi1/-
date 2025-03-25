package com.sky.service;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;
import org.springframework.stereotype.Service;


public interface SetmealService {
    PageResult<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
}
