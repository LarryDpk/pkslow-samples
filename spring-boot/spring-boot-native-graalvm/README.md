
Build:
```shell
export GraalVM_HOME=/Users/larry/Software/graalvm-ce-java11-22.3.0/Contents/Home
alias switchOnGraalVM='export PATH=$GraalVM_HOME:$PATH'
alias switchOnGraalVMJavaHome='export JAVA_HOME=/Users/larry/Software/graalvm-ce-java11-22.3.0/Contents/Home'

alias switchOffGraalVM='export PATH=`echo $PATH | tr ":" "\n" | grep -v "graalvm" | tr "\n" ":"`'
alias switchOffGraalVMJavaHome='export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home'

switchOnGraalVM
switchOnGraalVMJavaHome
mvn clean package -Pnative


# build docker image
mvn spring-boot:build-image

```