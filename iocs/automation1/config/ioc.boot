cd "$(TOP)"

dbLoadDatabase "dbd/ioc.dbd"
ioc_registerRecordDeviceDriver(pdbbase)

dbLoadRecords("motorUtil.db", "P=TRI:AUTO:")

# Automation1CreateController("Automation1", "10.2.2.167", 4, 100, 1000)
Automation1CreateController("Automation1", "10.2.2.199", 4, 100, 1000)

Automation1CreateProfile("Automation1", 2000)

dbLoadRecords("basic_asyn_motor.template", "P=TRI:AUTO:, N=1, M=M1, DTYP=asynMotor, PORT=Automation1, ADDR=0, DESC=X Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=TRI:AUTO:, N=2, M=M2, DTYP=asynMotor, PORT=Automation1, ADDR=1, DESC=Y Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=TRI:AUTO:, N=3, M=M3, DTYP=asynMotor, PORT=Automation1, ADDR=2, DESC=Z Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")
dbLoadRecords("basic_asyn_motor.template", "P=TRI:AUTO:, N=4, M=M4, DTYP=asynMotor, PORT=Automation1, ADDR=3, DESC=U Axis, EGU=mm, DIR=Pos, VELO=2.0, VBAS=0.1, ACCL=0.2, BDST=0, BVEL=1, BACC=0.2, MRES=0.001, PREC=3, DHLM=16, DLLM=0, INIT=")

dbLoadRecords("profileMoveController.template", "P=TRI:AUTO:, R=PM1:, PORT=Automation1, NAXES=4, NPOINTS=2000, NPULSES=2000, TIMEOUT=1")

dbLoadRecords("profileMoveAxis.template", "P=TRI:AUTO:, R=PM1:, M=1, PORT=Automation1, ADDR=0, NPOINTS=2000, NREADBACK=2000, MOTOR=TRI:AUTO:M1, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=TRI:AUTO:, R=PM1:, M=2, PORT=Automation1, ADDR=1, NPOINTS=2000, NREADBACK=2000, MOTOR=TRI:AUTO:M2, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=TRI:AUTO:, R=PM1:, M=3, PORT=Automation1, ADDR=2, NPOINTS=2000, NREADBACK=2000, MOTOR=TRI:AUTO:M3, PREC=3, TIMEOUT=1")
dbLoadRecords("profileMoveAxis.template", "P=TRI:AUTO:, R=PM1:, M=4, PORT=Automation1, ADDR=3, NPOINTS=2000, NREADBACK=2000, MOTOR=TRI:AUTO:M4, PREC=3, TIMEOUT=1")

dbLoadRecords("asynRecord.db", "P=TRI:AUTO:, R=ASYN, PORT=Automation1, ADDR=0, OMAX=256, IMAX=256")

# start IOC shell
iocInit

motorUtilInit("TRI:AUTO:")


