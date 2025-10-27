package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            printRoundResult();
        }

        printWinners();
    }

    private void printRoundResult() {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }

        System.out.println();
    }

    private void printWinners() {
        List<String> winners = findWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> findWinners() {
        int maxPosition = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
