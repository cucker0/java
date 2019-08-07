/*
java 异常

java.lang.Throwable
## 分类
* Error 错误，程序中不进行处理
* Exception 异常，要求在编写程序时，就要考虑到这些异常的处理



## Exception
* 编译时异常，在编译期间会出现的异常（执行javac 命令时，出现异常）
    Exception的子类中除了RuntimeException以外的
* 运行时异常（执行java命令时，出现异常）
    RuntimeException的所有子类

## 异常特点
* 执行一个程序时，如果出现异常，那么异常后面的代码就不再执行


## Error
AnnotationFormatError,
AssertionError,
AWTError,
CoderMalfunctionError,
FactoryConfigurationError,
FactoryConfigurationError,
IOError,
LinkageError,
SchemaFactoryConfigurationError,
ServiceConfigurationError,
ThreadDeath,
TransformerFactoryConfigurationError,
VirtualMachineError

## Exception
### 编译时异常
AclNotFoundException,
ActivationException,
AlreadyBoundException,
ApplicationException,
AWTException,
BackingStoreException,
BadAttributeValueExpException,
BadBinaryOpValueExpException,
BadLocationException,
BadStringOperationException,
BrokenBarrierException,
CertificateException,
CloneNotSupportedException,
DataFormatException,
DatatypeConfigurationException,
DestroyFailedException,
ExecutionException,
ExpandVetoException,
FontFormatException,
GeneralSecurityException,
GSSException,
IllegalClassFormatException,
InterruptedException,
IntrospectionException,
InvalidApplicationException,
InvalidMidiDataException,
InvalidPreferencesFormatException,
InvalidTargetObjectTypeException,
IOException,
JAXBException,
JMException,
KeySelectorException,
LambdaConversionException,
LastOwnerException,
LineUnavailableException,
MarshalException,
MidiUnavailableException,
MimeTypeParseException,
MimeTypeParseException,
NamingException,
NoninvertibleTransformException,
NotBoundException,
NotOwnerException,
ParseException,
ParserConfigurationException,
PrinterException,
PrintException,
PrivilegedActionException,
PropertyVetoException,
ReflectiveOperationException,
RefreshFailedException,
RemarshalException,
SAXException,
ScriptException,
ServerNotActiveException,
SOAPException,
SQLException,
TimeoutException,
TooManyListenersException,
TransformerException,
TransformException,
UnmodifiableClassException,
UnsupportedAudioFileException,
UnsupportedCallbackException,
UnsupportedFlavorException,
UnsupportedLookAndFeelException,
URIReferenceException,
URISyntaxException,
UserException,
XAException,
XMLParseException,
XMLSignatureException,
XMLStreamException,
XPathException


### 运行时异常
AnnotationTypeMismatchException,
ArithmeticException,
ArrayStoreException,
BufferOverflowException,
BufferUnderflowException,
CannotRedoException,
CannotUndoException,
ClassCastException,
CMMException,
CompletionException,
ConcurrentModificationException,
DataBindingException,
DateTimeException,
DOMException,
EmptyStackException,
EnumConstantNotPresentException,
EventException,
FileSystemAlreadyExistsException,
FileSystemNotFoundException,
IllegalArgumentException,
IllegalMonitorStateException,
IllegalPathStateException,
IllegalStateException,
IllformedLocaleException,
ImagingOpException,
IncompleteAnnotationException,
IndexOutOfBoundsException,
JMRuntimeException,
LSException,
MalformedParameterizedTypeException,
MalformedParametersException,
MirroredTypesException,
MissingResourceException,
NegativeArraySizeException,
NoSuchElementException,
NoSuchMechanismException,
NullPointerException,
ProfileDataException,
ProviderException,
ProviderNotFoundException,
RasterFormatException,
RejectedExecutionException,
SecurityException,
SystemException,
TypeConstraintException,
TypeNotPresentException,
UncheckedIOException,
UndeclaredThrowableException,
UnknownEntityException,
UnmodifiableSetException,
UnsupportedOperationException,
WebServiceException,
WrongMethodTypeException


* */

package com.java.exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ExceptionTest {

    // InputMismatchException 输入类型不匹配
    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i16 = sc.nextInt(); // 当输入的不是整数时报错
        System.out.println(i16);
    }

    // ArrayIndexOutOfBoundsException 数组下标越界
    @Test
    public void test2() {
        int[] iarr = new int[3];
        System.out.println(iarr[3]);
    }

    // ArithmeticException 算术异常
    @Test
    public void test3() {
        System.out.println(10/0);
    }

    // ClassCastException 类转换异常
    @Test
    public void Test4() {
        Object b = true;
        String s = (String) b;
        System.out.println(s);
    }

    // NullPointerException 空指针异常
    @Test
    public void Test5() {
        Person p1 = new Person();
        p1 = null;
        System.out.println(p1.toString());

        System.out.println("abc");
    }

    // 编译时异常
    @Test
    public void test6() throws Exception { // 为让编译通过，可抛出错误 public void test6() {
        FileInputStream fp = new FileInputStream(new File("hello.txt"));
        int b;
        while ((b = fp.read()) != -1) {
            System.out.println((char) b);
        }
        fp.close();
    }
}

class Person {
    private String name;

}
