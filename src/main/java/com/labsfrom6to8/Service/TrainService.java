package com.labsfrom6to8.Service;

import com.labsfrom6to8.Mapper.TrainMapper;
import com.labsfrom6to8.Model.Train;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private final TrainMapper trainMapper;

    // ctor
    public TrainService(TrainMapper trainMapper) {
        this.trainMapper = trainMapper;
    }

    // Добавление нового поезда
    public void addTrain(Train train) {
        trainMapper.insertTrain(train);
    }

    // Обновление данных поезда
    public void updateTrain(Train train) {
        trainMapper.updateTrain(train);
    }

    // Получение списка активных поездов
    public List<Train> getActiveTrains() {
        return trainMapper.selectActiveTrains();
    }

    // Удаление поезда
    public void deleteTrainById(Long id) {
        trainMapper.deleteTrain(id);
    }
}
