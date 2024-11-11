package Lab4_Validation.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeValidatedTrain {

    @NotNull(message = "Название не должно быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Название должно содержать только буквы и пробелы")
    private String name;

    @NotNull(message = "Номер поезда не должен быть пустым")
    @Pattern(regexp = "^\\d{4}$", message = "Номер поезда должен состоять из 4 цифр")
    private String trainNumber;

    @NotNull(message = "Маршрут не должен быть пустым")
    private String route;

    @Min(value = 1, message = "Минимальное количество вагонов должно быть 1")
    @Max(value = 50, message = "Максимальное количество вагонов — 50")
    private int numberOfCars;
}
