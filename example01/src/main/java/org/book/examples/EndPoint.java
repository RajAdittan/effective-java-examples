package org.book.examples;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Objects;

public class EndPoint {

    static int [] STANDARD_PORTS = {22, 25, 80, 463, 6443, 8080};

    String hostName;
    int port;

    private EndPoint(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    /*
    Item 1: factory method to create an instance
    * */
    public static EndPoint create(String hostName, int port) {
        // you are able to validate params before object construction
        if(!isValid(hostName)) {
            throw new IllegalArgumentException("specified hostname is invalid");
        }
        if(isStandardPort(port)) {
            throw new IllegalArgumentException("specified port cannot bbe used");
        }
        return new EndPoint(hostName, port);
    }

    static boolean isValid(String hostName) {
        boolean valid=!(Objects.isNull(hostName));
        if (valid) {
            try {
                InetAddress[] addresses = Inet4Address.getAllByName(hostName);
                if(addresses.length <=0) {
                    return false;
                }
            } catch (UnknownHostException e) {
                return false;
            }
        }
        return valid;
    }

    static boolean isStandardPort(int port)  {
        int index = Arrays.binarySearch(STANDARD_PORTS, port);
        return index>=0;
    }

    @Override
    public String toString() { return String.format("%s:%d", hostName, port);}
}
