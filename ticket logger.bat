del msgbox.vbs

@echo off

echo x=msgbox("DO NOT close cmd.exe, Doing so will disrupt program runtime!" ,2+16, "WARNING!") >> msgbox.vbs

start msgbox.vbs

javac LAUNCH.java

java LAUNCH
