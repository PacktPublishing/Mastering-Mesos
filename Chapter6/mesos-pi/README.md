# Mesos-pi
Sample mesos framework to compute the value of Pi
### Usage
Follow the below steps:
```sh
* $ git clone https://github.com/akhld/mesos-pi.git
* $ cd mesos-pi
* $ sbt assembly
* $ sbt 'run 127.0.0.1:5050'

Multiple main classes detected, select one to run:
 [1] PiDriver
 [2] PiExecutor

Enter number: 1
```

## Output

```scala
[info] Running PiDriver 127.0.0.1:5050
Warning: MESOS_NATIVE_LIBRARY is deprecated, use MESOS_NATIVE_JAVA_LIBRARY instead. Future releases will not support JNI bindings via MESOS_NATIVE_LIBRARY.
I0116 09:50:28.934458 11323 sched.cpp:166] Version: 0.26.0
I0116 09:50:28.947173 11325 sched.cpp:264] New master detected at master@127.0.0.1:5050
I0116 09:50:28.948187 11325 sched.cpp:274] No credentials provided. Attempting to register without authentication
I0116 09:50:28.953325 11329 sched.cpp:643] Framework registered with 8d3aafcd-8d09-4961-afd8-c17f4af0ec90-0003
log4j:WARN No appenders could be found for logger (PiScheduler).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.

Value of PI=3.141592642478473 after 90000000

I0116 09:50:30.822546 11328 sched.cpp:1805] Asked to stop the driver
I0116 09:50:30.822863 11328 sched.cpp:1043] Stopping framework '8d3aafcd-8d09-4961-afd8-c17f4af0ec90-0003'
I0116 09:50:30.823822 11323 sched.cpp:1805] Asked to stop the driver

Exception: sbt.TrapExitSecurityException thrown from the UncaughtExceptionHandler in thread "run-main-0"
[success] Total time: 3 s, completed Jan 16, 2016 9:50:30 AM
```
 




