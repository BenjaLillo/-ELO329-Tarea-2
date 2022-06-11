JFLAGS = -g
JC = javac
JVM= java
FILE=

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Stage1.java\
	LampView.java\
	LampState.java\
	LampControlView.java\
	LampControl.java\
	Lamp.java\
	DomoticDeviceControl.java\
	DomoticDevice.java\
	Cloud.java

MAIN = Stage1

default: classes
#

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class
