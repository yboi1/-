package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "食品")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("新增菜品")
    public Result<String> save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品");
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分页查询菜品")
    public Result<PageResult<DishVO>> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("分页查询菜品：{}", dishPageQueryDTO);
        PageResult<DishVO> querySet = dishService.queryPage(dishPageQueryDTO);
        return Result.success(querySet);
    }

    @DeleteMapping
    @ApiOperation("删除菜品")
    public Result<String> delete(@RequestParam List<Long> ids) {
        log.info("删除菜品：{}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("查询菜品")
    public Result<DishVO> findById(@PathVariable Long id) {
        log.info("查询菜品 by id={}", id);
        DishVO dishVO = dishService.GetByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("新增菜品")
    public Result<String> update(@RequestBody DishDTO dishDTO) {
        log.info("更新菜品 {}", dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("status/{status}")
    @ApiOperation("启用/禁用菜品")
    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
        log.info("启用，禁用{}", status);
        dishService.startOrStop(status,id);
        return Result.success();
    }

}
