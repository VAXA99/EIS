package com.labsfrom6to8.Mapper;

import com.labsfrom6to8.Model.Train;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrainMapper {

    @Insert("INSERT INTO trains (name, number, is_active) VALUES (#{name}, #{number}, #{isActive})")
    void insertTrain(Train train);

    @Update("UPDATE trains SET name = #{name}, number = #{number}, is_active = #{isActive} WHERE id = #{id}")
    void updateTrain(Train train);

    @Select("SELECT * FROM trains WHERE is_active = TRUE")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "number", column = "number"),
            @Result(property = "isActive", column = "is_active")
    })
    List<Train> selectActiveTrains();

    @Delete("DELETE FROM trains WHERE id = #{id}")
    void deleteTrain(Long id);
}


