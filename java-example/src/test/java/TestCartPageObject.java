import org.junit.Test;

public class TestCartPageObject extends Abstract {

    @Test
    public void cartItemsTest() {
        app.cartItemsAddAndRemove();
    }
}