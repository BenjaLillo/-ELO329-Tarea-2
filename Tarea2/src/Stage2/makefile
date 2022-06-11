JFLAGS = -g
JC = javac
JVM= java
FILE=

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Stage2.java\
	ShadeControlView.java\
	ShadeControl.java\
	RollerShadeView.java\
	RollerShade.java\
	MotorState.java\
	LampView.java\
	LampState.java\
	LampControlView.java\
	LampControl.java\
	Lamp.java\
	DomoticDeviceControl.java\
	DomoticDevice.java\
	Cloud.java

MAIN = Stage2

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class
