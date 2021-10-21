cd "$(TOP)"

dbLoadDatabase "dbd/ioc.dbd"
ioc_registerRecordDeviceDriver(pdbbase)

dbLoadRecords("motorUtil.db", "P=automation1:")

Automation1CreateController("Automation1", "10.2.2.167", 4, 100, 1000)

Automation1CreateProfile("Automation1", 2000)
# dbLoadTemplate "motor.substitutions.automation1"
# 

dbLoadRecords("basic_asyn_motor.template", "P=Auto1:, N=1, M=m1, DTYP=asynMotor, PORT=Automation1, ADDR=0, DESC=X Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=Auto1:, N=2, M=m2, DTYP=asynMotor, PORT=Automation1, ADDR=0, DESC=X Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=Auto1:, N=3, M=m3, DTYP=asynMotor, PORT=Automation1, ADDR=0, DESC=X Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=Auto1:, N=4, M=m4, DTYP=asynMotor, PORT=Automation1, ADDR=0, DESC=X Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")

dbLoadRecords("profileMoveController.template", "P=Auto1:, R=pm1:, PORT=Automation1, NAXES=4, NPOINTS=2000, NPULSES=2000, TIMEOUT=1")

dbLoadRecords("profileMoveAxis.template", "P=Auto1:, R=pm1:, M=1, PORT=Automation1, ADDR=0, NPOINTS=200, NREADBACK=2000, MOTOR=Auto1:m1, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=Auto1:, R=pm1:, M=2, PORT=Automation1, ADDR=1, NPOINTS=200, NREADBACK=2000, MOTOR=Auto1:m2, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=Auto1:, R=pm1:, M=3, PORT=Automation1, ADDR=2, NPOINTS=200, NREADBACK=2000, MOTOR=Auto1:m3, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=Auto1:, R=pm1:, M=4, PORT=Automation1, ADDR=3, NPOINTS=200, NREADBACK=2000, MOTOR=Auto1:m4, PREC=3, TIMEOUT=1")

dbLoadRecords("asynRecord.db", "P=Auto1:, R=asyn1, PORT=Automation1, ADDR=0, OMAX=256, IMAX=256")

# start IOC shell
iocInit

motorUtilInit("automation1:")
