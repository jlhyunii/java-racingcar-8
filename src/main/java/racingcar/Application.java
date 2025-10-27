package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = GameInput.readCarnames();
        int tryCount = GameInput.readTryCount();

        Cars cars = new Cars(names);

        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            printRoundResult(cars);
        }
    }

    private static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }

        System.out.println();
    }
}
