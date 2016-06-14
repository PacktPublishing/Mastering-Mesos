

import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;
import org.apache.mesos.MesosSchedulerDriver;
import org.apache.mesos.Protos;
import org.apache.mesos.Scheduler;

/**
 * Created by akhld on 16/1/16.
 */

public class PiDriver {

    private final static Logger LOGGER = Logger.getLogger(PiDriver.class);

    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "/target/scala-2.10/mesos-pi-assembly-1.0.jar";

        Protos.CommandInfo.URI uri = Protos.CommandInfo.URI.newBuilder().setValue(path).setExtract(false).build();
	String commandPi = "java -cp mesos-pi-assembly-1.0.jar PiExecutor";
        Protos.CommandInfo piCommandInfo = Protos.CommandInfo.newBuilder().setValue(commandPi).addUris(uri)
                .build();

        Protos.ExecutorInfo piExecutorInfo = Protos.ExecutorInfo.newBuilder()
                                            .setExecutorId(Protos.ExecutorID.newBuilder()
                                            .setValue("CalculatePi")).setCommand(piCommandInfo)
                                            .setName("PiExecutor").setSource("java").build();


        Protos.FrameworkInfo.Builder frameworkBuilder = Protos.FrameworkInfo.newBuilder()
                                                        .setFailoverTimeout(120000).setUser("")
                                                        .setName("PiFramework")
                                                        .setPrincipal("test-framework-java");


        if (System.getenv("MESOS_CHECKPOINT") != null) {
            System.out.println("Enabling checkpoint for the framework");
            frameworkBuilder.setCheckpoint(true);
        }

        Scheduler scheduler = new PiScheduler(piExecutorInfo, 1);

        MesosSchedulerDriver schedulerDriver = new MesosSchedulerDriver(scheduler, frameworkBuilder.build(), args[0]);;


        int status = schedulerDriver.run() == Protos.Status.DRIVER_STOPPED ? 0 : 1;
        schedulerDriver.stop();
        System.exit(status);
    }



}
