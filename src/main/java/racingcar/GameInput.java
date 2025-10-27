package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameInput {
    public static List<String> readCarnames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> names = Validator.validateCarNames(input);
        Cars cars = new Cars(names);
        return names;
    }
}
