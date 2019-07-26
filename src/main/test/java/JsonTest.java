import lombok.extern.slf4j.Slf4j;
import org.bigplayer.skysoil.service.impl.SkySoilServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@Slf4j
public class JsonTest {

    @Autowired
    SkySoilServiceImpl skySoilService;
    @Test
    public  void  getDoubleData(){
        skySoilService.getDoubleData();
    }


    @Test
    public void testnio() throws ExecutionException, InterruptedException {
        Path path= Paths.get("D:\\file1.txt");
        //异步打开通道
        try (AsynchronousFileChannel channel=AsynchronousFileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(1000000000);
            Future<Integer> future=channel.read(buffer,0);
            log.info(String.valueOf(future.get()));
            System.out.print("执行其他1");
            log.info(String.valueOf(future.get()));
            System.out.print("执行其他2");
            log.info(String.valueOf(future.get()));
            System.out.print("执行其他3");
            log.info(String.valueOf(future.get()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    非阻塞 io 回调式通知
    @Test
    public void testnioa() throws ExecutionException, InterruptedException {
        Path path= Paths.get("D:\\file1.txt");
        //异步打开通道
        try (AsynchronousFileChannel channel=AsynchronousFileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(1000000000);
            channel.read(buffer,0,buffer,new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("执行完毕后执行这里的方法");
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("失败后执行这里的方法");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
