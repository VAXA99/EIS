package com.labsfrom6to8.Controller;

import com.labsfrom6to8.Model.Train;
import com.labsfrom6to8.Service.TrainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
@Tag(name = "Train API", description = "API для управления поездами")
public class TrainController {

    private final TrainService trainService;

    // ctor
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    @Operation(summary = "Добавить новый поезд", description = "Добавляет новый поезд в систему")
    public void addTrain(@RequestBody Train train) {
        trainService.addTrain(train);
    }

    @PutMapping
    @Operation(summary = "Обновить поезд", description = "Обновляет информацию о поезде")
    public void updateTrain(@RequestBody Train train) {
        trainService.updateTrain(train);
    }

    @GetMapping
    @Operation(summary = "Получить список активных поездов", description = "Возвращает список всех активных поездов")
    public List<Train> getActiveTrains() {
        return trainService.getActiveTrains();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить поезд", description = "Удаляет поезд по его идентификатору")
    public void deleteTrain(@PathVariable Long id) {
        trainService.deleteTrainById(id);
    }
}
