package io.github.selcukes.example.utils;

import io.github.selcukes.commons.logging.Logger;
import io.github.selcukes.commons.logging.LoggerFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.Optional;

public class EventCapture implements WebDriverListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void afterGetTitle(WebDriver driver, String result) {
        logger.info(() -> String.format("Page title is [%s]", result));
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        logger.info(() -> String.format("Opening URL[%s]", url));
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.info(() -> String.format("Navigating to [%s]", url));
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info(() -> "Clicked on " + element.getText());
    }

    @Override
    public void afterClear(WebElement element) {
        logger.info(() -> "Cleared " + element.getAttribute("title"));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        if (keysToSend != null) {
            Optional<CharSequence> keyChar = Arrays.stream(keysToSend).filter(key -> key instanceof Keys).findFirst();

            if (keyChar.isPresent()) {
                Arrays.stream(Keys.values()).filter(key -> key.equals(keyChar.get()))
                    .findFirst().ifPresent(key -> logger.info(() -> key.name() + " Key Pressed"));
            } else {
                logger.info(() -> (String.format("Entered Text %s in %s Field", Arrays.toString(keysToSend), element.getAttribute("title"))));
            }
        }
    }

    @Override
    public void afterQuit(WebDriver driver) {
        logger.info(() -> "Browser closed");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        logger.info(() -> "Browser Refreshed");
    }


}
