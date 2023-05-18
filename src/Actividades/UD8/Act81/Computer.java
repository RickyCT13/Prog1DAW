package Actividades.UD8.Act81;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity(name = "ordenador")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compIdSeq")
    @SequenceGenerator(allocationSize = 10, name = "compIdSeq")
    private int id;

    private String ipAddress, serialNumber;
    private String cpu;
    private BigInteger ramSize, diskSize;
    private Date dateOfPurchase;

    public Computer() {}

    public Computer(String cpu, BigInteger ramSize, BigInteger diskSize, Date dateOfPurchase, String ipAddress, String serialNumber) {
        this.cpu = cpu;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.dateOfPurchase = dateOfPurchase;
        this.ipAddress = ipAddress;
        this.serialNumber = serialNumber;
    }

    public String getCpu() {
        return cpu;
    }

    public BigInteger getRamSize() {
        return ramSize;
    }

    public BigInteger getDiskSize() {
        return diskSize;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRamSize(BigInteger ramSize) {
        this.ramSize = ramSize;
    }

    public void setDiskSize(BigInteger diskSize) {
        this.diskSize = diskSize;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
