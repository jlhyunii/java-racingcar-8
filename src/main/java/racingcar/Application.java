package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = GameInput.readCarnames();
        int tryCount = GameInput.readTryCount();

        Cars cars = new Cars(names);

        RacingGame racingGame = new RacingGame(cars, tryCount);
        racingGame.start();
    }
}
