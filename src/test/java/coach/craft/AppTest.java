package coach.craft;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class AppTest {

    @Test
    void app_runs() {
        assertThatNoException()
                .isThrownBy(App::new);
    }

}