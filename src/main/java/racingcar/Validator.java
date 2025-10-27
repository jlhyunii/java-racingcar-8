package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    public static List<String> validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비었습니다.");
        }

        List<String> names = Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.toList());

        if (names.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("자동차 이름이 비었습니다.");
        }

        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        if (names.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }

        Set<String> distinctNames = new HashSet<>(names);
        if (distinctNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }

        return List.copyOf(names);
    }

    public static int validateTryCount(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수가 비어있습니다.");
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        int count = Integer.parseInt(input);
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        return count;
    }
}
