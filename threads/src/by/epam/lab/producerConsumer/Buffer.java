package by.epam.lab.producerConsumer;

import by.epam.lab.utils.Data;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static by.epam.lab.utils.Constants.BUFFER_STR_LENGTH;

public class Buffer {
    private final BlockingQueue<String> sharedQueue;

    public Buffer() throws IOException {
        this.sharedQueue = new LinkedBlockingQueue<>(Integer.parseInt(Data.getProperties(BUFFER_STR_LENGTH)));
    }

    public BlockingQueue<String> getSharedQueue() {
        return sharedQueue;
    }
}
