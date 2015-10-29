package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException{
    	if(args.length > 0){
    		String host = args[0];
    		InetAddress[] addresses = InetAddress.getAllByName(host);
    		for(InetAddress address:addresses){
    			System.out.println(address);
    		}
    	}else{
    		InetAddress address = InetAddress.getLocalHost();
    		System.out.println(address);
    	}
    }
}
