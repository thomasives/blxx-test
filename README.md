# blxx-test

Example beamline using [ioc-automation1](https://github.com/Observatory-Sciences/ioc-automation1).  To run:

- Build the ioc-automation1:dls.run image following the instructions in the ioc-automation1 README
- Run ./launch.sh automation1

This will start an docker container with an ioc-automation1 instance.  The automation1 records will be prefixed with TRI:AUTO.  This, along with the IP address of the automation1 controller, can be changed by editing the files in ./iocs/automation1/config. 

