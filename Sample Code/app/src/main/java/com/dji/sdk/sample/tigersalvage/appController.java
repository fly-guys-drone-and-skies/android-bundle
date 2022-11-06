import tigersalvage.tiger.*;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import consumers.BaeConsumer;
import org.apache.commons.io.output.ByteArrayOutputStream;
import sender.Sender;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import java.util.zip.InflaterOutputStream;


public class appController {
    void init(){
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Sender.setChannel(connection);

        new missionConsumer(connection);
    }
}
