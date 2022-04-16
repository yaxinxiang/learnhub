package networkprogramming;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    @Test
    public void InetAddressClassTest() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println(localHost.getHostAddress());
        System.out.println(Arrays.toString(localHost.getAddress()));
        System.out.println(localHost.getCanonicalHostName());
        System.out.println(localHost.getHostName());

        System.out.println(InetAddress.getLoopbackAddress());

        System.out.println("======================================");
        InetAddress host = InetAddress.getByName("www.baidu.com");
        System.out.println(host.getHostAddress());
        System.out.println(Arrays.toString(host.getAddress()));
        System.out.println(host.getCanonicalHostName());
        System.out.println(host.getHostName());
    }
}
